package co.usa.auditorios.auditorios.repository.crud;
import org.springframework.data.repository.CrudRepository;

import co.usa.auditorios.auditorios.model.Mensaje;

public interface MensajeCrudRepositorio  extends CrudRepository <Mensaje,Integer>
{
    
}
