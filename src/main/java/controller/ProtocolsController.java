package controller;

import com.ntm.postgres.Protocol;
import controller.forms.ProtocolForm;
import model.daos.AdminProtocolDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.CSVUtils;

import java.sql.SQLException;

@Controller
@RequestMapping("/protocols")
public class ProtocolsController {
    AdminProtocolDAO dao = new AdminProtocolDAO();
    CSVUtils<Protocol> csvUtils = new CSVUtils<Protocol>();

    @RequestMapping(method = RequestMethod.GET)
    public String showProtocols(ModelMap model) {
        try {
            model.addAttribute("protocols", dao.getAllProtocols());
            model.addAttribute("test", "succ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "protocols";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editProtocol (@PathVariable String id, ModelMap model) {
        Protocol protocol = null;

        try {
            protocol = dao.getProtocolById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("protocol", protocol);

        return "edit/protocol";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateResearcher(@ModelAttribute("protocolForm") ProtocolForm form, ModelMap model) {
//        try {
//            dao.updateProtocol(form);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "edit/fail";
//        }

        return "edit/success";
    }

}