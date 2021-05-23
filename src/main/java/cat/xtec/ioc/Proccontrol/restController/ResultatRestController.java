package cat.xtec.ioc.Proccontrol.restController;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.ProcesServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.ResultatServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controladora de les peticions dels clients rest pels resultats
 *
 * @author JoseAndrade
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/resultat/")
public class ResultatRestController {

    /**
     * Servei resultats
     */
    @Autowired
    ResultatServiceImpl resultatService;

    /**
     * Servei processos
     */
    @Autowired
    ProcesServiceImpl procesService;

    /**
     * Servei usuaris
     */
    @Autowired
    UserServiceImpl usuariService;

    /**
     * Mètode que afegeix un resultat, rest api
     *
     * @param resultat
     * @Param resultat és el resultat creat a Angular que conté els temps,
     * comentaris, l'id de proces i l'id de l'usuari
     * @return ordre de desar el resultat a la base de dades
     */
    @PostMapping(path = "/saveresultat", consumes = "application/json; charset=utf-8")
    public Resultat newResultat(@RequestBody Resultat resultat) {
        Calendar calendar = Calendar.getInstance();
        Usuari usuari = usuariService.getUsuariById(resultat.getUsuari().getUserId());
        Proces proces = procesService.getProcesById(resultat.getProces().getIdProces());

        resultat.setUsuari(usuari);
        resultat.setProces(proces);
        resultat.setDataRegistre(calendar.getTime());

        return resultatService.saveResultat(resultat);
    }

}
