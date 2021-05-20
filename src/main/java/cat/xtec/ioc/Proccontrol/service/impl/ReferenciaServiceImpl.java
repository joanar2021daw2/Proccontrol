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
	 * @param referencia que volem guardar
	 * @return guardar aquesta referència
	 */
    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepo.save(referencia);
    }

    /**
     * Obtenir totes les refrències
     * @return Obtenir totes les refrències
     */
    public List<Referencia> getAllReferencies() {
        return referenciaRepo.findAll();
    }

    /**
     * Obtenir una referència per id
     * @param id id referència
     * @return referència amb aquel id
     */
    public Referencia getReferenciaById(long id) {
        return referenciaRepo.getOne(id);
    }

    /**
     * Obtenir referència per nom
     * @param nom nom de referència
     * @return retorna la referència amb el nom indiciat
     */
    public Referencia getReferenciaByNom(String nom) {
        return referenciaRepo.findByNom(nom);
    }
    
    /**
     * Obtenir instal·lació per referències
     * @param idInstalacio id instal·lació
     * @return instal·lació amb aquel id per poder seleccionar per referència
     */
    public List<Referencia> getReferenciesByInstalacio(long idInstalacio){
        return referenciaRepo.findByInstalacioIdInstalacio(idInstalacio);
    }

    /**
     * Esborra una referència per id
     * @param id id de procés
     * @return redirecció a la llista de processos
     */
    public String deleteReferencia(long id) {
        referenciaRepo.deleteById(id);
        return "redirect:/referencies/all";
    }

    /**
     * Actualitzar una referència
     * @param referencia que volem actualitzar
     * @return guardar referència actualitzada
     */
    public Referencia updateReferencia(Referencia referencia) {
        Referencia existingReferencia = referenciaRepo.findById(referencia.getIdReferencia()).orElse(null);
        existingReferencia.setNom(referencia.getNom());
        existingReferencia.setInstalacio(referencia.getInstalacio());
        existingReferencia.setProcessos(referencia.getProcessos());

        return referenciaRepo.save(existingReferencia);
    }
}
