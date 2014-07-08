package controller;

import model.daos.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class HelloController {
    UserDAO dao = new UserDAO();

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        try {
            model.addAttribute("message", "Sankha's Address is: " + dao.getUser("sankhasp@cmu.edu").getAddress());
            model.addAttribute("message2", "Go Kiss His Ass!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "hello";
	}
}