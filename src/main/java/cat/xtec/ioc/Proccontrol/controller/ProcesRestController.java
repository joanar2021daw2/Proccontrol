package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ReferenciaServiceImpl;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JoseAndrade
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ProcesRestController {

    @Autowired
    ProcesServiceImpl procesService;

    @Autowired
    ReferenciaServiceImpl referenciaService;

    /*Retorna llistat de tots els processos rest api*/
    @GetMapping("/processos")
    public List<Proces> getAllProcessos() {
        return procesService.getAllProcessos();
    }

    /*Afegeix un procès rest api*/
    @PostMapping(path = "/newproces", consumes = "application/json; charset=utf-8")
    public Proces newProces(@RequestBody Proces proces) {
        Calendar calendar = Calendar.getInstance();
        proces.setDataRegistre(calendar.getTime());
        procesService.saveProces(proces);
        return procesService.saveProces(proces);
    }

    /*Retorna llitst de referències rest api*/
    @GetMapping("/referencies")
    public List<Referencia> getAllReferencies() {
        return referenciaService.getAllReferencies();
    }

    @PostMapping(path = "/newref", consumes = "application/json; charset=utf-8")
    public Referencia newRef(@RequestBody Referencia ref) {
        return referenciaService.saveReferencia(ref);
    }

}
