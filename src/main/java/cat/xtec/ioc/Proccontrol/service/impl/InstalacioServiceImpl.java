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
     * @param instalacio instal·lació que volem guardar
     * @return guardar l'instal·lació
     */
    public Instalacio saveInstalacio(Instalacio instalacio) {
        return instalacioRepo.save(instalacio);
    }

	/**
	 * Obtenir tots els instal·lacions
	 * @return tots els instal·lacions
	 */
    public List<Instalacio> getAllInstalacions() {
        return instalacioRepo.findAll();
    }

    /**
     * Obtenir un instal·lació per id
     * @param id id de l'instal·lació
     * @return instal·lació amb aquel id
     */
    public Instalacio getInstalacioById(long id) {
        return instalacioRepo.getOne(id);
    }
    
    /**
     * Obtenir un instal·lació per nom 
     * @param nom
     * @return instal·lació amb aquel nom
     */
    public Instalacio getInstalacioByNom(String nom) {
        return instalacioRepo.findByNom(nom);
    }
    
    /**
     * Obtenir secció per l'instal·lació
     * @param seccio id de secció
     * @return secciño amb aquel id de secció
     */
    public List<Instalacio> getInstalacioBySeccio(long seccio){
        return instalacioRepo.findBySeccioIdSeccio(seccio);
    }

    /**
     * Esborrar un instal·lació per id 
     * @param id
     * @return redirecció la llista d'instal·lacions
     */
    public String deleteInstalacio(long id) {
        instalacioRepo.deleteById(id);
        return "redirect:/instalacions/all";
    }

}
