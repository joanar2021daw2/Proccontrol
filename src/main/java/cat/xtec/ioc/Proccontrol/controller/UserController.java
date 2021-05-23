package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.ConstraintValidator.OnUpdate;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controladora de les peticions relacionades amb els usuaris
 *
 * @author JoseAndrade
 */
@Controller
@Validated
@RequestMapping("/users")
public class UserController {

    /**
     * Servei usuari
     */
    @Autowired
    UserServiceImpl userService;

    /**
     * Obtenir tots els usuaris de la base de dades
     *
     * @param model
     * @return
     */
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<Usuari> users = userService.getAllUsuaris();
        model.addAttribute("usuarisBD", users);
        return "userLlistat";
    }

    /**
     * Obtenir només els usuaris de la base de dades que estàn inactius
     *
     * @param model
     * @return
     */
    @GetMapping("/inactius")
    public String getInactiusUsers(Model model) {
        List<Usuari> users = userService.getAllUsuaris();
        model.addAttribute("usuarisBD", users);
        return "userInactiulLlistat";
    }

    /**
     * Gestiona la petició new i retorna el formulari de creació usuaris
     *
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newUser(Model model) {
        Usuari formUser = new Usuari();
        model.addAttribute("action", "/users/new");
        model.addAttribute("formuser", formUser);
        return "userForm";
    }

    /**
     * Mètode que procesa el formulari de nou usuari
     *
     * @param formUser objecte usuari passat del formulari
     * @param result resultat enllaçat del formular
     * @return llistat dels usuaris actius
     */
    @Validated(OnUpdate.class)
    @PostMapping(value = "/new")
    public String processAddForm(@Valid @ModelAttribute("formuser") Usuari formUser, BindingResult result) {

        if (result.hasErrors()) {
            return "userForm";
        }

        userService.saveUsuari(formUser);
        return "redirect:/users/all";
    }

    /**
     * Mètode que procesa el formulari de actualitzar usuari
     *
     * @param formUser objecte usuari passat del formulari
     * @param result resultat enllaçat del formular
     * @return llistat dels usuaris actius
     */
    @PostMapping(value = "/update")
    public String processUpdateForm(@Valid @ModelAttribute("formuser") Usuari formUser, BindingResult result) {

        if (result.hasErrors()) {
            return "userForm";
        }

        userService.saveUsuari(formUser);
        return "redirect:/users/all";
    }

    /**
     * Mètode que procesa la petició d'actualitzar usuari
     *
     * @param userId id de l'usuari a actualitzar
     * @param model model de la pàgina web
     * @return
     */
    @GetMapping("/user")
    public String updateUser(@RequestParam("userId") long userId, Model model) {

        if (userId != 0) {
            Usuari formUser = userService.getUsuariById(userId);
            model.addAttribute("action", "/users/update");
            model.addAttribute("formuser", formUser);
        } else {
            return "redirect:/users/all";
        }

        return "userForm";
    }

    /**
     * Mètode que esborrar un usuari per id
     *
     * @param userId id de l'usuari a actualitzar
     * @return
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") long userId)
            throws ServletException, IOException {
        userService.deleteUsuari(userId);
        return "redirect:/users/all";
    }

}
