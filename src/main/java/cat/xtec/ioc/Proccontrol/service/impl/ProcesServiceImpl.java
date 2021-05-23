package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.Exception.ResourceNotFoundException;
import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.repository.ProcesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementació del servei dels processos
 *
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
     *
     * @param proces procés a guardar
     * @return ordre al repositori per guardar el procés
     */
    public Proces saveProces(Proces proces) {
        return procesRepo.save(proces);
    }

    /**
     * Obté llistat de tots els processos
     *
     * @return llistat de tots els processos
     */
    public List<Proces> getAllProcessos() {
        return procesRepo.findAll();
    }

    /**
     * Obté un procés pel seu id
     *
     * @param id id de procés
     * @return objecte proces o excepció si no es troba
     */
    public Proces getProcesById(long id) {
        return procesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existeix un procès amb la id " + id));
    }

    /**
     * Obté un procés pel seu nom
     *
     * @param nom nom de procés que volem trobar
     * @return el procés amb el nom indicat
     */
    public Proces getProcesByNom(String nom) {
        return procesRepo.findByNom(nom);
    }

    /**
     * Obté un llistat dels processos que conté una referència
     *
     * @param idReferencia id de referència
     * @return llistat dels processos de la referència passada
     */
    public List<Proces> getProcessosByReferencia(long idReferencia) {
        return procesRepo.findByReferenciaIdReferencia(idReferencia);
    }

    /**
     * Esborra un procés pel seu id
     *
     * @param id id de procés
     * @return redirecció a la llista de processos
     */
    public String deleteProces(long id) {
        procesRepo.deleteById(id);
        return "redirect:/processos/all";
    }

    /**
     * Actualitza procés
     *
     * @param proces procés que volem actualitzar
     * @return guarda procés actualitzat
     */
    public Proces updateProces(Proces proces) {
        Proces existingProces = procesRepo.findById(proces.getIdProces()).orElse(null);
        existingProces.setNom(proces.getNom());
        existingProces.setReferencia(proces.getReferencia());
        existingProces.setNumPassos(proces.getNumPassos());
        return procesRepo.save(existingProces);
    }

}
