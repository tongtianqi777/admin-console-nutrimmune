package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ntm.postgres.Device;
import com.ntm.postgres.Protocol;
import com.ntm.postgres.UserCollabServer;
import model.beans.admin.Community;
import model.daos.AdminDeviceDAO;
import model.daos.AdminProtocolDAO;
import model.daos.AdminUserDAO;
import model.daos.CommunityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/")
public class OverviewController {
    AdminUserDAO userDAO = new AdminUserDAO();
    AdminProtocolDAO protocolDAO = new AdminProtocolDAO();
    AdminDeviceDAO deviceDAO = new AdminDeviceDAO();
    CommunityDAO communityDAO = new CommunityDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model) {

        try {
            List<UserCollabServer> usersList = userDAO.getAllUsers();
            List<Protocol> protocolsList = protocolDAO.getAllProtocols();
            List<Device> devices = deviceDAO.getAllDevices();
            List<Community> communities = communityDAO.getCommunities();

            //debug:
            String statistics = getStatisticsByNow(Timeframe.MONTH, usersList, protocolsList);
            model.addAttribute("statistics", statistics);

            model.addAttribute("users", usersList);
            model.addAttribute("protocols", protocolsList);
            model.addAttribute("devices", devices);
            model.addAttribute("communities", communities);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "overview";
    }

    /*
    Return data format:
    [
            {
                "date": "1 2014",
                "protocols": 20
            },
            {
                "date": "2 2014",
                "protocols": 30
            },
            {
                "date": "3 2014",
                "protocols": 40
            }
    ]
     */
    private String getStatisticsByNow (
            Timeframe timeframe,
            List<UserCollabServer> users,
            List<Protocol> protocols) {

        switch (timeframe) {
            case MONTH: return getMonthStatistics(users, protocols, 6);
        }

        return null;
    }

    private String getMonthStatistics (
            List<UserCollabServer> users,
            List<Protocol> protocols,
            int timeframeLength
            ) {

        Calendar previousMonth = Calendar.getInstance();
        previousMonth.add(Calendar.MONTH, -1);
        System.out.println(previousMonth);

        Calendar lowerBound = Calendar.getInstance();
        lowerBound.add(Calendar.MONTH, -timeframeLength);
        lowerBound.set(Calendar.DAY_OF_MONTH, 0);
        System.out.println(lowerBound);

        //protocolNum[i] is the number of protocols in month: previous month - i
        int[] protocolNum = new int[timeframeLength];

        for (Protocol protocol : protocols) {
            Calendar createdTime = Calendar.getInstance();
            createdTime.setTimeInMillis(protocol.getCreated().getTime());
            System.out.println("Created TImee:  " + createdTime);

            if (createdTime.before(lowerBound)) {
                protocolNum[timeframeLength - 1]++;

            } else {
                int diffYear = previousMonth.get(Calendar.YEAR) - createdTime.get(Calendar.YEAR);
                int diffMonth = diffYear * 12 + previousMonth.get(Calendar.MONTH) - createdTime.get(Calendar.MONTH);
                protocolNum[diffMonth]++;
            }
        }

        for (int i = protocolNum.length - 2; i >= 0; i--) {
            protocolNum[i] = protocolNum[i] + protocolNum[i + 1];
        }

        JsonArray jsonArray = new JsonArray();

        //iterate through each month
        for (int i = protocolNum.length - 1; i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(previousMonth.getTimeInMillis());
            calendar.add(Calendar.MONTH, -i);

            int month = calendar.get(Calendar.MONTH) + 1;

            String calendarStr = month + " " + calendar.get(Calendar.YEAR);

            JsonObject jsonElement = new JsonObject();
            jsonElement.addProperty(
                    "date", calendarStr
            );
            jsonElement.addProperty(
                    "protocols", protocolNum[i]
            );

            jsonArray.add(jsonElement);
        }

        return jsonArray.toString();
    }

    public enum Timeframe {
        MONTH, WEEK
    }
}
