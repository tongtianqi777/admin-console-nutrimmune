package controller;

import com.ntm.postgres.Device;
import controller.forms.DeviceForm;
import model.daos.AdminDeviceDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import utils.CSVUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/devices")
public class DevicesController {
    AdminDeviceDAO dao = new AdminDeviceDAO();
    CSVUtils<Device> csvUtils = new CSVUtils<Device>();

    @RequestMapping(method = RequestMethod.GET)
    public String showDevices(ModelMap model) {

        try {
            model.addAttribute("devices", dao.getAllDevices());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "devices";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDevice (@PathVariable int id, ModelMap model) {
        Device device = null;

        try {
            device = dao.getDevice(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("device", device);

        return "edit/device";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDevice(@ModelAttribute("protocolForm") DeviceForm form, ModelMap model) {
        try {
            dao.update(form);
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        return "edit/success";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String rendarAddDevice () {
        return "add/device";
    }

    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String addDevice (DeviceForm form, ModelMap model) {
        try {
            dao.add(form);
        } catch (SQLException e) {
            e.printStackTrace();
            return "add/fail";
        }

        return "add/success";
    }

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllDeviceCsv (HttpServletResponse response) throws SQLException, IOException {
        String fileName = "devices.csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                fileName);
        response.setHeader(headerKey, headerValue);

        List<Device> devices = dao.getAllDevices();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {
                "id",
                "mac",
                "manufactureDate",
                "osbuildrev",
                "ownerId",
                "shipdate",
                "status"
        };

        csvWriter.writeHeader(header);

        for (Device device : devices) {
            csvWriter.write(device, header);
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
        List<Device> devices = csvUtils.readCSV(file, getProcessors(), Device.class, errors);

        if (errors.size() > 0) {
            model.addAttribute("info", errors.get(0));
            return "import/failed";
        }

        try {
            dao.importCSV(devices);
            return "import/success";

        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("info", "A problem occurred when we tried to update the database. Please verify the data fulfills the requirement.");
            return "import/failed";
        }
    }

    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseInt()), // id (must be unique)
                new NotNull(), // mac
                new NotNull(new ParseDate("yyyy-MM-dd")), // manufactureDate
                new NotNull(new ParseInt()), // osbuildrev
                new NotNull(new ParseInt()), // ownerId
                new NotNull(new ParseDate("yyyy-MM-dd")), // shipdate
                new NotNull() // status
        };

        return processors;
    }
}
