package it.Epicode.GestioneViaggi.repository;

import it.Epicode.GestioneViaggi.model.Dipendente;
import it.Epicode.GestioneViaggi.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {


    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
