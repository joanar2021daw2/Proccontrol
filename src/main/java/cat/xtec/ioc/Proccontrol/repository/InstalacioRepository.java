package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.Instalacio;
import cat.xtec.ioc.Proccontrol.domain.Seccio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Classe interfície d'instal·lació
 * @author JoseAndrade
 */
public interface InstalacioRepository extends JpaRepository<Instalacio, Long>{
    Instalacio findByNom(String nom);
    List<Instalacio> findBySeccioIdSeccio(long idSeccio);
}
