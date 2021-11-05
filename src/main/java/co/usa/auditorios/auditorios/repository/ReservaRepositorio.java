package co.usa.auditorios.auditorios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditorios.auditorios.model.Reserva;
import co.usa.auditorios.auditorios.repository.crud.ReservaCrudRepositorio;

@Repository
public class ReservaRepositorio 
{
    @Autowired
    ReservaCrudRepositorio reservaCrudRepositorio;

    public List<Reserva>getAll()
    {
        return (List<Reserva>)reservaCrudRepositorio.findAll();
    }

    public Optional<Reserva>getReserva(int id)
    {
        return reservaCrudRepositorio.findById(id);
    }

    public Reserva save (Reserva res)
    {
        return reservaCrudRepositorio.save(res);
    }

    public void delete (Reserva res)
    {
        reservaCrudRepositorio.delete(res);
    }

}
