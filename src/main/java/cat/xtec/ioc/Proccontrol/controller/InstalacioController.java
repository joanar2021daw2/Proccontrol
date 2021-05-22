package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import java.util.List;
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
 * Aquesta classe serveix per crear instal·lació, secció, vincular-les
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/instalacions")
public class InstalacioController {

    /**
     * Servei de l'instalació
     */
    @Autowired
    InstalacioServiceImpl instalacioService;

    /**
     * Servei de secció
     */
    @Autowired
    SeccioServiceImpl seccioService;

    /**
     * 
     * @param model de l'instalació
     * @return Retorna llistat de totes les instal·lacions
     */
    @RequestMapping("/all")
    public String getAllInstalacions(Model model) {
        model.addAttribute("instalacionsBD", instalacioService.getAllInstalacions());
        return "instalacioLlistat";
    }

    /**
     * Selecciona les instalacions que hi han a la secció
     * @param idSeccio id de secció
     * @param model model de instal·lació
     * @return instalació seleccionat
     */
    @RequestMapping("/byseccio")
    public String getInstalacionsBySeccio(@RequestParam("idSeccio") long idSeccio, Model model) {
        model.addAttribute("instalacions", instalacioService.getInstalacioBySeccio(idSeccio));
        return "seleccioInstalacio";
    }

    /**
     * Afegeix una instalació
     * @param model de instal·lació
     * @return formulari de l'instal·lació
     */
    @GetMapping("/new")
    public String newInstalacio(Model model) {
        List<Seccio> seccionsDisponibles = seccioService.getAllSeccions();
        Instalacio formInstalacio = new Instalacio();

        model.addAttribute("seccionsBD", seccionsDisponibles);
        model.addAttribute("forminstalacio", formInstalacio);
        return "instalacioForm";
    }

    /**
     * Processa el formulari i afegeix l'instalació a la BD
     * @param formInstalacio formulari d'instal·lació
     * @param result agafa resultat
     * @return redirecció a la llista d'instal·lacions
     */
    @PostMapping(value = "/new")
    public String processAddForm(@Valid @ModelAttribute("forminstalacio") Instalacio formInstalacio, BindingResult result) {

        if (result.hasErrors()) {
            return "instalacioForm";
        }

        instalacioService.saveInstalacio(formInstalacio);
        return "redirect:/instalacions/all";
    }

    /**
     * Actualizta una instalació
     * @param idInstalacio id d'instal·lació
     * @param model model de instal·lació
     * @return formulari d'instal·lació o redirecció a la llista d'instal·lacions
     */
    @GetMapping("/instalacio")
    public String updateInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        List<Seccio> seccionsDisponibles = seccioService.getAllSeccions();

        if (idInstalacio != 0) {
            Instalacio formInstalacio = instalacioService.getInstalacioById(idInstalacio);
            model.addAttribute("seccionsBD", seccionsDisponibles);
            model.addAttribute("forminstalacio", formInstalacio);
        } else {
            return "redirect:/instalacions/all";
        }

        return "instalacioForm";
    }

    /**
     * Esborra la instal·lació per la ID
     * @param idInstalacio id d'instal·lació
     * @return redirecció a la llista de instalacions
     * @throws ServletException Excepció d'error de Servlet
	 * @throws IOException Excepció d'error d'entrada i salida
     */
    @GetMapping("/delete")
    public String deleteInstalacio(@RequestParam("idInstalacio") long idInstalacio)
            throws ServletException, IOException {
        instalacioService.deleteInstalacio(idInstalacio);
        return "redirect:/instalacions/all";
    }
}
