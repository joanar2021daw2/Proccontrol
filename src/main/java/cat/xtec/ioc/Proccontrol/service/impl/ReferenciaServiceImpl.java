package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.repository.ReferenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class ReferenciaServiceImpl {

    @Autowired
    ReferenciaRepository referenciaRepo;

    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepo.save(referencia);
    }

    public List<Referencia> getAllReferencies() {
        return referenciaRepo.findAll();
    }

    public Referencia getReferenciaById(long id) {
        return referenciaRepo.getOne(id);
    }

    public Referencia getReferenciaByNom(String nom) {
        return referenciaRepo.findByNom(nom);
    }
    
    public List<Referencia> getReferenciesByInstalacio(long idInstalacio){
        return referenciaRepo.findByInstalacioIdInstalacio(idInstalacio);
    }

    public String deleteReferencia(long id) {
        referenciaRepo.deleteById(id);
        return "redirect:/referencies/all";
    }

    public Referencia updateReferencia(Referencia referencia) {
        Referencia existingReferencia = referenciaRepo.findById(referencia.getIdReferencia()).orElse(null);
        existingReferencia.setNom(referencia.getNom());
        existingReferencia.setInstalacio(referencia.getInstalacio());
        existingReferencia.setProcessos(referencia.getProcessos());

        return referenciaRepo.save(existingReferencia);
    }
}
