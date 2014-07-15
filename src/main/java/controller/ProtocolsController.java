package controller;

import model.beans.Protocol;
import model.beans.csv.ProtocolCSV;
import model.daos.ProtocolDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/protocols")
public class ProtocolsController {
    ProtocolDAO dao = new ProtocolDAO();

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

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllUserCsv (HttpServletResponse response) throws SQLException, IOException {
        String fileName = "protocols.csv";

        response.setContentType("text/csv");

        List<Protocol> protocols = dao.getAllProtocols();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {
                "id",
                "authorId",
                "name",
                "status",
                "steps",
                "lastModified",
                "createTime",
                "description",
                "timePlayed"
        };

        csvWriter.writeHeader(header);

        for (Protocol protocol : protocols) {
            ProtocolCSV protocolCSV = new ProtocolCSV(protocol);
            csvWriter.write(protocolCSV, header);
        }

        csvWriter.close();
    }
}