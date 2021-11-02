package co.usa.auditorios.auditorios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Reserva;
import co.usa.auditorios.auditorios.repository.ReservaRepositorio;

@Service
public class ReservaServicio 
{
    @Autowired
    ReservaRepositorio reservaRepositorio;
    
    public List <Reserva>getAll()
    {
        return reservaRepositorio.getAll();
    }

    public Optional <Reserva>getReserva(int id)
    {
        return reservaRepositorio.getReserva(id);
    }

    public Reserva save(Reserva res)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(res.getIdReservation()==null)
        {
            return reservaRepositorio.save(res);
        }
        else 
        {
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
