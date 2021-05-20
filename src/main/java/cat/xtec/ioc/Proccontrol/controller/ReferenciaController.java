package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import java.io.IOException;
import java.util.List;
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
 * Aquesta classe serveix per crear, actualitzar, obtenir, i esborrar referència
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("referencies")
public class ReferenciaController {

    /**
     * Servei de referència
     */
    @Autowired
    ReferenciaServiceImpl referenciaService;

    /**
     * Servei d'instal·lació
     */
    @Autowired
    InstalacioServiceImpl instalacioService;

    /**
     * Retorna llistat de totes les referències
     */
    @RequestMapping("/all")
    public String getAllReferencies(Model model) {
        model.addAttribute("referenciesBD", referenciaService.getAllReferencies());
        return "referenciaLlistat";
    }

    /*Retorna llistat de les referencias d'una instal·lació*/
    @GetMapping("/byinstalacio")
    public String byInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        model.addAttribute("referencies", referenciaService.getReferenciesByInstalacio(idInstalacio));
        return "seleccioReferencia";
    }

    /**
     * Afegeix una referència
     */
    @GetMapping("/new")
    public String newReferencia(Model model) {
        List<Instalacio> instalacionsDisponibles = instalacioService.getAllInstalacions();
        Referencia formReferencia = new Referencia();

        model.addAttribute("instalacionsBD", instalacionsDisponibles);
        model.addAttribute("formreferencia", formReferencia);
        return "referenciaForm";
    }

    /**
     * Processa el formulari i afegeix la referència a la BD
     */
    @PostMapping(value = "/new")
    public String processAddForm(@Valid @ModelAttribute("formreferencia") Referencia formReferencia, BindingResult result) {

        if (result.hasErrors()) {
            return "referenciaForm";
        }

        referenciaService.saveReferencia(formReferencia);
        return "redirect:/referencies/all";
    }

    /**
     * Actualitza una referència
     */
    @GetMapping("/referencia")
    public String updateReferencia(@RequestParam("idReferencia") long idReferencia, Model model) {
        List<Instalacio> instalacionsDisponibles = instalacioService.getAllInstalacions();

        if (idReferencia != 0) {
            Referencia formReferencia = referenciaService.getReferenciaById(idReferencia);
            model.addAttribute("instalacionsBD", instalacionsDisponibles);
            model.addAttribute("formreferencia", formReferencia);
        } else {
            return "redirect:/referencies/all";
        }

        return "referenciaForm";
    }

    /**
     * Esborra la referència per la ID
     */
    @GetMapping("/delete")
    public String deleteReferencia(@RequestParam("idReferencia") long idReferencia)
            throws ServletException, IOException {
        referenciaService.deleteReferencia(idReferencia);
        return "redirect:/referencies/all";
    }
}
