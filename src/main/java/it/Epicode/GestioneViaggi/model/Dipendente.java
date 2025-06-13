package it.Epicode.GestioneViaggi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

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
}
