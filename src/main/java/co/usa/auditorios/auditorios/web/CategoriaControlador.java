package co.usa.auditorios.auditorios.web;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.usa.auditorios.auditorios.model.Categoria;
import co.usa.auditorios.auditorios.service.CategoriaServicio;


@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CategoriaControlador 
{
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    public List<Categoria>getCategorias()
    {
        return categoriaServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Categoria>getCategoria(@PathVariable("id") int id)
    {
        return categoriaServicio.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria catego)
    {
        return categoriaServicio.save(catego);
    }

        
}
