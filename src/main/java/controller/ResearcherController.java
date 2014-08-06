package controller;

import com.ntm.postgres.Protocol;
import com.ntm.postgres.UserCollabServer;
import controller.forms.ResearcherForm;
import model.daos.AdminUserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import utils.CSVUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/researcher")
public class ResearcherController {
    AdminUserDAO dao = new AdminUserDAO();
    CSVUtils<UserCollabServer> csvUtils = new CSVUtils<UserCollabServer>();

    @RequestMapping(method = RequestMethod.GET)
    public String showResearchers(ModelMap model, Principal principal) {

        try {
            model.addAttribute("users", dao.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editResearcher(@PathVariable int id, ModelMap model) {
        UserCollabServer user = null;

        try {
            user = dao.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("researcher", user);

        return "edit/user";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateResearcher(@ModelAttribute("researcherForm") ResearcherForm form, ModelMap model) {
        try {
            dao.updateResearcher(form);
            model.addAttribute("users", dao.getAllUsers());
            model.addAttribute("success_message", "You successfully updated the entity.\n");

        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        return "users";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewResearcher(@PathVariable int id, ModelMap model) {
        UserCollabServer user = null;

        try {
            user = dao.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("researcher", user);

        return "view/user";
    }

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllUserCsv(HttpServletResponse response) throws SQLException, IOException {
        String fileName = "users.csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                fileName);
        response.setHeader(headerKey, headerValue);

        List<UserCollabServer> researchers = dao.getAllUsers();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {
                "id",
                "login",
                "address",
                "affiliation",
                "phone",
                "country",
                "firstname",
                "lastlogin",
                "lastname",
                "password",
                "state",
                "timezone",
                "zip",
                "role",
                "token",
                "expiry",
                "remote",
                "status"
        };

        csvWriter.writeHeader(header);

        for (UserCollabServer user : researchers) {
            csvWriter.write(user, header);
        }

        csvWriter.close();
    }

    @RequestMapping(value = "/importcsv", method = RequestMethod.POST)
    public String importCsv(@RequestParam("file") MultipartFile file, ModelMap model) {

        if (file.isEmpty()) {
            model.addAttribute("info", "The file is empty. Please make sure you selected a file.");
            return "import/failed";
        }

        List<String> errors = new ArrayList<String>();
        List<UserCollabServer> users = csvUtils.readCSV(file, getProcessors(), UserCollabServer.class, errors);

        if (errors.size() > 0) {
            model.addAttribute("info", errors.get(0));
            return "import/failed";
        }

        try {
            dao.importCSV(users);
            return "import/success";

        } catch (SQLException e) {
            model.addAttribute("info", "A problem occurred when we tried to update the database. Please verify the data fulfills the requirement.");
            return "import/failed";
        }
    }

    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseInt()), // id (must be unique)
                new NotNull(), // login
                new NotNull(), // address
                new NotNull(), // affiliation
                new NotNull(), // phone
                new NotNull(), // country
                new NotNull(), // firstname
                new Optional(), // lastlogin
                new Optional(), // lastname
                new Optional(), // password
                new Optional(), // state
                new Optional(), // timezone
                new Optional(new ParseInt()), // zip
                new NotNull(), //role
                new NotNull(), // token
                new NotNull(), // expiry
                new NotNull(), // remote
                new NotNull() // status
        };

        return processors;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteResearcher (@RequestParam("id") int id) {
        try {
            dao.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }
}