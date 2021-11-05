package co.usa.auditorios.auditorios.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.auditorios.auditorios.model.Cliente;
import co.usa.auditorios.auditorios.service.ClienteServicio;


@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ClienteControlador 
{
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Cliente>getClientes()
    {
        return clienteServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Cliente>getCliente(@PathVariable("id") int id)
    {
        return clienteServicio.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cli)
    {
        return clienteServicio.save(cli);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update (@RequestBody Cliente cli)
    {
        return clienteServicio.update(cli);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCliente (@PathVariable("id") int id)
    {
        return clienteServicio.deleteCliente(id);
    }
}

