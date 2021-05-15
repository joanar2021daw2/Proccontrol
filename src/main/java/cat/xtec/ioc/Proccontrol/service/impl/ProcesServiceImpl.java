package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.Exception.ResourceNotFoundException;
import cat.xtec.ioc.Proccontrol.domain.Proces;
import cat.xtec.ioc.Proccontrol.repository.ProcesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class ProcesServiceImpl {

    @Autowired
    private ProcesRepository procesRepo;

    public Proces saveProces(Proces proces) {
        return procesRepo.save(proces);
    }

    public List<Proces> getAllProcessos() {
        return procesRepo.findAll();
    }

    public Proces getProcesById(long id) {
        return procesRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existeix un procès amb la id " + id));
    }

    public Proces getProcesByNom(String nom) {
        return procesRepo.findByNom(nom);
    }
    
    public List<Proces> getProcessosByReferencia(long idReferencia){
        return procesRepo.findByReferenciaIdReferencia(idReferencia);
    }

    public String deleteProces(long id) {
        procesRepo.deleteById(id);
        return "redirect:/processos/all";
    }

    public Proces updateProces(Proces proces) {
        Proces existingProces = procesRepo.findById(proces.getIdProces()).orElse(null);
        existingProces.setNom(proces.getNom());
        existingProces.setReferencia(proces.getReferencia());
        existingProces.setNumPassos(proces.getNumPassos());      
        return procesRepo.save(existingProces);
    }

}
