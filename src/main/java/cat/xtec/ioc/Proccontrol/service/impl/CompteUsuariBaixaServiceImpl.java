package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.CompteUsuariBaixa;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.CompteUsuariBaixaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class CompteUsuariBaixaServiceImpl {

    @Autowired
    private CompteUsuariBaixaRepository compteUsuariBaixaRepo;

    /**
     * Guarda el CompteUsuariBaixa a la base de dades
     *
     * @param compte objecte compteUsuariBaixa a desar a la base de dades
     * @return objecte compteUsuariBaixa desat a la base de dades
     */
    public CompteUsuariBaixa saveCompteUsuariBaixa(CompteUsuariBaixa compte) {
        return compteUsuariBaixaRepo.save(compte);
    }

    /**
     * Mètode que obté el històric dels comptes donats de baixa
     *
     * @return llistat dels comptes donats de baixa
     */
    public List<CompteUsuariBaixa> getAllComptesDeBaixa() {
        return compteUsuariBaixaRepo.findAll();
    }

    /**
     * Obtenir un registre del històric de comptes de baixa per l'id del compte
     *
     * @param id id del compte d'usuari
     * @return usuari amb el id passat per paràmetre
     */
    public CompteUsuariBaixa getCompteUsuariBaixaById(long id) {
        return compteUsuariBaixaRepo.findByidCompteUsuariBaixa(id);
    }

    /**
     * Obtenir un registre del històric de comptes de baixa pel nom
     *
     * @param nom nom del usuari del compte
     * @return usuari amb el nom passat al paràmetre
     */
    public CompteUsuariBaixa getCompteUsuariBaixaByNom(String nom) {
        return compteUsuariBaixaRepo.findByNom(nom);
    }

    /**
     * Obté un registre del històric de comptes de baixa pel número d'operari
     *
     * @param numOperari número d'operari de l'usuari
     * @return usuari amb el número d'operari passat al paràmetre
     */
    public CompteUsuariBaixa getCompteUsuariBaixaByNumOperari(long numOperari) {
        return compteUsuariBaixaRepo.findByNumOperari(numOperari);
    }

    /**
     * Obté un registre del històric de comptes de baixa pel número d'operari
     *
     * @param id id del compte d'usuari donat de baixa 
     */
    public void deleteCompteUsuariBaixa(long id) {
        compteUsuariBaixaRepo.deleteById(id);        
    }
}
