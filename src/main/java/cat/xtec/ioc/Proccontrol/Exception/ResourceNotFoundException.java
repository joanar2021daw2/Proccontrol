package cat.xtec.ioc.Proccontrol.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de gestió de excepcions del api rest. JPA retornarà un NOT FOUND status al
 * client en cas de no trobar el recurs sol·licitat.
 *
 * @author JoseAndrade
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Mètode que retorna el missatge en cas d'excepció
     * @param message missatge a retornar
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
