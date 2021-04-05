package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.UserService;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/all")
    public ModelAndView getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelView = new ModelAndView("userLlistat");
        List<Usuari> users = userService.getAllUsuaris();
        modelView.getModelMap().addAttribute("usuarisBD", users);
        return modelView;
    }

    /*Nou usuari*/
    @GetMapping("/new")
    public ModelAndView newUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("userForm");
        Usuari formUser = new Usuari();
        modelview.getModelMap().addAttribute("act", "user/add");
        modelview.getModelMap().addAttribute("formuser", formUser);
        return modelview;
    }

    @GetMapping(value = "/user/add")
    public String processAddForm(@ModelAttribute("formuser") Usuari formUser, BindingResult result) {
        userService.saveUsuari(formUser);
        return "redirect:/users/all";
    }

    /*Actualiztar usuari*/
    @GetMapping("/user")
    public ModelAndView updateUser(@RequestParam("userId") long userId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView;
        if (userId != 0) {
            modelView = new ModelAndView("userForm");
            Usuari formUser = userService.getUsuariById(userId);
            modelView.getModelMap().addAttribute("act", "user/update");
            modelView.getModelMap().addAttribute("formuser", formUser);
        } else {
            modelView = new ModelAndView("users");
        }

        return modelView;
    }

    @GetMapping("/user/update")
    public String processUpdateForm(@ModelAttribute("formuser") Usuari formUser, BindingResult result) {
        userService.updateUsuari(formUser);
        return "redirect:/users/all";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int userId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService.deleteUsuari(userId);
        return "redirect:/users/all";
    }

}
