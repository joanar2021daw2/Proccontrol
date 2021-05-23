package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controladora de les peticions relacionades amb les seccions
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
     *
     * @param model model de la plantilla del llistat de seccions
     * @return vitsa del llistat de secicons
     */
    @RequestMapping("/all")
    public String getAllSeccions(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "seccioLlistat";
    }

    /**
     * Retorna seccions per que l'usuari seleccioni una i pugui verue les
     * instalacions a l'hora de cercar procés per executar-lo
     *
     * @param model de la vista de selecció de secció
     * @return
     */
    @RequestMapping("/selectone")
    public String selectOneSeccio(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "seleccioSeccio";
    }

    /**
     * Gestiona la petició new per preparar el formulari de nova secció
     *
     * @param model model de la plantilla del formulari
     * @return vista del formulari de nova secció
     */
    @GetMapping("/new")
    public String newSeccio(Model model) {
        Seccio formSeccio = new Seccio();
        model.addAttribute("formseccio", formSeccio);
        return "seccioForm";
    }

    /**
     * Processa el formulari i afegeix la secció a la BD
     *
     * @param formSeccio seccio passada del formulari
     * @param result resultat enllaçat amb el commit
     * @return vista de llistat amb totes les seccions
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
     * Gestiona l'Actualització d'una secció preparant el formulari amb les
     * dades de la secció passada per paràmetre
     *
     * @param idSeccio id de la secció
     * @param model model de la plantilla
     * @return vista del formulari amb les dades de la secció a actualitzar
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
     * 
     * @param idSeccio id de la secció
     * @return vista del llistat de totes les seccions
     * @throws javax.servlet.ServletException 
     * @throws java.io.IOException 
     */
    @GetMapping("/delete")
    public String deleteSeccio(@RequestParam("idSeccio") long idSeccio)
            throws ServletException, IOException {
        seccioService.deleteSeccio(idSeccio);
        return "redirect:/seccions/all";
    }

}
