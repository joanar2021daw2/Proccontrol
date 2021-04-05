package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import java.util.List;
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
@RequestMapping("/instalacions")
public class InstalacioController {

    @Autowired
    InstalacioServiceImpl instService;
    
    @Autowired
    SeccioServiceImpl seccioService;

    /*Retorna llistat de totes les instal·lacions*/
    @RequestMapping("/all")
    public String getAllInstalacions(Model model) {
        model.addAttribute("instalacionsBD", instService.getAllInstalacions());
        return "instalacioLlistat";
    }

    /*Afegeix una instalació*/
    @GetMapping("/new")
    public String newInstalacio(Model model) {
        List<Seccio> seccionsDisponibles = seccioService.getAllSeccions();        
        Instalacio formInstalacio = new Instalacio();
        
        model.addAttribute("seccionsBD", seccionsDisponibles);
        model.addAttribute("act", "instalacio/add");
        model.addAttribute("forminstalacio", formInstalacio);
        return "instalacioForm";
    }

    /*Processa el formulari i afegeix l'instalació a la BD*/
    @GetMapping(value = "/instalacio/add")
    public String processAddForm(@ModelAttribute("forminstalacio") Instalacio formInstalacio, BindingResult result) {
        instService.saveInstalacio(formInstalacio);
        return "redirect:/instalacions/all";
    }

    /*Actualizta una instalació*/
    @GetMapping("/instalacio")
    public String updateInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        List<Seccio> seccionsDisponibles = seccioService.getAllSeccions();        
        
        if (idInstalacio != 0) {
            Instalacio formInstalacio = instService.getInstalacioById(idInstalacio);
            model.addAttribute("seccionsBD", seccionsDisponibles);
            model.addAttribute("act", "instalacio/update");
            model.addAttribute("forminstalacio", formInstalacio);
        } else {
            return "redirect:/instalacions/all";
        }

        return "instalacioForm";
    }

    /*Processa el formulari i actualitza la instal·lació a la BD*/
    @GetMapping("/instalacio/update")
    public String processUpdateForm(@ModelAttribute("forminstalacio") Instalacio formInstalacio, BindingResult result) {
        instService.updateInstalacio(formInstalacio);
        return "redirect:/instalacions/all";
    }

    /*Esborra la instal·lació per la ID*/
    @GetMapping("/delete")
    public String deleteInstalacio(@RequestParam("idInstalacio") long idInstalacio)
            throws ServletException, IOException {
        instService.deleteInstalacio(idInstalacio);
        return "redirect:/instalacions/all";
    }
}
