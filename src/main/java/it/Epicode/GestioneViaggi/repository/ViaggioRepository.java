package it.Epicode.GestioneViaggi.repository;

import it.Epicode.GestioneViaggi.model.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio,Integer> {
}
