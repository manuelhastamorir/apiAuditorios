package co.usa.auditorios.auditorios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditorios.auditorios.model.Categoria;
import co.usa.auditorios.auditorios.repository.CategoriaRepositorio;

@Service
public class CategoriaServicio 
{
    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public List <Categoria> getAll()
    {
        return categoriaRepositorio.getAll();
    }

    public Optional <Categoria> getCategoria(int id)
    {
        return categoriaRepositorio.getCategoria(id);
    }

    public Categoria save (Categoria catego)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(catego.getId()==null)
        {
            return categoriaRepositorio.save(catego);
        }
        else 
        {
            Optional<Categoria> consulta = categoriaRepositorio.getCategoria(catego.getId());
            if (consulta.isEmpty()) 
            {
                return categoriaRepositorio.save(catego);   
            } 
            else 
            {
                return catego;    
            }
        } 

    }

}
