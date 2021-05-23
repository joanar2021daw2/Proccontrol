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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controladora de peticions relacionades amb les instal·lacions
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/instalacions")
public class InstalacioController {

    /**
     * Servei de l'instal·lació
     */
    @Autowired
    InstalacioServiceImpl instalacioService;

    /**
     * Servei de secció
     */
    @Autowired
    SeccioServiceImpl seccioService;

    /**
     * Mètode per retornar tot el llistat d'instal·lacions
     *
     * @param model model per a la plantilla del llistat d'instal·lacions
     * @return retorna llistat de totes les instal·lacions
     */
    @RequestMapping("/all")
    public String getAllInstalacions(Model model) {
        model.addAttribute("instalacionsBD", instalacioService.getAllInstalacions());
        return "instalacioLlistat";
    }

    /**
     * Mètode per retornar les instal·lacions que hi han a la secció
     *
     * @param idSeccio id de la secció
     * @param model model per a la plantilla de les instal·lacions
     * @return plantilla html amb les instal·lacions
     */
    @RequestMapping("/byseccio")
    public String getInstalacionsBySeccio(@RequestParam("idSeccio") long idSeccio, Model model) {
        model.addAttribute("instalacions", instalacioService.getInstalacioBySeccio(idSeccio));
        return "seleccioInstalacio";
    }

    /**
     * Mètode que processa la petició GET per crear una instal·lacio
     *
     * @param model model de instal·lació
     * @return plantilla html formulari de nova instal·lació
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
     * Mètode que processa el formulari i afegeix l'instalació a la BD
     *
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
     * Mètode que retorna el formulari amb les dades de la instal·lació a
     * modificar
     *
     * @param idInstalacio id d'instal·lació a modificar
     * @param model model de la plantilla
     * @return formulari d'instal·lació o redirecció a la llista
     * d'instal·lacions
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
     * Mètode que esborra la instal·lació per la ID
     *
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
