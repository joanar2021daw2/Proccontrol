package cat.xtec.ioc.Proccontrol.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * JPA retornarà un NOT FOUND status al client
 *
 * @author JoseAndrade
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundException(String message){
        super(message);
    }
    
}
