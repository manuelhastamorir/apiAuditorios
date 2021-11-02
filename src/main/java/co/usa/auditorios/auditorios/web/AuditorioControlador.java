package co.usa.auditorios.auditorios.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.auditorios.auditorios.model.Auditorio;
import co.usa.auditorios.auditorios.service.AuditorioServicio;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class AuditorioControlador 
{
    @Autowired
    private AuditorioServicio auditorioServicio;
    
    @GetMapping("/all")
    public List<Auditorio>getAuditorios()
    {
        return auditorioServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Auditorio> getAuditorio(@PathVariable("id") int id)
    {
        return auditorioServicio.getAuditorio(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save (@RequestBody Auditorio audi)
    {
        return auditorioServicio.save(audi);
    }

}
