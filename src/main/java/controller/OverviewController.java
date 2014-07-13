package controller;

import model.daos.DeviceDAO;
import model.daos.ProtocolDAO;
import model.daos.ResearcherDAO;
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

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model) {

        try {
            model.addAttribute("users", user_dao.getAllResearchers());
            model.addAttribute("protocols", protocol_dao.getProtocols());
            model.addAttribute("devices", device_dao.getAllDevices());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "overview";
    }
}
