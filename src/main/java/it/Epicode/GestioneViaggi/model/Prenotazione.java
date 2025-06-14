package it.Epicode.GestioneViaggi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate dataRichiesta;
    private String preferenze;

   @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

   @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

}
