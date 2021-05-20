package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Aquesta classe serveix per implementar servei d'usuari
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
     * Crear usuari
     * @param usuari omplit
     * @return guardar usuari
     */
    public Usuari saveUsuari(Usuari usuari) {
        usuari.setPassword(bCryptPasswordEncoder.encode(usuari.getPassword()));
        return userRepository.save(usuari);
    }

    /**
     * Obtenir tots els usuaris
     * @return retornar tots els usuaris
     */
    public List<Usuari> getAllUsuaris() {
        return userRepository.findAll();
    }

    /**
     * Obtenir un usuari per id
     * @param id id de l'usuari 
     * @return retornar usuari que busquem
     */
    public Usuari getUsuariById(long id) {
        return userRepository.findByUserId(id);
    }

    /**
     * Obtenir un usuari per nom
     * @param nom nom de l'usuari
     * @return usuari que busquem
     */
    public Usuari getUsuariByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    /**
     * Obtenir un usuari per nombre d'operari
     * @param numOperari num operari
     * @return usuari amb aquest nombre d'operari
     */
    public Usuari getUserByNumOperari(long numOperari) {
        return userRepository.findByNumOperari(numOperari);
    }

    /**
     * Esborrar un usuari
     * @param id id de l'usuari
     * @return retorna la llista de tots els usuaris
     */
    public String deleteUsuari(long id) {
        userRepository.deleteById(id);
        return "redirect:/users/all";
    }

    /**
     * Actualitzar un usuari
     * @param usuari omplit per actualitzar
     * @return guardar usuari actualitzat
     */
    public Usuari updateUsuari(Usuari usuari) {
        Usuari existingUsuari = userRepository.findById(usuari.getUserId()).orElse(null);
        existingUsuari.setNom(usuari.getNom());
        existingUsuari.setCognom1(usuari.getCognom1());
        existingUsuari.setCognom2(usuari.getCognom2());
        existingUsuari.setNumOperari(usuari.getNumOperari());
        existingUsuari.setActive(usuari.getActive());
        existingUsuari.setRol(usuari.getRol());
        existingUsuari.setPassword(bCryptPasswordEncoder.encode(usuari.getPassword()));
        return userRepository.save(existingUsuari);
    }

}
