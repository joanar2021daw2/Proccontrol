package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Resultat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat> findByProcesIdProces(long idProces);
    List<Resultat> findByUsuariUserId(long userId);
}
