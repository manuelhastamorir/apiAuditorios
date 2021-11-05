package co.usa.auditorios.auditorios.web;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.usa.auditorios.auditorios.model.Reserva;
import co.usa.auditorios.auditorios.service.ReservaServicio;

@RestController
@RequestMapping("/api/Reservation")
public class ReservaControlador 
{
    @Autowired
    private ReservaServicio reservaServicio;
    @GetMapping("/all")
    public List<Reserva>getReservas()
    {
        return reservaServicio.getAll();
    }

    @GetMapping("/{id}")

    public Optional <Reserva>getReserva(@PathVariable("id") int id)
    {
        return reservaServicio.getReserva(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva res)
    {
        res.setStatus("created");
        return reservaServicio.save(res);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update (@RequestBody Reserva res)
    {
        res.setStatus("modificado");
        return reservaServicio.update(res);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReserva (@PathVariable("id") int id)
    {
        return reservaServicio.deleteReserva(id);
    }
}
