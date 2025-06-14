package it.Epicode.GestioneViaggi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dipendente {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "dipendente")
    private List<Prenotazione> prenotazioni;

}
