package controller;

import controller.forms.ResearcherForm;
import model.beans.Researcher;
import model.beans.csv.ResearcherCSV;
import model.daos.ResearcherDAO;
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
    ResearcherDAO dao = new ResearcherDAO();
    CSVUtils<ResearcherCSV> csvUtils = new CSVUtils<ResearcherCSV>();

    @RequestMapping(method = RequestMethod.GET)
    public String showResearchers(ModelMap model, Principal principal) {

        try {
            model.addAttribute("users", dao.getAllResearchers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editResearcher(@PathVariable int id, ModelMap model) {
        Researcher researcher = null;

        try {
            researcher = dao.getResearcher(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("researcher", researcher);

        return "edit/user";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateResearcher(@ModelAttribute("researcherForm") ResearcherForm form, ModelMap model) {
        try {
            dao.updateResearcher(form);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "edit/success";
    }

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllUserCsv(HttpServletResponse response) throws SQLException, IOException {
        String fileName = "users.csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                fileName);
        response.setHeader(headerKey, headerValue);

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

    @RequestMapping(value = "/importcsv", method = RequestMethod.POST)
    public String importCsv(@RequestParam("file") MultipartFile file, ModelMap model) {

        if (file.isEmpty()) {
            model.addAttribute("info", "The file is empty. Please make sure you selected a file.");
            return "import/failed";
        }

        List<String> errors = new ArrayList<String>();
        List<ResearcherCSV> researcherCSVs = csvUtils.readCSV(file, getProcessors(), ResearcherCSV.class, errors);

        if (errors.size() > 0) {
            model.addAttribute("info", errors.get(0));
            return "import/failed";
        }

        try {
            dao.importCSV(researcherCSVs);
            return "import/success";

        } catch (SQLException e) {
            model.addAttribute("info", "A problem occurred when we tried to update the database. Please verify the data fulfills the requirement.");
            return "import/failed";
        }
    }

    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseInt()), // id (must be unique)
                new NotNull(), // username
                new NotNull(), // password
                new NotNull(new ParseInt()), // device id
                new NotNull(), // status
                new NotNull(), // firstName
                new NotNull(), // lastName
                new Optional(), // Address
                new Optional(), // Country
                new Optional(), // Phone
                new Optional(), // State
                new Optional(), // Zip
                new Optional(), // Last Login
        };

        return processors;
    }
}