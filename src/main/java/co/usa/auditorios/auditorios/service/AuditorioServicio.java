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

}
