package cat.xtec.ioc.Proccontrol.config;

/**
 * Classe Utilitzada per Spring security per tal de autenticar els usuaris.
 * Es crida l'usuari pel nom i es comprova el seu rol.
 * 
 * @author JoseAndrade
 * @version 1.0
 * @since 1.0
 */
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Servei d'usuari
     */    
    @Autowired
    private UserRepository userRepository;

    /**
     * Mètode que retorna els detalls de l'usuari a loguejar
     * @param nom nom de l'usuari a autenticar
     * @return objecte User de Spring Security amb els detalls de l'usuari
     * @throws UsernameNotFoundException si no es troba l'usuari
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        Usuari user = userRepository.findByNom(nom);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRol()));

        return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(),
                grantedAuthorities);

    }
}
