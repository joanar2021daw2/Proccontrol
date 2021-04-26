package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import java.io.IOException;
import java.util.Calendar;
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
@RequestMapping("/processos")
public class ProcesController {

    @Autowired
    ProcesServiceImpl procesService;
    
    @Autowired
    ReferenciaServiceImpl referenciaService;

    /*Retorna llistat de tots els processos*/
    @RequestMapping("/all")
    public String getAllProcessos(Model model) {
        model.addAttribute("processosBD", procesService.getAllProcessos());
        return "procesLlistat";
    }

    /*Afegeix un procès*/
    @GetMapping("/new")
    public String newProces(Model model) {
        List<Referencia> referenciesDisponibles = referenciaService.getAllReferencies();
        Proces formProces = new Proces();

        model.addAttribute("referenciesBD", referenciesDisponibles);
        model.addAttribute("act", "proces/add");
        model.addAttribute("formproces", formProces);
        return "procesForm";
    }

    /*Processa el formulari i afegeix el procès a la BD*/
    @GetMapping(value = "/proces/add")
    public String processAddForm(@ModelAttribute("formproces") Proces formProces, BindingResult result) {
        Calendar calendar = Calendar.getInstance();
        formProces.setDataRegistre(calendar.getTime());
        procesService.saveProces(formProces);
        return "redirect:/processos/all";
    }

    /*Actualizta un procès*/
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

    /*Processa el formulari i actualitza el pocès a la BD*/
    @GetMapping("/proces/update")
    public String processUpdateForm(@ModelAttribute("formproces") Proces formProces, BindingResult result) {
        Calendar calendar = Calendar.getInstance();
        formProces.setDataRegistre(calendar.getTime());
        procesService.updateProces(formProces);
        return "redirect:/processos/all";
    }

    /*Esborra el procès per la ID*/
    @GetMapping("/delete")
    public String deleteProces(@RequestParam("idProces") long idProces)
            throws ServletException, IOException {
        procesService.deleteProces(idProces);
        return "redirect:/processos/all";
    }
}