package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Referencia;
import cat.xtec.ioc.Proccontrol.repository.ReferenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementació del servei de les referències
 *
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
     * Guarda una referència a la base de dades
     *
     * @param referencia que volem guardar
     * @return guardar aquesta referència
     */
    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepo.save(referencia);
    }

    /**
     * Obté un llistat de totes les refrències
     *
     * @return llistat de les refrències
     */
    public List<Referencia> getAllReferencies() {
        return referenciaRepo.findAll();
    }

    /**
     * Obté una referència pel seu id
     *
     * @param id id referència
     * @return referència amb l'id passat
     */
    public Referencia getReferenciaById(long id) {
        return referenciaRepo.getOne(id);
    }

    /**
     * Obté referència pel seu nom
     *
     * @param nom nom de referència
     * @return retorna la referència amb el nom indiciat
     */
    public Referencia getReferenciaByNom(String nom) {
        return referenciaRepo.findByNom(nom);
    }

    /**
     * Obté el llistat de referències que conté l'intal·lació
     *
     * @param idInstalacio id instal·lació
     * @return llistat de referències
     */
    public List<Referencia> getReferenciesByInstalacio(long idInstalacio) {
        return referenciaRepo.findByInstalacioIdInstalacio(idInstalacio);
    }

    /**
     * Esborra una referència pel seu id
     *
     * @param id id de la referència
     * @return redirecció a la llista de referències
     */
    public String deleteReferencia(long id) {
        referenciaRepo.deleteById(id);
        return "redirect:/referencies/all";
    }

}
