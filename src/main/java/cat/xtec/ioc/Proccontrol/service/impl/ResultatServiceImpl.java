package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.repository.ResultatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class ResultatServiceImpl {
    
    @Autowired
    ResultatRepository resultatRepo;
    
    public Resultat saveResultat(Resultat resultat){
        return resultatRepo.save(resultat);
    }
    
    public List<Resultat> getAllResultats(){
        return resultatRepo.findAll();
    }
    
    public Resultat getResultatById(long idResultat){
        return resultatRepo.getOne(idResultat);
    }
    
    public List<Resultat> getResultatsByUsuari(long userId){
        return resultatRepo.findByUsuariUserId(userId);
    }
    
    public List<Resultat> getResultatsByProces(long idProces){
        return resultatRepo.findByProcesIdProces(idProces);
    }
    
     public String deleteResultat(long id) {
        resultatRepo.deleteById(id);
        return "redirect:/edicio";
    }
    
    //De moment no actualitzem resultats 
    /*public updateResultat(Resultat resultat){
        Resultat existingResultat = resultatRepo.findById(resultat.getIdResultat()).orElse(null);                
    }*/
}
