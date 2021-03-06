package co.usa.auditorios.auditorios.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Auditorio> audiences;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Auditorio> getAudiences() {
        return audiences;
    }
    public void setAudiences(List<Auditorio> audiences) {
        this.audiences = audiences;
    } 
    
   
   
   
    
    
}
