package controller;

import model.beans.admin.Community;
import model.daos.CommunityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {

    CommunityDAO dao = new CommunityDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String render(ModelMap model) {
        try {
            List<Community> communities = dao.getCommunities();
            model.addAttribute("communities", communities);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "community";
    }
}
