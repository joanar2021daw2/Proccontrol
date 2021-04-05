package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */
public interface ReferenciaRepository extends  JpaRepository<Referencia, Long>{
    Referencia findByNom(String nom);
    
}
