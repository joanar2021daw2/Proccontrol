package cat.xtec.ioc.Proccontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe per iniciar sessió, pot ser succés o és dóna error
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
