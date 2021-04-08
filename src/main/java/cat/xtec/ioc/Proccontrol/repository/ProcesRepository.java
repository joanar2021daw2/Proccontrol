package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Proces;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */
public interface ProcesRepository extends  JpaRepository<Proces, Long>{
        Proces findByNom(String nom);

}
