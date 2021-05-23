package cat.xtec.ioc.Proccontrol;

import cat.xtec.ioc.Proccontrol.domain.Resultat;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DawM12ProccontrolApplication implements CommandLineRunner {

    /**
     * Encripta la contrasenya
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Repositori d'usuari
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Inicia l'applicació
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DawM12ProccontrolApplication.class, args);
    }

    /**
     * Mètode run del CommandLineRunner. Creém un usuari administrador el primer
     * cop que s'inicía l'aplicació per tal que es pugui començar a treballar.
     *
     * @param args arguments
     * @throws java.lang.Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Usuari admin = null;
        admin = userRepository.findByNom("proccontrol");
        if (admin == null) {
            Set<Resultat> s = new HashSet<>();
            userRepository.save(new Usuari(0, 0, "proccontrol", "", "", "ADMIN", bCryptPasswordEncoder.encode("proccadmin"), true, s));
        }
    }

}
