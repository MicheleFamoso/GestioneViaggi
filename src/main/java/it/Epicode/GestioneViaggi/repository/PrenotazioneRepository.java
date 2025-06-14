package it.Epicode.GestioneViaggi.repository;

import it.Epicode.GestioneViaggi.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
}
