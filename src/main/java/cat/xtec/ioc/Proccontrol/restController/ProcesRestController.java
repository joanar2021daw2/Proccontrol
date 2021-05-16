package cat.xtec.ioc.Proccontrol.restController;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Aquesta classe serveix per crear referència, procès, vincular-les  
 * @author JoseAndrade
 */
@RestController

@RequestMapping("/api/v1/")
public class ProcesRestController {

	/**
	 * Servei de procés
	 */
    @Autowired
    ProcesServiceImpl procesService;
    
    /**
     * Servei de referència
     */
    @Autowired
    ReferenciaServiceImpl referenciaService;

    /**
     * 
     * @return Retorna llistat de tots els processos rest api*
     */
    @GetMapping("/processos")
    public List<Proces> getAllProcessos() {
        return procesService.getAllProcessos();
    }

    /**
     * Retorna procés per id rest api
     * @param idProces Identificador del procés
     * @return Objecte JSON del procés
     */
    @GetMapping("/processos/{idProces}")
    public ResponseEntity<Proces> getProcesById(@PathVariable Long idProces) {
        Proces proces = procesService.getProcesById(idProces);
        return ResponseEntity.ok(proces);
    }

    /**
     * Afegeix un procés rest api
     * @param proces Objecte JSON del procés
     * @return Objecte JSON del procés
     */
    @PostMapping(path = "/newproces", consumes = "application/json; charset=utf-8")
    public Proces newProces(@RequestBody Proces proces) {
        Calendar calendar = Calendar.getInstance();
        proces.setDataRegistre(calendar.getTime());
        procesService.saveProces(proces);
        return procesService.saveProces(proces);
    }

    /**
     * Actualitza un procès rest api
     * @param idProces Identificador del procés
     * @param procesDetails Objecte JSON del procés
     * @return Objecte JSON del procés
     */
    @PutMapping("/processos/{idProces}")
    public ResponseEntity<Proces> updateProces(@PathVariable Long idProces,
            @RequestBody Proces procesDetails) {
        Proces proces = procesService.getProcesById(idProces);

        proces.setNom(procesDetails.getNom());
        proces.setReferencia(procesDetails.getReferencia());
        proces.setNumPassos(procesDetails.getNumPassos());
        proces.setPassos(procesDetails.getPassos());        

        Proces updatedProces = procesService.saveProces(proces);
        return ResponseEntity.ok(updatedProces);
    }

    /**
     * Esborra un procès rest api
     * @param idProces Identificador del procés
     * @return Objecte JSON del procés
     */
    @DeleteMapping("/processos/{idProces}")
    public ResponseEntity<Map<String, Boolean>> deleteProces(@PathVariable Long idProces) {
        Map<String, Boolean> response = new HashMap<>();
        
        procesService.deleteProces(idProces);
        response.put("eliminat", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /**
     * 
     * @return Retorna llistat de referències rest api
     */
    @GetMapping("/referencies")
    public List<Referencia> getAllReferencies() {
        return referenciaService.getAllReferencies();
    }
    
    /**
     * 
     * @param ref Objecte JSON del la referència
     * @return Crea un objecte JSON de la referència
     */
    @PostMapping(path = "/newref", consumes = "application/json; charset=utf-8")
    public Referencia newRef(@RequestBody Referencia ref) {
        return referenciaService.saveReferencia(ref);
    }

}
