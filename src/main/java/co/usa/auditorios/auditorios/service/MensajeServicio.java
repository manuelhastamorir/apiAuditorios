package co.usa.auditorios.auditorios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Mensaje;
import co.usa.auditorios.auditorios.repository.MensajeRepositorio;

@Service 
public class MensajeServicio 
{
    @Autowired
    MensajeRepositorio mensajeRepositorio;
    
    public List <Mensaje>getAll()
    {
        return mensajeRepositorio.getAll();
    }

    public Optional <Mensaje>getmensaje(int id)
    {
        return mensajeRepositorio.getMensaje(id);
    }

    public Mensaje save(Mensaje msj)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(msj.getIdMessage()==null)
        {
            return mensajeRepositorio.save(msj);
        }
        else 
        {
            Optional<Mensaje> consulta = mensajeRepositorio.getMensaje(msj.getIdMessage());
            if (consulta.isEmpty()) 
            {
                return mensajeRepositorio.save(msj);   
            } 
            else 
            {
                return msj;    
            }
        }
    }

    public Mensaje update (Mensaje msj)
    {
        if(msj.getIdMessage()!=null)
        {
            Optional<Mensaje> consulta = mensajeRepositorio.getMensaje(msj.getIdMessage());
            if (!consulta.isEmpty()) 
            {
                if (msj.getMessageText()!=null) 
                {
                    consulta.get().setMessageText(msj.getMessageText());    
                }
                return mensajeRepositorio.save(consulta.get());   
            }
        }
        return msj;
    }

    public boolean deleteMensaje (int id)
    {
        Optional<Mensaje> consulta = mensajeRepositorio.getMensaje(id);
        if (!consulta.isEmpty()) 
        {
            mensajeRepositorio.delete(consulta.get());   
            return true; 
        }        
        return false;
    }
}
