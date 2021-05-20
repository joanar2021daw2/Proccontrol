package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Aquesta classe serveix per crear, actualitzar, obtenir, i esborrar usuari
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * Servei usuari
     */
    @Autowired
    UserServiceImpl userService;
    
    /**
     * Obtenir tots els usuaris de la base de dades
     */
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<Usuari> users = userService.getAllUsuaris();
        model.addAttribute("usuarisBD", users);
        return "userLlistat";
    }

    /**
     * Obtenir només els usuaris de la base de dades que estàn inactius
     */
    @GetMapping("/inactius")
    public String getInactiusUsers(Model model) {

        List<Usuari> users = userService.getAllUsuaris();
        model.addAttribute("usuarisBD", users);
        return "userInactiulLlistat";
    }

    /**
     * Posar vista de crear usuari
     */
    @GetMapping("/new")
    public String newUser(Model model) {
        Usuari formUser = new Usuari();
        model.addAttribute("formuser", formUser);
        return "userForm";
    }

    /**
     * Crear nou usuari
     */
    @PostMapping(value = "/new")
    public String processAddForm(@Valid @ModelAttribute("formuser") Usuari formUser, BindingResult result) {

        if (result.hasErrors()) {
            return "userForm";
        }

        userService.saveUsuari(formUser);
        return "redirect:/users/all";
    }

    /**
     * Actualitzar usuari per id
     */
    @GetMapping("/user")
    public String updateUser(@RequestParam("userId") long userId, Model model) {

        if (userId != 0) {
            Usuari formUser = userService.getUsuariById(userId);
            model.addAttribute("formuser", formUser);
        } else {
            return "redirect:/users/all";
        }

        return "userForm";
    }

    /**
     * Esborrar usuari per id
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") long userId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService.deleteUsuari(userId);
        return "redirect:/users/all";
    }

}
