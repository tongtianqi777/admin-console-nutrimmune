package controller;

import model.beans.Researcher;
import model.beans.Protocol;
import model.daos.CommunityDAO;
import model.daos.DeviceDAO;
import model.daos.ProtocolDAO;
import model.daos.ResearcherDAO;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Rix on 7/12/14.
 */
@Controller
@RequestMapping("/")
public class OverviewController {
    ResearcherDAO user_dao = new ResearcherDAO();
    ProtocolDAO protocol_dao = new ProtocolDAO();
    DeviceDAO device_dao = new DeviceDAO();
    CommunityDAO community_dao = new CommunityDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model) {

        try {
            List<Researcher> usersList = user_dao.getAllResearchers();
            List<Protocol> protocolsList = protocol_dao.getAllProtocols();


            
            for (int i = 0; i < usersList.size(); i++) {
                for (int j = 0; j < protocolsList.size(); j++) {
                    usersList.get(i);
                    protocolsList.get(i);
                }
            }


            model.addAttribute("users", usersList);
            model.addAttribute("protocols", protocolsList);
            model.addAttribute("devices", device_dao.getAllDevices());
            model.addAttribute("communities", community_dao.getCommunities());




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "overview";
    }
}
