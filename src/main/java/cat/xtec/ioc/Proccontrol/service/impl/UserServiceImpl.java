package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei d'usuari
 *
 * @author JoseAndrade
 */
@Service
public class UserServiceImpl {

    /**
     * Repositori d'usuari
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Encriptar la contrasenya
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Guarda usuari a la base de dades
     * @param usuari objecte usuari a desar a la base de dades
     * @return objecte usuari desat a la base de dades
     */
    public Usuari saveUsuari(Usuari usuari) {
        usuari.setPassword(bCryptPasswordEncoder.encode(usuari.getPassword()));
        return userRepository.save(usuari);
    }

    /**
     * Obtenir tots els usuaris
     * @return llistat de tots els usuaris registrats al sistema
     */
    public List<Usuari> getAllUsuaris() {
        return userRepository.findAll();
    }

    /**
     * Obtenir un usuari per id
     * @param id id del compte d'usuari
     * @return usuari amb el id passat per paràmetre
     */
    public Usuari getUsuariById(long id) {
        return userRepository.findByUserId(id);
    }

    /**
     * Obtenir un usuari per nom
     * @param nom nom del usuari
     * @return usuari amb el nom passat al paràmetre
     */
    public Usuari getUsuariByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    /**
     * Obtenir un usuari per número d'operari
     * @param numOperari número d'operari del'usuari
     * @return usuari amb el número d'operari passat al paràmetre
     */
    public Usuari getUserByNumOperari(long numOperari) {
        return userRepository.findByNumOperari(numOperari);
    }

    /**
     * Esborrar un usuari
     * @param id
     * @return llistat d'usuaris
     */
    public String deleteUsuari(long id) {
        userRepository.deleteById(id);
        return "redirect:/users/all";
    }


}
