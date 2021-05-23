package cat.xtec.ioc.Proccontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe controladora de les peticions relacionades amb login/logout
 * 
 * @author JoseAndrade
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed")
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }

}
