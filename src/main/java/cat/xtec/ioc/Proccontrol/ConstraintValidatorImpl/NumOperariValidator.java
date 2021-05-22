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

    @Override
    public void initialize(NotExistingNumOperari constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long numOperari, ConstraintValidatorContext cvc) {                
        return numOperari != null && !userService.existeixNumOperari(numOperari);
    }

}
