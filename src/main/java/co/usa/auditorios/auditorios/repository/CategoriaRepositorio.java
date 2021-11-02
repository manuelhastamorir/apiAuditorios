package co.usa.auditorios.auditorios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditorios.auditorios.model.Categoria;
import co.usa.auditorios.auditorios.repository.crud.CategoriaCrudRepositorio;

@Repository
public class CategoriaRepositorio 
{
    @Autowired
    CategoriaCrudRepositorio categoriaCrudRepositorio;
    
    public List<Categoria>getAll()
    {
        return (List<Categoria>)categoriaCrudRepositorio.findAll();
    }

    public Optional <Categoria> getCategoria(int id)
    {
        return categoriaCrudRepositorio.findById(id);
    }

    public Categoria save (Categoria catego)
    {
        return categoriaCrudRepositorio.save(catego);
    }


}
