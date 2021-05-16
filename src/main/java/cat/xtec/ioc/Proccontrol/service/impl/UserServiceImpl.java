package cat.xtec.ioc.Proccontrol.service.impl;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuari saveUsuari(Usuari usuari) {
        usuari.setPassword(bCryptPasswordEncoder.encode(usuari.getPassword()));
        return userRepository.save(usuari);
    }

    public List<Usuari> getAllUsuaris() {
        return userRepository.findAll();
    }

    public Usuari getUsuariById(long id) {
        return userRepository.findByUserId(id);
    }

    public Usuari getUsuariByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    public Usuari getUserByNumOperari(long numOperari) {
        return userRepository.findByNumOperari(numOperari);
    }

    public String deleteUsuari(long id) {
        userRepository.deleteById(id);
        return "redirect:/users/all";
    }

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
