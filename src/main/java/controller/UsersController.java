package controller;

import model.daos.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.SQLException;

@Controller
@RequestMapping("/users")
public class UsersController {
    UserDAO dao = new UserDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model, Principal principal) {

        try {
            model.addAttribute("users", dao.getUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "users";
    }
}