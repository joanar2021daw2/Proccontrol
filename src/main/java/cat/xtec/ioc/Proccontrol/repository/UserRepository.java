package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */

public interface UserRepository extends JpaRepository<Usuari, Long> {

    Usuari findByNom(String nom);

    Usuari findByNumOperari(long numOperari);
}
