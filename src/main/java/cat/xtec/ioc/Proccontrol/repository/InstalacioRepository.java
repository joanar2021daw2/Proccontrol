package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author JoseAndrade
 */
public interface InstalacioRepository extends JpaRepository<Instalacio, Long>{
    Instalacio findByNom(String nom);
}
