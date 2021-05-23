package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controladora de les peticions relacionades amb els processos
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/processos")
public class ProcesController {

    @Autowired
    ProcesServiceImpl procesService;

    @Autowired
    ReferenciaServiceImpl referenciaService;

    @Autowired
    UserServiceImpl userService;

    /**
     * Retorna llistat de tots els processos
     *
     * @param model model de procés
     * @return llista de processos
     */
    @RequestMapping("/all")
    public String getAllProcessos(Model model) {
        model.addAttribute("processosBD", procesService.getAllProcessos());
        return "procesLlistat";
    }

    /**
     * Retorna llistat dels processos d'una referència de producte per que
     * l'usuari seleccioni un per tal d'executar-ho. Passem l'id de l'usuari
     * loguejat i l'id del proces a angular (component play-proces) per poder
     * generar un objecte Resultat
     *
     * @param idReferencia id referència
     * @param model model de la plantilla
     * @return llistat dels processos d'una referència
     */
    @GetMapping("/byreferencia")
    public String byReferencia(@RequestParam("idReferencia") long idReferencia, Model model) {
        Usuari usuari;
        long usuariId;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        usuari = userService.getUsuariByNom(auth.getName());
        usuariId = usuari.getUserId();

        model.addAttribute("processos", procesService.getProcessosByReferencia(idReferencia));
        model.addAttribute("usuerId", usuariId);
        return "seleccioProces";
    }

    /**
     * Gestiona la petició new i retorna el formulari de creació processos
     *
     * @param model de procés
     * @return formulari de procés
     */
    @GetMapping("/new")
    public String newProces(Model model) {
        List<Referencia> referenciesDisponibles = referenciaService.getAllReferencies();
        Proces formProces = new Proces();

        model.addAttribute("referenciesBD", referenciesDisponibles);
        model.addAttribute("act", "proces/add");
        model.addAttribute("formproces", formProces);
        return "procesForm";
    }

    /**
     * Processa el formulari i afegeix el procès a la BD
     *
     * @param formProces formulari de procés
     * @param result resultat de procés
     * @return retorna a la llista de processos
     */
    @GetMapping(value = "/proces/add")
    public String processAddForm(@ModelAttribute("formproces") Proces formProces, BindingResult result) {
        Calendar calendar = Calendar.getInstance();
        formProces.setDataRegistre(calendar.getTime());
        procesService.saveProces(formProces);
        return "redirect:/processos/all";
    }

    /**
     * Gestiona la petició per actualitzar un procés i retorna el formulari amb
     * les dades del que s'ha passat l'id
     *
     * @param idProces id de procés
     * @param model de plantilla del formulari procés
     * @return redirecció a la llista o formulari de procés
     */
    @GetMapping("/proces")
    public String updateProces(@RequestParam("idProces") long idProces, Model model) {
        List<Referencia> referenciesDisponibles = referenciaService.getAllReferencies();

        if (idProces != 0) {
            Proces formProces = procesService.getProcesById(idProces);
            model.addAttribute("referenciesBD", referenciesDisponibles);
            model.addAttribute("act", "proces/update");
            model.addAttribute("formproces", formProces);
        } else {
            return "redirect:/processos/all";
        }

        return "procesForm";
    }

    /**
     * Processa el formulari i actualitza el pocés a la BD
     *
     * @param formProces formulari de procés
     * @param result de procés
     * @return redirecció a la llista de processos
     */
    @GetMapping("/proces/update")
    public String processUpdateForm(@ModelAttribute("formproces") Proces formProces, BindingResult result) {
        Calendar calendar = Calendar.getInstance();
        formProces.setDataRegistre(calendar.getTime());
        procesService.updateProces(formProces);
        return "redirect:/processos/all";
    }

    /**
     * Esborra el procès per la ID
     *
     * @param idProces id de procés
     * @return redirecció a la llista de processos
     * @throws ServletException Excepció d'error de Servlet
     * @throws IOException Excepció d'error d'entrada i salida
     */
    @GetMapping("/delete")
    public String deleteProces(@RequestParam("idProces") long idProces)
            throws ServletException, IOException {
        procesService.deleteProces(idProces);
        return "redirect:/processos/all";
    }
}
