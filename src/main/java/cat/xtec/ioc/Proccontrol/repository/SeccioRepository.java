package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Seccio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe interfície secció
 * @author JoseAndrade
 */
public interface SeccioRepository extends JpaRepository<Seccio, Long>{
    Seccio findByNom(String nom);
}
