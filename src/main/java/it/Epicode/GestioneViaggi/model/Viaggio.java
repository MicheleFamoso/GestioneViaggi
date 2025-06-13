package it.Epicode.GestioneViaggi.model;

import it.Epicode.GestioneViaggi.enumeration.StatoViaggio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Viaggio {
    @Id
    @GeneratedValue
    private int id;
    private String destinazione ;
    private LocalDate data;
    private StatoViaggio statoViaggio;

}
