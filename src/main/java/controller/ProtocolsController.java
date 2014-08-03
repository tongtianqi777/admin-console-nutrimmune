package controller;

import com.ntm.postgres.Protocol;
import model.daos.AdminProtocolDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.CSVUtils;

import java.sql.SQLException;

@Controller
@RequestMapping("/protocols")
public class ProtocolsController {
    AdminProtocolDAO dao = new AdminProtocolDAO();
    CSVUtils<Protocol> csvUtils = new CSVUtils<Protocol>();

    @RequestMapping(method = RequestMethod.GET)
    public String showProtocols(ModelMap model) {
        try {
            model.addAttribute("protocols", dao.getAllProtocols());
            model.addAttribute("test", "succ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "protocols";
    }

    //The protocol export and import are not supported at this time

//    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
//    public void getAllUserCsv (HttpServletResponse response) throws SQLException, IOException {
//        String fileName = "protocols.csv";
//
//        response.setContentType("text/csv");
//
//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"",
//                fileName);
//        response.setHeader(headerKey, headerValue);
//
//        List<Protocol> protocols = dao.getAllProtocols();
//
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
//                CsvPreference.STANDARD_PREFERENCE);
//
//        String[] header = {
//                "id",
//                "authorId",
//                "name",
//                "status",
//                "steps",
//                "lastModified",
//                "createTime",
//                "description",
//                "timePlayed"
//        };
//
//        csvWriter.writeHeader(header);
//
//        for (Protocol protocol : protocols) {
//            ProtocolCSV protocolCSV = new ProtocolCSV(protocol);
//            csvWriter.write(protocolCSV, header);
//        }
//
//        csvWriter.close();
//    }
//
//    @RequestMapping(value = "/importcsv", method = RequestMethod.POST)
//    public String importCsv(@RequestParam("file") MultipartFile file, ModelMap model) {
//
//        if (file.isEmpty()) {
//            model.addAttribute("info", "The file is empty. Please make sure you selected a file.");
//            return "import/failed";
//        }
//
//        List<String> errors = new ArrayList<String>();
//        List<ProtocolCSV> protocolCSVs = csvUtils.readCSV(file, getProcessors(), ProtocolCSV.class, errors);
//
//        if (errors.size() > 0) {
//            model.addAttribute("info", errors.get(0));
//            return "import/failed";
//        }
//
//        try {
//            dao.importCSV(protocolCSVs);
//            return "import/success";
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            model.addAttribute("info", "A problem occurred when we tried to update the database. Please verify the data fulfills the requirement.");
//            return "import/failed";
//        }
//    }
//
//    private static CellProcessor[] getProcessors() {
//
//        final CellProcessor[] processors = new CellProcessor[]{
//                new NotNull(new ParseInt()), // id (must be unique)
//                new NotNull(new ParseInt()), // author id
//                new NotNull(), // name
//                new NotNull(), // status
//                new Optional(), //steps
//                new NotNull(), // last_modified
//                new NotNull(), // create_time
//                new NotNull(), // description
//                new NotNull(new ParseInt()), // time_played
//        };
//
//        return processors;
//    }
}