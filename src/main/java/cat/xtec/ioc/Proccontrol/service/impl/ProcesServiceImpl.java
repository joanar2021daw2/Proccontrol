package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.Exception.ResourceNotFoundException;
import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.repository.ProcesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei de procés
 * @author JoseAndrade
 */
@Service
public class ProcesServiceImpl {

	/**
	 * Repository de procés
	 */
    @Autowired
    private ProcesRepository procesRepo;

    /**
     * Guardar procés
     * @param proces procés que volem guardar
     * @return guardar procés
     */
    public Proces saveProces(Proces proces) {
        return procesRepo.save(proces);
    }

    /**
     * Obtenir tots els processos
     * @return Obtenir tots els processos
     */
    public List<Proces> getAllProcessos() {
        return procesRepo.findAll();
    }

    /**
     * Obtenir un procés per id
     * @param id id de procés
     * @return el procés, si no troba, apareix un error
     */
    public Proces getProcesById(long id) {
        return procesRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existeix un procès amb la id " + id));
    }

    /**
     * Obtenir un procés per nom
     * @param nom nom de procés que volem trobar
     * @return el procés amb el nom indicat
     */
    public Proces getProcesByNom(String nom) {
        return procesRepo.findByNom(nom);
    }
    
    /**
     * Obtenir referència per procés
     * @param idReferencia id de referència
     * @return Obtenir referència per procés
     */
    public List<Proces> getProcessosByReferencia(long idReferencia){
        return procesRepo.findByReferenciaIdReferencia(idReferencia);
    }

    /**
     * Esborrar un procés per id
     * @param id id de procés
     * @return redirecció a la llista de processos
     */
    public String deleteProces(long id) {
        procesRepo.deleteById(id);
        return "redirect:/processos/all";
    }

    /**
     * Actualitzar procés
     * @param proces procés que volem actualitzar
     * @return guardar procés actualitzat
     */
    public Proces updateProces(Proces proces) {
        Proces existingProces = procesRepo.findById(proces.getIdProces()).orElse(null);
        existingProces.setNom(proces.getNom());
        existingProces.setReferencia(proces.getReferencia());
        existingProces.setNumPassos(proces.getNumPassos());      
        return procesRepo.save(existingProces);
    }

}
