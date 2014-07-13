package controller;

import model.daos.ResearcherDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.SQLException;

@Controller
@RequestMapping("/users")
public class UserController {
    ResearcherDAO dao = new ResearcherDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model, Principal principal) {

        try {
            model.addAttribute("users", dao.getAllResearchers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "users";
    }
}