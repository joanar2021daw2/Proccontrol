package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.repository.SeccioRepository;
import cat.xtec.ioc.Proccontrol.service.SeccioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class SeccioServiceImpl implements SeccioService {

    @Autowired
    SeccioRepository seccioRepo;

    public Seccio saveSeccio(Seccio seccio) {
        return seccioRepo.save(seccio);
    }

    public List<Seccio> getAllSeccions() {
        return seccioRepo.findAll();
    }
    
    public Seccio getSeccioById(long id){
        return seccioRepo.getOne(id);
    }

    public Seccio getSeccioByNom(String nom) {
        return seccioRepo.findByNom(nom);
    }

    public String deleteSeccio(long id) {
        seccioRepo.deleteById(id);
        return "redirect:/seccions/all";
    }

    public Seccio updateSeccio(Seccio seccio) {
        Seccio existingSeccio = seccioRepo.findById(seccio.getIdSeccio()).orElse(null);
        existingSeccio.setNom(seccio.getNom());
        existingSeccio.setTipusProduccio(seccio.getTipusProduccio());
        existingSeccio.setInstalacions(seccio.getInstalacions());
        return seccioRepo.save(existingSeccio);
    }

}
