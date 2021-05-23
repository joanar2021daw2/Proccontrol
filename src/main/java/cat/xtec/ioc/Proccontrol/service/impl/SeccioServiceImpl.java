package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import cat.xtec.ioc.Proccontrol.repository.SeccioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementació del servei de les seccions
 *
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
     * Guarda una secció
     *
     * @param seccio que volem guardar
     * @return Guardar un secció
     */
    public Seccio saveSeccio(Seccio seccio) {
        return seccioRepo.save(seccio);
    }

    /**
     * Obté tots els seccions
     *
     * @return Obtenir tots els seccions
     */
    public List<Seccio> getAllSeccions() {
        return seccioRepo.findAll();
    }

    /**
     * Obté un secció per id
     *
     * @param id id de secció
     * @return retorna la secció
     */
    public Seccio getSeccioById(long id) {
        return seccioRepo.getOne(id);
    }

    /**
     * Obté un secció per nom
     *
     * @param nom nom de secció
     * @return retorna la secció
     */
    public Seccio getSeccioByNom(String nom) {
        return seccioRepo.findByNom(nom);
    }

    /**
     * Esborrar una secció per id
     *
     * @param id id de la secció
     * @return redirecció a la llista de seccions
     */
    public String deleteSeccio(long id) {
        seccioRepo.deleteById(id);
        return "redirect:/seccions/all";
    }

}
