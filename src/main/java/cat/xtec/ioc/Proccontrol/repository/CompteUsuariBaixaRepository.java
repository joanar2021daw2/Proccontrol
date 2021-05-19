package cat.xtec.ioc.Proccontrol.repository;

import cat.xtec.ioc.Proccontrol.domain.CompteUsuariBaixa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JoseAndrade
 */
public interface CompteUsuariBaixaRepository extends JpaRepository<CompteUsuariBaixa, Long> {

    CompteUsuariBaixa findByidCompteUsuariBaixa(long userId);

    CompteUsuariBaixa findByNom(String nom);

    CompteUsuariBaixa findByNumOperari(long numOperari);

}
