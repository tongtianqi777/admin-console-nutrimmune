package controller;

import com.ntm.postgres.Protocol;
import com.ntm.postgres.UserCollabServer;
import model.daos.AdminDeviceDAO;
import model.daos.AdminProtocolDAO;
import model.daos.AdminUserDAO;
import model.daos.CommunityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
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

            //TODO Tianqi know what to do?
            for (int i = 0; i < usersList.size(); i++) {
                for (int j = 0; j < protocolsList.size(); j++) {
                    usersList.get(i);
                    protocolsList.get(i);
                }
            }


            model.addAttribute("users", usersList);
            model.addAttribute("protocols", protocolsList);
            model.addAttribute("devices", deviceDAO.getAllDevices());
            model.addAttribute("communities", communityDAO.getCommunities());


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "overview";
    }
}
