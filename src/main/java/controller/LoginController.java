package controller;

import model.daos.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
    UserDAO dao = new UserDAO();

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        model.addAttribute("message", "hey");
        return "login";
	}
}