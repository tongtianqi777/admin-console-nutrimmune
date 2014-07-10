package controller;

import model.daos.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class UsersController {
    UserDAO dao = new UserDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        try {
            model.addAttribute("users", dao.getUser("sankhasp@cmu.edu").getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}