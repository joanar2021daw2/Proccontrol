package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.repository.ReferenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei de referència
 * @author JoseAndrade
 */
@Service
public class ReferenciaServiceImpl {

	/**
	 * Repositori de referència
	 */
    @Autowired
    ReferenciaRepository referenciaRepo;

    /**
     * Guarda una referència
     */
    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepo.save(referencia);
    }

    /**
     * Obtenir totes les refrències
     */
    public List<Referencia> getAllReferencies() {
        return referenciaRepo.findAll();
    }

    /**
     * Obtenir una referència per id
     */
    public Referencia getReferenciaById(long id) {
        return referenciaRepo.getOne(id);
    }

    /**
     * Obtenir referència per nom
     */
    public Referencia getReferenciaByNom(String nom) {
        return referenciaRepo.findByNom(nom);
    }
    
    public List<Referencia> getReferenciesByInstalacio(long idInstalacio){
        return referenciaRepo.findByInstalacioIdInstalacio(idInstalacio);
    }

    /**
     * Esborra una referència per id
     */
    public String deleteReferencia(long id) {
        referenciaRepo.deleteById(id);
        return "redirect:/referencies/all";
    }

    /**
     * Actualitzar una referència
     */
    public Referencia updateReferencia(Referencia referencia) {
        Referencia existingReferencia = referenciaRepo.findById(referencia.getIdReferencia()).orElse(null);
        existingReferencia.setNom(referencia.getNom());
        existingReferencia.setInstalacio(referencia.getInstalacio());
        existingReferencia.setProcessos(referencia.getProcessos());

        return referenciaRepo.save(existingReferencia);
    }
}
