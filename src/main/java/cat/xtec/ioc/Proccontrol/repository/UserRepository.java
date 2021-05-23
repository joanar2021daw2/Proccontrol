package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfície del repositori de l'usuari
 *
 * @author JoseAndrade
 */
public interface UserRepository extends JpaRepository<Usuari, Long> {

    Usuari findByUserId(long userId);

    Usuari findByNom(String nom);

    Usuari findByNumOperari(long numOperari);
}
