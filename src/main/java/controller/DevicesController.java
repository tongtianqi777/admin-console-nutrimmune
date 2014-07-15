package controller;

import model.beans.Device;
import model.beans.csv.DeviceCSV;
import model.daos.DeviceDAO;
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
@RequestMapping("/devices")
public class DevicesController {
    DeviceDAO dao = new DeviceDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String showDevices(ModelMap model) {

        try {
            model.addAttribute("devices", dao.getAllDevices());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "devices";
    }

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllDeviceCsv (HttpServletResponse response) throws SQLException, IOException {
        String fileName = "devices.csv";

        response.setContentType("text/csv");

        List<Device> devices = dao.getAllDevices();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {
                "id",
                "mac",
                "manuAddr",
                "manuDate",
                "shipDate",
                "ownerName",
                "status",
                "communityId"
        };

        csvWriter.writeHeader(header);

        for (Device device : devices) {
            DeviceCSV deviceCSV = new DeviceCSV(device);
            csvWriter.write(deviceCSV, header);
        }

        csvWriter.close();
    }
}
