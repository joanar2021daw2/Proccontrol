package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ResultatServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Classe controladora de les peticions relacionades amb els resultats
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/resultats")
public class ResultatController {

    /**
     * Servei resultat
     */
    @Autowired
    ResultatServiceImpl resultatService;

    /**
     * Servei secció
     */
    @Autowired
    SeccioServiceImpl seccioService;

    /**
     * Servei instal·lació
     */
    @Autowired
    InstalacioServiceImpl instalacioService;

    /**
     * Servei referència
     */
    @Autowired
    ReferenciaServiceImpl referenciaService;

    /**
     * Servei procés
     */
    @Autowired
    ProcesServiceImpl procesService;

    /**
     * Retorna vista de detalls del resultat
     *
     * @param idResultat id de resultat
     * @param model model de la plantilla detalls del resultat
     * @return retona plantilla amb els detalls d'un resultat
     */
    @GetMapping("/details")
    public String resultatDetails(@RequestParam("idResultat") long idResultat, Model model) {
        Resultat resultat = resultatService.getResultatById(idResultat);
        Proces proces = procesService.getProcesById(resultat.getProces().getIdProces());
        model.addAttribute("resultatDetails", resultat);
        model.addAttribute("procesDetails", proces);
        return "resultatDetails";
    }

    /**
     * Retorna tots els resultats d'un usuari (Actualment no utilitzat)
     *
     * @param userId id de l'usuari
     * @param model model de la plantilla dels resultats de l'usuari
     * @return retorna null
     */
    @GetMapping("/byusuari")
    public String getResultatByUsuari(@RequestParam("idUsuari") long userId, Model model) {
        return null;
    }

    /**
     * * Retorna tots els resultats d'un procés
     *
     * @param idProces id del procés
     * @param model model de la plantilla dels resultats d'un procés
     * @return retorna la llista dels resultats
     */
    @GetMapping("/byproces")
    public String getResultatByProces(@RequestParam("idProces") long idProces, Model model) {
        List<Resultat> resultatsPerProces = resultatService.getResultatsByProces(idProces);
        model.addAttribute("idProces", idProces);
        model.addAttribute("resultatsBD", resultatsPerProces);
        return "resultatLlistat";
    }

    /**
     * Mètode que retorna la vista de la gràfica de barres que mostra el temps
     * emprat per cada usuari obtinguts dels resultats dels diferents usuaris
     * que han realitzat un procés
     *
     * @param idProces id del procés seleccionat per veure els resultats del
     * mateix
     * @param model model de la vista de la gràfica
     * @return retorna la vista de la gràfica
     */
    @GetMapping("/byproceschart")
    public String getResultatByProcesChart(@RequestParam("idProces") long idProces, Model model) {
        Proces proces = procesService.getProcesById(idProces);
        List<Resultat> resultatsPerProces = resultatService.getResultatsByProces(idProces);
        List<Long> tempsUsuaris = new ArrayList<>();
        List<String> noms = new ArrayList<>();

        //Afegeix el temps i el nom de l'usuari per afegir-lo al model
        for (Resultat r : resultatsPerProces) {
            noms.add((r.getUsuari().getNom() + " "
                    + r.getUsuari().getCognom1()));
            tempsUsuaris.add(r.getTempsTotal());

        }

        model.addAttribute("proces", proces);
        model.addAttribute("usuaris", noms);
        model.addAttribute("tempsusuaris", tempsUsuaris);
        return "graficaUsuariTempsTotal";
    }

    /**
     * Retorna vista amb totes les seccions per tal de que l'administrador pugui
     * cercar els resultats seleccionant primer una secció per veure les
     * instal·lacions que conté aquesta
     *
     * @param model model de la plantilla de selecció de secció
     * @return vista amb les seccions seleccionables
     */
    @RequestMapping("/selectsection")
    public String selectOneSeccio(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "perSeccio";
    }

    /**
     * Retorna vista amb les instal·lacions que conté la secció per tal que
     * l'administrador pugui cercar els resultats seleccionant una instal·lació
     * per veure les referències que conté aquesta
     *
     * @param idSeccio id de la secció
     * @param model model de la plantilla de selecció d'instal·lació
     * @return vista amb les instalacions seleccionables
     */
    @RequestMapping("/byseccio")
    public String getInstalacionsBySeccio(@RequestParam("idSeccio") long idSeccio, Model model) {
        model.addAttribute("instalacions", instalacioService.getInstalacioBySeccio(idSeccio));
        return "perInstalacio";
    }

    /**
     * Retorna vista amb les referències que conté l'instal·lació per tal que
     * l'administrador pugui cercar els resultats seleccionant una rferència per
     * veure els processos que conté aquesta
     *
     * @param idInstalacio id de l'instal·lació
     * @param model model de la plantilla de selecció de referència
     * @return vista amb les referències seleccionables
     */
    @GetMapping("/byinstalacio")
    public String getReferenciesByInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        model.addAttribute("referencies", referenciaService.getReferenciesByInstalacio(idInstalacio));
        return "perReferencia";
    }

    /**
     * Retorna vista amb els processos que conté la referència de producte per
     * tal que l'administrador pugui veure els resultats del procés que
     * seleccioni
     *
     * @param idReferencia id de referència
     * @param model model de la plantilla de selecció de procés
     * @return vista amb els processos seleccionables
     */
    @GetMapping("byreferencia")
    public String getProcessosByReferencia(@RequestParam("idReferencia") long idReferencia, Model model) {
        model.addAttribute("processos", procesService.getProcessosByReferencia(idReferencia));
        return "perProces";
    }

    /**
     * Esborra el resultat per la ID
     *
     * @param idResultat id del resultat
     * @param redirectAttributes idProces per poder redireccionar a la vista
     * dels resultats del mateix procés un cop esborrat un
     * @return redirecció a la vista de resultats del mateix procés
     * @throws ServletException excepció d'error de servlet
     * @throws IOException excepció d'error d'entrada i sortida
     */
    @GetMapping("/delete")
    public String deleteResultat(@RequestParam("idResultat") long idResultat,
            RedirectAttributes redirectAttributes) throws ServletException, IOException {
        Resultat resultat = resultatService.getResultatById(idResultat);

        redirectAttributes.addAttribute("idProces", resultat.getProces().getIdProces());

        resultatService.deleteResultat(idResultat);
        return "redirect:/resultats/byproces/";
    }

}
