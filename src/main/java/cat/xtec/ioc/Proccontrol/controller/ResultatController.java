package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ResultatServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/resultats")
public class ResultatController {

    @Autowired
    ResultatServiceImpl resultatService;

    @Autowired
    SeccioServiceImpl seccioService;

    @Autowired
    InstalacioServiceImpl instalacioService;

    @Autowired
    ReferenciaServiceImpl referenciaService;

    @Autowired
    ProcesServiceImpl procesService;

    @GetMapping("/details")
    public String resultatDetails(@RequestParam("idResultat") long idResultat, Model model) {
        Resultat resultat = resultatService.getResultatById(idResultat);
        Proces proces = procesService.getProcesById(resultat.getProces().getIdProces());
        model.addAttribute("resultatDetails", resultat);        
        model.addAttribute("procesDetails", proces);
        return "resultatDetails";
    }

    @GetMapping("/byusuari")
    public String getResultatByUsuari(@RequestParam("idUsuari") long userId, Model model) {

        return null;
    }

    @GetMapping("/byproces")
    public String getResultatByProces(@RequestParam("idProces") long idProces, Model model) {
        List<Resultat> resultatsPerProces = resultatService.getResultatsByProces(idProces);
        model.addAttribute("resultatsBD", resultatsPerProces);
        return "resultatLlistat";
    }

    /*Retorna seccions per que l'usuari seleccioni una i verue les instalacions*/
    @RequestMapping("/selectsection")
    public String selectOneSeccio(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "perSeccio";
    }

    /*Selecciona les instalacions que hi han a la seccio*/
    @RequestMapping("/byseccio")
    public String getInstalacionsBySeccio(@RequestParam("idSeccio") long idSeccio, Model model) {
        model.addAttribute("instalacions", instalacioService.getInstalacioBySeccio(idSeccio));
        return "perInstalacio";
    }

    /*Retorna llistat de les referencias d'una instal·lació*/
    @GetMapping("/byinstalacio")
    public String byInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        model.addAttribute("referencies", referenciaService.getReferenciesByInstalacio(idInstalacio));
        return "perReferencia";
    }

    /*Retorna llistat dels processos d'una referència de producte*/
    @GetMapping("byreferencia")
    public String byReferencia(@RequestParam("idReferencia") long idReferencia, Model model) {
        model.addAttribute("processos", procesService.getProcessosByReferencia(idReferencia));
        return "perProces";
    }

    /*Esborra el resultat per la ID*/
    @GetMapping("/delete")
    public String deleteResultat(@RequestParam("idResultat") long idResultat)
            throws ServletException, IOException {
        resultatService.deleteResultat(idResultat);
        return "redirect:/edicio";
    }
 
}
