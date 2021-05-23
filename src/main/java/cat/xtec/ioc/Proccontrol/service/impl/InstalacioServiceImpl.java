package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.repository.InstalacioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementació del servei de les instal·lacions
 *
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
     * Guarda l'instal·lació a la base de dades
     *
     * @param instalacio instal·lació a desar
     * @return ordre al repositori per guardar l'instal·lació
     */
    public Instalacio saveInstalacio(Instalacio instalacio) {
        return instalacioRepo.save(instalacio);
    }

    /**
     * Obté un llistat de totes les instal·lacions
     *
     * @return llistat de les instal·lacions
     */
    public List<Instalacio> getAllInstalacions() {
        return instalacioRepo.findAll();
    }

    /**
     * Obté un instal·lació pel seu id
     *
     * @param id id de l'instal·lació
     * @return objecte instal·lació amb l'id passada per paràmetre
     */
    public Instalacio getInstalacioById(long id) {
        return instalacioRepo.getOne(id);
    }

    /**
     * Obté una instal·lació pel seu nom
     *
     * @param nom nom de la instal·lació
     * @return instal·lació amb el nom passat per paràmetre
     */
    public Instalacio getInstalacioByNom(String nom) {
        return instalacioRepo.findByNom(nom);
    }

    /**
     * Obté el llistat d'instal·lacions que conté una secció
     *
     * @param seccio id de la secció
     * @return llistat d'instal·lacions
     */
    public List<Instalacio> getInstalacioBySeccio(long seccio) {
        return instalacioRepo.findBySeccioIdSeccio(seccio);
    }

    /**
     * Esborra una instal·lació pel seu id
     *
     * @param id id de la instal·lació a esborrar
     * @return redirecció la llista d'instal·lacions
     */
    public String deleteInstalacio(long id) {
        instalacioRepo.deleteById(id);
        return "redirect:/instalacions/all";
    }

}
