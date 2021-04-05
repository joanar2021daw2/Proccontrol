package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.repository.InstalacioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class InstalacioServiceImpl {

    @Autowired
    InstalacioRepository instalacioRepo;

    public Instalacio saveInstalacio(Instalacio instalacio) {
        return instalacioRepo.save(instalacio);
    }

    public List<Instalacio> getAllInstalacions() {
        return instalacioRepo.findAll();
    }

    public Instalacio getInstalacioById(long id) {
        return instalacioRepo.getOne(id);
    }

    public Instalacio getInstalacioByNom(String nom) {
        return instalacioRepo.findByNom(nom);
    }

    public String deleteInstalacio(long id) {
        instalacioRepo.deleteById(id);
        return "redirect:/instalacions/all";
    }

    public Instalacio updateInstalacio(Instalacio seccio) {
        Instalacio existingInstalacio = instalacioRepo.findById(seccio.getIdInstalacio()).orElse(null);
        existingInstalacio.setNom(seccio.getNom());
        //modificar referencies i secció
        return instalacioRepo.save(existingInstalacio);
    }
}
