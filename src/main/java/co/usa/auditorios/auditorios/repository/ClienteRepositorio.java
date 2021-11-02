package co.usa.auditorios.auditorios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditorios.auditorios.model.Cliente;
import co.usa.auditorios.auditorios.repository.crud.ClienteCrudRepositorio;

@Repository
public class ClienteRepositorio 
{
    @Autowired
    ClienteCrudRepositorio clienteCrudRepositorio;

    public List <Cliente>getAll()
    {
        return (List<Cliente>)clienteCrudRepositorio.findAll();
    }

    public Optional <Cliente>getCliente(int id)
    {
        return clienteCrudRepositorio.findById(id);
    }

    public Cliente save (Cliente cli)
    {
        return clienteCrudRepositorio.save(cli);
    }
    
}
