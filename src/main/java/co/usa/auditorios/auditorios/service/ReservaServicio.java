package co.usa.auditorios.auditorios.service;
/*=== Librerias===*/ 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Reserva;
import co.usa.auditorios.auditorios.repository.ReservaRepositorio;

/*inicio clase Reserva Servicio*/
@Service
public class ReservaServicio 
{
    @Autowired
    ReservaRepositorio reservaRepositorio;
    
    /*Funcion que nos trae una lista de Objetos Reserva con los Json de la base de datos*/
    public List <Reserva>getAll()
    {
        return reservaRepositorio.getAll();
    }
    /*Funcion que nos trae un Objeto Reserva con los Json de la base de datos*/
    public Optional <Reserva>getReserva(int id)
    {
        return reservaRepositorio.getReserva(id);
    }
    /*Funcion que nos guarda los datos en la base de datos*/
    public Reserva save(Reserva res)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(res.getIdReservation()==null)
        {
            return reservaRepositorio.save(res);
        }
        else 
        {
            //Verificar si el objeto esta en la base de datos.
            Optional<Reserva> consulta = reservaRepositorio.getReserva(res.getIdReservation());
            if (consulta.isEmpty()) 
            {
                return reservaRepositorio.save(res);   
            } 
            else 
            {
                return res;    
            }
        }
    }

    
}
