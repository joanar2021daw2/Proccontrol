package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.repository.InstalacioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei d'instal·lació
 * @author JoseAndrade
 */
@Service
public class InstalacioServiceImpl {

	/**
	 * Repositori d'instal·lació
	 */
    @Autowired
    InstalacioRepository instalacioRepo;

    /**
     * Guardar l'instal·lació
     */
    public Instalacio saveInstalacio(Instalacio instalacio) {
        return instalacioRepo.save(instalacio);
    }

	/**
	 * Obtenir tots els instal·lacions
	 */
    public List<Instalacio> getAllInstalacions() {
        return instalacioRepo.findAll();
    }

    /**
     * Obtenir un instal·lació per id
     */
    public Instalacio getInstalacioById(long id) {
        return instalacioRepo.getOne(id);
    }
    
    /**
     * Obtenir un instal·lació per nom 
     * @param nom
     * @return
     */
    public Instalacio getInstalacioByNom(String nom) {
        return instalacioRepo.findByNom(nom);
    }
    
    public List<Instalacio> getInstalacioBySeccio(long seccio){
        return instalacioRepo.findBySeccioIdSeccio(seccio);
    }

    /**
     * Esborrar un instal·lació per id 
     * @param id
     * @return
     */
    public String deleteInstalacio(long id) {
        instalacioRepo.deleteById(id);
        return "redirect:/instalacions/all";
    }

    /**
     * Actualitza un intal·lació 
     */
    public Instalacio updateInstalacio(Instalacio instalacio) {
        Instalacio existingInstalacio = instalacioRepo.findById(instalacio.getIdInstalacio()).orElse(null);
        existingInstalacio.setNom(instalacio.getNom());
        existingInstalacio.setSeccio(instalacio.getSeccio());
        return instalacioRepo.save(existingInstalacio);
    }
}
