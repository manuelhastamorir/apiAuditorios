package co.usa.auditorios.auditorios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditorios.auditorios.model.Mensaje;
import co.usa.auditorios.auditorios.repository.crud.MensajeCrudRepositorio;


@Repository
public class MensajeRepositorio 
{
    @Autowired
    MensajeCrudRepositorio mensajeCrudRepositorio;

    public List<Mensaje>getAll()
    {
        return (List<Mensaje>)mensajeCrudRepositorio.findAll();
    }
    public Optional <Mensaje>getMensaje(int id)
    {
        return mensajeCrudRepositorio.findById(id);
    }

    public Mensaje save (Mensaje msj)
    {
        return mensajeCrudRepositorio.save(msj);
    }

    public void delete (Mensaje msj)
    {
        mensajeCrudRepositorio.delete(msj);
    }
}
