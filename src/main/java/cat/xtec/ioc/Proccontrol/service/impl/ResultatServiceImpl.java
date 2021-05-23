package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.repository.ResultatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementació del servei dels resultats
 *
 * @author JoseAndrade
 */
@Service
public class ResultatServiceImpl {

    /**
     * Repositori de resultat
     */
    @Autowired
    ResultatRepository resultatRepo;

    /**
     * Guarda resultat a la base de dades
     *
     * @param resultat que volem guardar
     * @return guardar resultat
     */
    public Resultat saveResultat(Resultat resultat) {
        return resultatRepo.save(resultat);
    }

    /**
     * Obté un llistat de tots els resultats
     *
     * @return retorna llistat dels resultats
     */
    public List<Resultat> getAllResultats() {
        return resultatRepo.findAll();
    }

    /**
     * Obté resulat pel seu id
     *
     * @param idResultat id resultat
     * @return retorna resultat cercat
     */
    public Resultat getResultatById(long idResultat) {
        return resultatRepo.getOne(idResultat);
    }

    /**
     * Obté els resultats d'un usuari
     *
     * @param userId id d'usuari
     * @return retorna llistat de resultats de l'usuari
     */
    public List<Resultat> getResultatsByUsuari(long userId) {
        return resultatRepo.findByUsuariUserId(userId);
    }

    /**
     * Obté els resultats d'un procés
     *
     * @param idProces id del procés
     * @return llistat de resultats del procés 
     */
    public List<Resultat> getResultatsByProces(long idProces) {
        return resultatRepo.findByProcesIdProces(idProces);
    }

    /**
     * Esborra un resultat
     *
     * @param id id de resultat
     * @return redirecció a menú d'edició
     */
    public String deleteResultat(long id) {
        resultatRepo.deleteById(id);
        return "redirect:/edicio";
    }

}
