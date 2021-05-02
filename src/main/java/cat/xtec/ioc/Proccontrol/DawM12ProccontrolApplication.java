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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DawM12ProccontrolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Primer cop iniciada la aplicació es crea un usuari administrador 
        Usuari admin = null;
        admin = userRepository.findByNom("proccontrol");
        if (admin == null) {
            Set<Resultat> s = new HashSet<>();
            userRepository.save(new Usuari(0, 0, "proccontrol", "", "", "ADMIN", bCryptPasswordEncoder.encode("proccadmin"), true, s));
        }
    }



}
