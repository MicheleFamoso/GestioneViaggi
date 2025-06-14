package it.Epicode.GestioneViaggi.service;


import it.Epicode.GestioneViaggi.dto.PrenotazioneDto;
import it.Epicode.GestioneViaggi.exception.NonTrovatoException;
import it.Epicode.GestioneViaggi.model.Dipendente;
import it.Epicode.GestioneViaggi.model.Prenotazione;
import it.Epicode.GestioneViaggi.model.Viaggio;
import it.Epicode.GestioneViaggi.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Autowired
    DipendenteService dipendenteService;

    @Autowired
    ViaggioService viaggioService;

    public Prenotazione savePrenotazione(PrenotazioneDto prenotazioneDto) throws NonTrovatoException {
        Dipendente dipendente = dipendenteService.getDipendente(prenotazioneDto.getDipendenteId());
        Viaggio viaggio = viaggioService.getViaggio(prenotazioneDto.getViaggioId());

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataRichiesta(prenotazioneDto.getDataRichiesta());
        prenotazione.setPreferenze(prenotazioneDto.getPreferenze());
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        boolean exists = prenotazioneRepository.existsByDipendenteAndDataRichiesta(dipendente, prenotazioneDto.getDataRichiesta());
        if (exists) {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per questo giorno.");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getPrenotazioni(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazione(int id) throws NonTrovatoException {
        return prenotazioneRepository.findById(id).
                orElseThrow(()->new NonTrovatoException("Prenotazione non trovata"));
    }

    public Prenotazione updatePrenotazione(int id, PrenotazioneDto prenotazioneDto) throws NonTrovatoException {
        Prenotazione prenotazione = getPrenotazione(id);
        prenotazione.setDataRichiesta(prenotazioneDto.getDataRichiesta());
        prenotazione.setPreferenze(prenotazioneDto.getPreferenze());

        if (prenotazioneDto.getDipendenteId()!= prenotazione.getDipendente().getId()){
            Dipendente dipendente = dipendenteService.getDipendente(prenotazioneDto.getDipendenteId());
            prenotazione.setDipendente(dipendente);
        }
        if (prenotazioneDto.getViaggioId()!= prenotazione.getViaggio().getId()){
            Viaggio viaggio = viaggioService.getViaggio(prenotazioneDto.getViaggioId());
            prenotazione.setViaggio(viaggio);
        }
        boolean exists = prenotazioneRepository.existsByDipendenteAndDataRichiesta(prenotazione.getDipendente(), prenotazioneDto.getDataRichiesta());
        if (exists && !prenotazione.getDataRichiesta().equals(prenotazioneDto.getDataRichiesta())) {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per questo giorno.");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(int id) throws NonTrovatoException {
        Prenotazione prenotazioneX = getPrenotazione(id);

        prenotazioneRepository.delete(prenotazioneX);
    }

}


