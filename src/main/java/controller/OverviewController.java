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
            List<UserCollabServer> users = userDAO.getAllUsers();
            List<Protocol> protocols = protocolDAO.getAllProtocols();
            List<Device> devices = deviceDAO.getAllDevices();
            List<Community> communities = communityDAO.getCommunities();

            String statistics = getStatisticsByNow(Timeframe.MONTH, devices, protocols);
            model.addAttribute("statistics", statistics);

            model.addAttribute("users", users);
            model.addAttribute("protocols", protocols);
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
                "date": "January 2014",
				"devices": 10,
                "protocols": 20
            },
            {
                "date": "February 2014",
				"devices": 10,
                "protocols": 30
            },
            {
                "date": "March 2014",
				"devices": 10,
                "protocols": 40,
				"dashLengthColumn": 5,
				"alpha":0.2,
				"additional":"(projection)"
            }
    ]
     */
    private String getStatisticsByNow (
            Timeframe timeframe,
            List<Device> devices,
            List<Protocol> protocols) {

        switch (timeframe) {
            case MONTH: return getMonthStatistics(devices, protocols, 12);
        }

        return null;
    }

    private String getMonthStatistics (
            List<Device> devices,
            List<Protocol> protocols,
            int timeframeLength
            ) {

        //get the current calendar
        Calendar thisMonth = Calendar.getInstance();

        //get the calendar of the 1st day of the month before time frame
        //e.g. it's Aug 10th 2014 now, and the time frame is 12, the lowerBound would be Sep 1st 2013
        Calendar lowerBound = Calendar.getInstance();
        lowerBound.add(Calendar.MONTH, -timeframeLength + 1);
        lowerBound.set(Calendar.DAY_OF_MONTH, 0);

        //protocolNum[i] is the number of protocols in month: previous month - i
        int[] protocolNum = new int[timeframeLength];
        int[] deviceNum = new int[timeframeLength];

        //iterate all the protocols to calculate the statistics
        for (Protocol protocol : protocols) {
            Calendar createdTime = Calendar.getInstance();
            createdTime.setTimeInMillis(protocol.getCreated().getTime());

            if (createdTime.before(lowerBound)) {
                protocolNum[timeframeLength - 1]++;

            } else {
                int diffYear = thisMonth.get(Calendar.YEAR) - createdTime.get(Calendar.YEAR);
                int diffMonth = diffYear * 12 + thisMonth.get(Calendar.MONTH) - createdTime.get(Calendar.MONTH);
                protocolNum[diffMonth]++;
            }
        }

        //iterate all the devices to calculate the statistics
        for (Device device : devices) {
            Calendar createdTime = Calendar.getInstance();
            createdTime.setTimeInMillis(device.getShipdate().getTime());

            if (createdTime.before(lowerBound)) {
                deviceNum[timeframeLength - 1]++;

            } else {
                int diffYear = thisMonth.get(Calendar.YEAR) - createdTime.get(Calendar.YEAR);
                int diffMonth = diffYear * 12 + thisMonth.get(Calendar.MONTH) - createdTime.get(Calendar.MONTH);
                deviceNum[diffMonth]++;
            }
        }


        //add up the numbers of each month
        for (int i = timeframeLength - 2; i >= 0; i--) {
            protocolNum[i] = protocolNum[i] + protocolNum[i + 1];
            deviceNum[i] = deviceNum[i] + deviceNum[i + 1];
        }

        JsonArray jsonArray = new JsonArray();

        //iterate through each month, and add the keys and values to the json array
        for (int i = timeframeLength - 1; i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(thisMonth.getTimeInMillis());
            calendar.add(Calendar.MONTH, -i);

            //convert the month integer to description. e.g: 0 -> Jan, 1 -> Feb
            String month = getMonthStr(calendar.get(Calendar.MONTH) + 1);
            String calendarStr = month + " " + calendar.get(Calendar.YEAR);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(
                    "date", calendarStr
            );
            jsonObject.addProperty(
                    "protocols", protocolNum[i]
            );

            jsonObject.addProperty(
                    "devices", deviceNum[i]
            );

            jsonArray.add(jsonObject);
        }

        //add more description to the last json object
        //to make the last object looks different
        jsonArray.get(jsonArray.size() - 1).getAsJsonObject().addProperty("dashLengthColumn", 5);
        jsonArray.get(jsonArray.size() - 1).getAsJsonObject().addProperty("alpha", 0.2);
        jsonArray.get(jsonArray.size() - 1).getAsJsonObject().addProperty("additional", "(projection)");

        return jsonArray.toString();
    }

    private String getMonthStr(int monthInt) {
        switch (monthInt) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
        }

        return "";
    }

    public enum Timeframe {
        MONTH, WEEK
    }
}
