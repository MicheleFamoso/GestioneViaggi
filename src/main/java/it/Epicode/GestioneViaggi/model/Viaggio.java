package it.Epicode.GestioneViaggi.model;

import it.Epicode.GestioneViaggi.enumeration.StatoViaggio;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Viaggio {
    @Id
    @GeneratedValue
    private int id;
    private String destinazione ;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    @OneToMany(mappedBy = "viaggio")
    private List<Prenotazione> prenotazioni;


}
