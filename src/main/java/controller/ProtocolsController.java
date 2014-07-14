package controller;

import model.daos.ProtocolDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/protocols")
public class ProtocolsController {
    ProtocolDAO dao = new ProtocolDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showProtocols(ModelMap model) {
        try {
            model.addAttribute("protocols", dao.getAllProtocols());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "protocols";
    }
}