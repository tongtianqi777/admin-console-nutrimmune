package controller;

import exceptions.CSVParseException;
import exceptions.FileOpeningException;
import model.beans.Researcher;
import model.beans.csv.ResearcherCSV;
import model.daos.ResearcherDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
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

        if (!file.isEmpty()) {
            try {
                List<ResearcherCSV> researcherCSVs = readCSV(file);
                System.out.println(researcherCSVs);
                return "import/success";

            } catch (FileOpeningException e) {
                e.printStackTrace();
                model.addAttribute("info", "A problem occured when we tried to open the file, please check the correctness of the file completeness.");
                return "import/failed";

            } catch (CSVParseException e) {
                e.printStackTrace();
                model.addAttribute("info", "A problem occured when we tried to parse the csv data, please verify the correctness of the data format.");
                return "import/failed";
            }

        } else {
            System.out.println("Empty file!!");
            model.addAttribute("info", "The file is empty.");
            return "import/failed";
        }
    }

    private List<ResearcherCSV> readCSV(MultipartFile file) throws CSVParseException, FileOpeningException {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();

        } catch (IOException e) {
            throw new FileOpeningException();
        }

        ICsvBeanReader beanReader = null;
        List<ResearcherCSV> researcherCSVs = new ArrayList<ResearcherCSV>();

        try {
            beanReader = new CsvBeanReader(new InputStreamReader(inputStream), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            ResearcherCSV researcherCSV;

            while ((researcherCSV = beanReader.read(ResearcherCSV.class, header, processors)) != null) {
                researcherCSVs.add(researcherCSV);
            }

        } catch (Exception e) {
            throw new CSVParseException();

        } finally {
            if (beanReader != null) {
                try {
                    beanReader.close();
                } catch (IOException e) {
                    throw new FileOpeningException();
                }

            }
        }

        return researcherCSVs;
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