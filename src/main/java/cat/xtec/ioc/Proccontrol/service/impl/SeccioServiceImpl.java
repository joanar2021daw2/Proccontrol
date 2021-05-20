package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.repository.SeccioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei de secció
 * @author JoseAndrade
 */
@Service
public class SeccioServiceImpl {

	/**
	 * Repositori de secció
	 */
    @Autowired
    SeccioRepository seccioRepo;

    /**
     * Guardar un secció
     * @param seccio que volem guardar
     * @return Guardar un secció
     */
    public Seccio saveSeccio(Seccio seccio) {
        return seccioRepo.save(seccio);
    }

    /**
     * Obtenir tots els seccions
     * @return Obtenir tots els seccions
     */
    public List<Seccio> getAllSeccions() {
        return seccioRepo.findAll();
    }

    /**
     * Obtenir un secció per id
     * @param id id de secció
     * @return retorna el secció que busquem per id
     */
    public Seccio getSeccioById(long id){
        return seccioRepo.getOne(id);
    }

    /**
     *  Obtenir un secció per nom
     * @param nom de secció
     * @return secció que busquem
     */
    public Seccio getSeccioByNom(String nom) {
        return seccioRepo.findByNom(nom);
    }

    /**
     * Esborrar un secció per id
     * @param id id de secció
     * @return redirecció a la llista de seccions
     */
    public String deleteSeccio(long id) {
        seccioRepo.deleteById(id);
        return "redirect:/seccions/all";
    }

    /**
     * Actualitzar un secció
     * @param seccio secció que volem actualitzar
     * @return guardar secció actualitzat
     */
    public Seccio updateSeccio(Seccio seccio) {
        Seccio existingSeccio = seccioRepo.findById(seccio.getIdSeccio()).orElse(null);
        existingSeccio.setNom(seccio.getNom());
        existingSeccio.setTipusProduccio(seccio.getTipusProduccio());
        existingSeccio.setInstalacions(seccio.getInstalacions());
        return seccioRepo.save(existingSeccio);
    }

}
