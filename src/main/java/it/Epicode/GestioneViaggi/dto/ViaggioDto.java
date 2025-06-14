package it.Epicode.GestioneViaggi.dto;


import it.Epicode.GestioneViaggi.enumeration.StatoViaggio;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Data
public class ViaggioDto {

    @NotEmpty(message = "La destinazione non puo essere vuota")
    private String destinazione;
    @NotNull(message = "La data non puo essere nulla ")
    private LocalDate data;
    private StatoViaggio statoViaggio;

}
