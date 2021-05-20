package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
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

/**
 * Aquesta classe serveix per crear, actualitzar, obtenir, i esborrar secció
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/seccions")
public class SeccioController {

    /**
     * Servei de secció
     */
    @Autowired
    SeccioServiceImpl seccioService;

    /**
     * Retorna llistat de totes les seccions
     */
    @RequestMapping("/all")
    public String getAllSeccions(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "seccioLlistat";
    }

    /*Retorna seccions per que l'usuari seleccioni una i verue les instalacions*/
    @RequestMapping("/selectone")
    public String selectOneSeccio(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "seleccioSeccio";
    }

    /**
     * Afegeix una secció
     */
    @GetMapping("/new")
    public String newSeccio(Model model) {
        Seccio formSeccio = new Seccio();
        model.addAttribute("formseccio", formSeccio);
        return "seccioForm";
    }

    /**
     * Processa el formulari i afegeix la secció a la BD
     */
    @PostMapping(value = "/new")
    public String processAddForm(@Valid @ModelAttribute("formseccio") Seccio formSeccio, BindingResult result) {

        if (result.hasErrors()) {
            return "seccioForm";
        }

        seccioService.saveSeccio(formSeccio);
        return "redirect:/seccions/all";
    }

    /**
     * Actualitza una secció
     */
    @GetMapping("/seccio")
    public String updateSeccio(@RequestParam("idSeccio") long idSeccio, Model model) {

        if (idSeccio != 0) {
            Seccio formSeccio = seccioService.getSeccioById(idSeccio);
            model.addAttribute("formseccio", formSeccio);
        } else {
            return "redirect:/seccions/all";
        }

        return "seccioForm";
    }


    /**
     * Esborra la secció per la ID
     */
    @GetMapping("/delete")
    public String deleteSeccio(@RequestParam("idSeccio") long idSeccio)
            throws ServletException, IOException {
        seccioService.deleteSeccio(idSeccio);
        return "redirect:/seccions/all";
    }

}
