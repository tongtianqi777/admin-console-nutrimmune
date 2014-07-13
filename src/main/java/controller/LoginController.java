package controller;

import model.daos.ResearcherDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    public static final String SECURITY_CHECK_URL = "security";
    ResearcherDAO dao = new ResearcherDAO();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login (
            @RequestParam(value = "msg", required = false) String msg
            ) {

        ModelAndView model = new ModelAndView();
        if (msg != null) {
            model.addObject("login_msg", "Invalid username and password.");
        }
        model.addObject("security_check_url", SECURITY_CHECK_URL);
        model.setViewName("login");

        return model;
	}


}