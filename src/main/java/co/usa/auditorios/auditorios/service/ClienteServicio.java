package co.usa.auditorios.auditorios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Cliente;
import co.usa.auditorios.auditorios.repository.ClienteRepositorio;

@Service
public class ClienteServicio 
{
    @Autowired
    ClienteRepositorio clienteRepositorio;
    
    public List <Cliente>getAll()
    {
        return clienteRepositorio.getAll();
    }

    public Optional <Cliente>getCliente(int id)
    {
        return clienteRepositorio.getCliente(id);
    }

    public Cliente save(Cliente cli)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(cli.getIdClient()==null)
        {
            return clienteRepositorio.save(cli);
        }
        else 
        {
            Optional<Cliente> consulta = clienteRepositorio.getCliente(cli.getIdClient());
            if (consulta.isEmpty()) 
            {
                return clienteRepositorio.save(cli);   
            } 
            else 
            {
                return cli;    
            }
        }

    } 
}
