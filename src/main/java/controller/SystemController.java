package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system")
public class SystemController {

    public static final String USER_CSV_PATH = "/users/allcsv";
    public static final String DEVICE_CSV_PATH = "/devices/allcsv";
    public static final String PROTOCOL_CSV_PATH = "/protocols/allcsv";

    public static final String USER_IMPORT_PATH = "/users/importcsv";
    public static final String DEVICE_IMPORT_PATH = "/devices/importcsv";
    public static final String PROTOCOL_IMPORT_PATH = "/protocols/importcsv";

    @RequestMapping(method = RequestMethod.GET)
    public String render(ModelMap model) {
        model.addAttribute("user_csv_path", USER_CSV_PATH);
        model.addAttribute("device_csv_path", DEVICE_CSV_PATH);
        model.addAttribute("protocol_csv_path", PROTOCOL_CSV_PATH);
        return "system";
    }

    @RequestMapping(value = "/import**", method = RequestMethod.GET)
    public String renderImportPage (@RequestParam("cate") String cate, ModelMap model) {
        String title = "";
        String uploadUrl = "";

        if (cate.equals("user")) {
            title = "User";
            uploadUrl = USER_IMPORT_PATH;

        } else if (cate.equals("device")) {
            title = "Device";
            uploadUrl = DEVICE_IMPORT_PATH;

        } else if (cate.equals("protocol")) {
            title = "Protocol";
            uploadUrl = PROTOCOL_IMPORT_PATH;
        }

        model.addAttribute("title", title);
        model.addAttribute("upload_url", uploadUrl);

        return "import/csvimport";
    }
}
