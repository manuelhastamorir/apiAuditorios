package co.usa.auditorios.auditorios.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name= "mensaje")
public class Mensaje 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Cliente client;

    
    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
    public Auditorio getAudience() {
        return audience;
    }
    public void setAudience(Auditorio audience) {
        this.audience = audience;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }
    
    
    
}
