package co.usa.auditorios.auditorios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Auditorio;
import co.usa.auditorios.auditorios.repository.AuditorioRepositorio;

@Service
public class AuditorioServicio 
{
    @Autowired
    AuditorioRepositorio auditorioRepositorio;

    public List <Auditorio> getAll()
    {
        return auditorioRepositorio.getAll();
    }
    public Optional <Auditorio> getAuditorio (int id)
    {
        return auditorioRepositorio.getAuditorio(id);
    }
    public Auditorio save (Auditorio audi)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(audi.getId()==null)
        {
            return auditorioRepositorio.save(audi);
        }
        else 
        {
            Optional<Auditorio> consulta = auditorioRepositorio.getAuditorio(audi.getId());
            if (consulta.isEmpty()) 
            {
                return auditorioRepositorio.save(audi);   
            } 
            else 
            {
                return audi;    
            }
        }
    }
    public Auditorio update (Auditorio audi)
    {
        if(audi.getId()!=null)
        {
            Optional<Auditorio> consulta = auditorioRepositorio.getAuditorio(audi.getId());
            if (!consulta.isEmpty()) 
            {
                if (audi.getName()!=null) 
                {
                    consulta.get().setName(audi.getName());    
                }
                if (audi.getOwner()!=null)
                {
                    consulta.get().setOwner(audi.getOwner());   
                }
                if (audi.getCapacity()!=null) 
                {
                    consulta.get().setCapacity(audi.getCapacity());
                }
                if (audi.getDescription()!=null)
                {
                    consulta.get().setDescription(audi.getDescription());    
                }   
                return auditorioRepositorio.save(consulta.get());
            }
        }
        return audi;
    }

    public boolean deleteAuditorio(int id)
    {
        Optional<Auditorio> consulta = auditorioRepositorio.getAuditorio(id);
        if (!consulta.isEmpty()) 
        {
            auditorioRepositorio.delete(consulta.get());
            return true;    
        }
        return false;
    }
}
