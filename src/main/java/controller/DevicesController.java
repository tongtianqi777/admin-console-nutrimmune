package controller;

import com.ntm.postgres.Device;
import com.ntm.postgres.DeviceStatus;
import controller.forms.DeviceForm;
import model.daos.AdminDeviceDAO;
import model.daos.CommunityDAO;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/devices")
public class DevicesController {
    AdminDeviceDAO deviceDAO = new AdminDeviceDAO();
    CommunityDAO communityDAO = new CommunityDAO();
    CSVUtils<Device> csvUtils = new CSVUtils<Device>();

    @RequestMapping(method = RequestMethod.GET)
    public String showDevices(ModelMap model) {

        try {
            model.addAttribute("devices", deviceDAO.getAllDevices());
            model.addAttribute("communities", communityDAO.getCommunities());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "devices";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDevice (@PathVariable int id, ModelMap model) {
        Device device = null;

        try {
            device = deviceDAO.getDevice(id);
            model.addAttribute("communities", communityDAO.getCommunities());


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
            if (!valid(form)) {
                System.out.println("Device information is not valid.");
                return "add/fail";
            }
            deviceDAO.update(form);
            model.addAttribute("devices", deviceDAO.getAllDevices());
            model.addAttribute("communities", communityDAO.getCommunities());
            model.addAttribute("success_message", "You successfully updated the entity.\n");


        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";

        } catch (ParseException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        return "devices";
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public @ResponseBody
    String activateDevice (@RequestParam("id") int id) {
        try {
            deviceDAO.activateDevice(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    @RequestMapping(value = "/deactivate", method = RequestMethod.POST)
    public @ResponseBody
    String deactivateDevice (@RequestParam("id") int id) {
        try {
            deviceDAO.deactivateDevice(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    @RequestMapping(value = "/changeCommunity", method = RequestMethod.POST)
    public @ResponseBody
    String changeCommunityId (@RequestParam("id") int id, @RequestParam("community") int c_id) {
        try {
            deviceDAO.changeCommunityID(id, c_id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }


    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewDevice (@PathVariable String id, ModelMap model) {
        Device device = null;

        try {
            device = deviceDAO.getDevice(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit/fail";
        }

        model.addAttribute("device", device);

        return "view/device";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String rendarAddDevice () {
        return "add/device";
    }

    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String addDevice (DeviceForm form, ModelMap model) {
        boolean error = false;
        try {
            if (!valid(form)) {
                System.out.println("Device information is not valid.");
                return "add/fail";
            }
            deviceDAO.add(form);
            model.addAttribute("devices", deviceDAO.getAllDevices());
            model.addAttribute("communities", communityDAO.getCommunities());
            model.addAttribute("success_message", "You successfully created the entity.\n");

        } catch (SQLException e) {
            e.printStackTrace();
            return "add/fail";

        } catch (ParseException e) {
            e.printStackTrace();
            return "add/fail";
        }

        return "devices";
    }

    private boolean valid(DeviceForm form) {
        try {
            //check if the status is valid
            DeviceStatus.valueOf(form.getStatus());

            //check if the date strings are valid
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.parse(form.getManufactureDate());
            dateFormat.parse(form.getShipdate());

        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/allcsv", method = RequestMethod.GET)
    public void getAllDeviceCsv (HttpServletResponse response) throws SQLException, IOException {
        String fileName = "devices.csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                fileName);
        response.setHeader(headerKey, headerValue);

        List<Device> devices = deviceDAO.getAllDevices();

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
            deviceDAO.importCSV(devices);
            return "import/success";

        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("info", "A problem occurred when we tried to update the database. Please verify the data fulfills the requirement.");
            return "import/failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteDevice (@RequestParam("id") int id) {
        try {
            deviceDAO.delete(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
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
