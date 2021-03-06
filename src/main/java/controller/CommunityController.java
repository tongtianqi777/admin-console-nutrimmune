package controller;

import model.beans.admin.Community;
import model.daos.AdminDeviceDAO;
import model.daos.CommunityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {

    CommunityDAO dao = new CommunityDAO();
    AdminDeviceDAO deviceDAO = new AdminDeviceDAO();

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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCommunity (@PathVariable int id, ModelMap model) {
        Community community = null;

        try {
            community = dao.getCommunity(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("community", community);

        return "edit/community";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCommunity (@ModelAttribute("community") Community form, ModelMap model) {
        try {
            dao.update(form);
            List<Community> communities = dao.getCommunities();
            model.addAttribute("communities", communities);
            model.addAttribute("success_message", "You successfully updated the entity.\n");


        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        return "community";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody String deleteCommunity (@RequestParam("id") int id) {
        try {
            deviceDAO.removeCommunity(id);
            dao.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String rendarAddCommunity () {
        return "add/community";
    }

    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String addCommunity (@ModelAttribute("community") Community form, ModelMap model) {
        try {
            dao.add(form);
        } catch (SQLException e) {
            e.printStackTrace();
            return "add/fail";
        }

        return "redirect:/community";
    }


}
