package cat.xtec.ioc.Proccontrol.ConstraintValidatorImpl;

import cat.xtec.ioc.Proccontrol.ConstraintValidator.NotExistingNumOperari;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe d'implementació de la interfície NotExistingNumOperari
 *
 * @author JoseAndrade
 */
@Component
public class NumOperariValidator implements ConstraintValidator<NotExistingNumOperari, Long> {

    /**
     * Servei usuari
     */
    @Autowired
    UserServiceImpl userService;

    /**
     * Mètode que permet inicialitzar o preparar dades per la validació
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(NotExistingNumOperari constraintAnnotation) {
    }

    /**
     * Mètode que s'executa per comprovar si l'entrada de l'usuari es vàlida
     *
     * @param numOperari número d'operari del formulari usuaris
     * @param cvc
     * @return booleana true = ja existeix numOperari, false = està lliure 
     */
    @Override
    public boolean isValid(Long numOperari, ConstraintValidatorContext cvc) {
        return numOperari != null && !userService.existeixNumOperari(numOperari);
    }

}
