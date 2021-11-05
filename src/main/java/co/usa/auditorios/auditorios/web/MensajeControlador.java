package co.usa.auditorios.auditorios.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import co.usa.auditorios.auditorios.model.Mensaje;
import co.usa.auditorios.auditorios.service.MensajeServicio;


@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MensajeControlador 
{
    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje>getMensajes()
    {
        return mensajeServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje>getMensaje(@PathVariable("id") int id)
    {
        return mensajeServicio.getmensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje msj)
    {
        return mensajeServicio.save(msj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update (@RequestBody Mensaje msj)
    {
        return mensajeServicio.update(msj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMensaje (@PathVariable("id") int id)
    {
        return mensajeServicio.deleteMensaje(id);
    }
}
