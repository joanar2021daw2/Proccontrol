package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.service.impl.InstalacioServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ResultatServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.SeccioServiceImpl;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/resultats")
public class ResultatController {

	/**
	 * Servei d'implementació per resultat
	 */
    @Autowired
    ResultatServiceImpl resultatService;

    /**
     * Servei d'implementació per secció
     */
    @Autowired
    SeccioServiceImpl seccioService;

    /**
     * Servei d'implementació per instal·lació
     */
    @Autowired
    InstalacioServiceImpl instalacioService;

    /**
     * Servei d'implementació per referència
     */
    @Autowired
    ReferenciaServiceImpl referenciaService;

    /**
     * Servei d'implementació per procés
     */
    @Autowired
    ProcesServiceImpl procesService;

    /**
     * Obtenir detalls de resultat
     * @param idResultat id de resultat
     * @param model model de resultat
     * @return retonar detalls d'un resultat
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
     * Obtenir resultat per un usuari
     * @param userId id de l'usuari
     * @param model model de l'usuari
     * @return retornar null
     */
    @GetMapping("/byusuari")
    public String getResultatByUsuari(@RequestParam("idUsuari") long userId, Model model) {

        return null;
    }

    /**
     * Obtenir resultat per procés
     * @param idProces id d'un procés
     * @param model d'un procés
     * @return retornar la llista dels resultats
     */
    @GetMapping("/byproces")
    public String getResultatByProces(@RequestParam("idProces") long idProces, Model model) {
        List<Resultat> resultatsPerProces = resultatService.getResultatsByProces(idProces);
        model.addAttribute("idProces", idProces);
        model.addAttribute("resultatsBD", resultatsPerProces);
        return "resultatLlistat";
    }

    /**
     * Mètode que retorna la vista de la gràfica de barres que mostra usuari/tempsTotal
     * dels resultats obtinguts pels diferents usuaris que han realitzat un procés
     * @param idProces
     * @param model id del procés seleccionat a l'hora de veure els resultats del mateix
     * @return retornar vista gràfica de temps total
     */
    @GetMapping("/byproceschart")
    public String getResultatByProcesChart(@RequestParam("idProces") long idProces, Model model) {
        Proces proces = procesService.getProcesById(idProces);
        List<Resultat> resultatsPerProces = resultatService.getResultatsByProces(idProces);
        List<Long> tempsUsuaris = new ArrayList<>();
        List<String> noms = new ArrayList<>();

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
     * Retornar seccions per que l'usuari seleccioni una i verue les instalacions
     * @param model de seleccionar un procés
     * @return tots els processos disponibles
     */
    @RequestMapping("/selectsection")
    public String selectOneSeccio(Model model) {
        model.addAttribute("seccionsBD", seccioService.getAllSeccions());
        return "perSeccio";
    }

    /**
     * Selecciona les instalacions que hi han a la secció
     * @param idSeccio id de secció 
     * @param model de secció
     * @return instalació per triar
     */
    @RequestMapping("/byseccio")
    public String getInstalacionsBySeccio(@RequestParam("idSeccio") long idSeccio, Model model) {
        model.addAttribute("instalacions", instalacioService.getInstalacioBySeccio(idSeccio));
        return "perInstalacio";
    }

    /**
     * Retorna llistat de les referencias d'una instal·lació
     * @param idInstalacio id de l'instal·lació
     * @param model model de instal·lació
     * @return llista de els referències 
     */
    @GetMapping("/byinstalacio")
    public String byInstalacio(@RequestParam("idInstalacio") long idInstalacio, Model model) {
        model.addAttribute("referencies", referenciaService.getReferenciesByInstalacio(idInstalacio));
        return "perReferencia";
    }

    /**
     * Retorna llistat dels processos d'una referència de producte
     * @param idReferencia id de referència
     * @param model de referència
     * @return llistat dels processos d'una referència de producte
     */
    @GetMapping("byreferencia")
    public String byReferencia(@RequestParam("idReferencia") long idReferencia, Model model) {
        model.addAttribute("processos", procesService.getProcessosByReferencia(idReferencia));
        return "perProces";
    }

    /**
     * Esborra el resultat per la ID
     * @param idResultat id d'un resultat que volem esborrar
     * @param redirectAttributes per poder redireccionar
     * @return redirecció a selecció de processos
     * @throws ServletException excepció d'error de servlet
     * @throws IOException excepció d'error d'entrada i salida
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
