package controller;

import model.daos.DeviceDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Rix on 7/12/14.
 */

@Controller
@RequestMapping("/devices")
public class DevicesController {
    DeviceDAO dao = new DeviceDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showDevices(ModelMap model) {

        try {
            model.addAttribute("devices", dao.getAllDevices());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "devices";
    }
}
