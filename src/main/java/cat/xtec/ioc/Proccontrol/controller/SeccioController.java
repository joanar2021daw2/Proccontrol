package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/seccions")
public class SeccioController {

    @Autowired
    SeccioServiceImpl seccioService;

    /*Retorna llistat de totes les seccions*/
    @RequestMapping("/all")
    public String getAllSeccions(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "seccioLlistat";
    }

    /*Afegeix una secció*/
    @GetMapping("/new")
    public String newSeccio(Model model) {
        Seccio formSeccio = new Seccio();
        model.addAttribute("act", "seccio/add");
        model.addAttribute("formseccio", formSeccio);
        return "seccioForm";
    }

    /*Processa el formulari i afegeix la secció a la BD*/
    @GetMapping(value = "/seccio/add")
    public String processAddForm(@ModelAttribute("formseccio") Seccio formSeccio, BindingResult result) {
        seccioService.saveSeccio(formSeccio);
        return "redirect:/seccions/all";
    }

    /*Actualizta una secció*/
    @GetMapping("/seccio")
    public String updateSeccio(@RequestParam("idSeccio") long idSeccio, Model model) {

        if (idSeccio != 0) {
            Seccio formSeccio = seccioService.getSeccioById(idSeccio);
            model.addAttribute("act", "seccio/update");
            model.addAttribute("formseccio", formSeccio);
        } else {
            return "redirect:/seccions/all";
        }

        return "seccioForm";
    }

    /*Processa el formulari i actualitza la secció a la BD*/
    @GetMapping("/seccio/update")
    public String processUpdateForm(@ModelAttribute("formseccio") Seccio formSeccio, BindingResult result) {
        seccioService.updateSeccio(formSeccio);
        return "redirect:/seccions/all";
    }

    /*Esborra la secció per la ID*/
    @GetMapping("/delete")
    public String deleteSeccio(@RequestParam("idSeccio") long idSeccio)
            throws ServletException, IOException {
        seccioService.deleteSeccio(idSeccio);
        return "redirect:/seccions/all";
    }

}
