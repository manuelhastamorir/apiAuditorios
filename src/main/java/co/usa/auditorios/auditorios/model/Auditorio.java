package co.usa.auditorios.auditorios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="auditorio")
public class Auditorio implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String owner;
    private String name;
    private Integer capacity;
    private String  description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({ "audience", "client" })
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({ "audience", "client" })
    private List<Reserva> reservations; 

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("audiences")
    private Categoria category;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
   
    public List<Mensaje> getMessages() {
        return messages;
    }
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    public Categoria getCategory() {
        return category;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }
    public List<Reserva> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    } 
    
    

    
    

}
