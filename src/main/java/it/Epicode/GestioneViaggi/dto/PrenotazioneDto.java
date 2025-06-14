package it.Epicode.GestioneViaggi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PrenotazioneDto {
    @NotNull( message = "Data richiesta!")
    private LocalDate dataRichiesta;
    private String preferenze;

    @Min(1)
    private int dipendenteId;
    @Min(1)
    private int viaggioId;


}
