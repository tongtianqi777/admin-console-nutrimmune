package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system")
public class SystemController {

    public static final String USER_CSV_PATH = "/users/allcsv";
    public static final String DEVICE_CSV_PATH = "/devices/allcsv";
    public static final String PROTOCOL_CSV_PATH = "/protocols/allcsv";

    @RequestMapping(method = RequestMethod.GET)
    public String render(ModelMap model) {
        model.addAttribute("user_csv_path", USER_CSV_PATH);
        model.addAttribute("device_csv_path", DEVICE_CSV_PATH);
        model.addAttribute("protocol_csv_path", PROTOCOL_CSV_PATH);
        return "system";
    }
}
