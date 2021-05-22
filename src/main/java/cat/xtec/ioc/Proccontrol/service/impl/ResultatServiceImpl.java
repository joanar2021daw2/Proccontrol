package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.repository.ResultatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe servei per veure els resultats de processos
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
     * Guardar resultat
     * @param resultat que volem guardar
     * @return guardar resultat
     */
    public Resultat saveResultat(Resultat resultat){
        return resultatRepo.save(resultat);
    }
    
    /**
     * Obtenir tots els resultats
     * @return retorna tots els resultats
     */
    public List<Resultat> getAllResultats(){
        return resultatRepo.findAll();
    }
    
    /**
     * Obtenir resulat per id resultat
     * @param idResultat id resultat que volem buscar
     * @return retornar resultat que volem buscar
     */
    public Resultat getResultatById(long idResultat){
        return resultatRepo.getOne(idResultat);
    }
    
    /**
     * Obtenr resultats per usuari
     * @param userId id d'usuari que volem buscar
     * @return retorna usuari amb aquel id
     */
    public List<Resultat> getResultatsByUsuari(long userId){
        return resultatRepo.findByUsuariUserId(userId);
    }
    
    /**
     * Obtenir els resultats per procés
     * @param idProces id procés
     * @return retornar proces que busquem
     */
    public List<Resultat> getResultatsByProces(long idProces){
        return resultatRepo.findByProcesIdProces(idProces);
    }
    
    /**
     * Esborrar resultat
     * @param id id de resultat que volem esborrar
     * @return redirecció a menú d'edició
     */
     public String deleteResultat(long id) {
        resultatRepo.deleteById(id);
        return "redirect:/edicio";
    }
    
    //De moment no actualitzem resultats 
    /*public updateResultat(Resultat resultat){
        Resultat existingResultat = resultatRepo.findById(resultat.getIdResultat()).orElse(null);                
    }*/
}
