package cat.xtec.ioc.Proccontrol.ConstraintValidator;

import cat.xtec.ioc.Proccontrol.ConstraintValidatorImpl.NumOperariValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Interfície de l'anotació personalitzada que comprova que el
 * número d'operari introduït al formulari no existeix
 *
 * @author JoseAndrade
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumOperariValidator.class)
@Documented
public @interface NotExistingNumOperari {

    String message() default "El número d'operari ja existeix al sistema";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
