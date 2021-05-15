package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Referencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */
public interface ReferenciaRepository extends  JpaRepository<Referencia, Long>{
    Referencia findByNom(String nom);
    List<Referencia> findByInstalacioIdInstalacio(long idInstalacio);
}
