package controller;

import model.beans.Researcher;
import model.beans.csv.ResearcherCSV;
import model.daos.ResearcherDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

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

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllUserCsv (HttpServletResponse response) throws SQLException, IOException {
        String fileName = "users.csv";

        response.setContentType("text/csv");

        List<Researcher> researchers = dao.getAllResearchers();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {
                "id",
                "username",
                "password",
                "deviceId",
                "status",
                "firstname",
                "lastname",
                "address",
                "country",
                "phone",
                "state",
                "zip",
                "lastlogin"
        };

        csvWriter.writeHeader(header);

        for (Researcher researcher : researchers) {
            ResearcherCSV researcherCSV = new ResearcherCSV(researcher);
            csvWriter.write(researcherCSV, header);
        }

        csvWriter.close();
    }
}