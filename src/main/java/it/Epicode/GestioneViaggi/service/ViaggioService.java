package it.Epicode.GestioneViaggi.service;

import it.Epicode.GestioneViaggi.dto.ViaggioDto;
import it.Epicode.GestioneViaggi.enumeration.StatoViaggio;
import it.Epicode.GestioneViaggi.exception.NonTrovatoException;
import it.Epicode.GestioneViaggi.model.Viaggio;
import it.Epicode.GestioneViaggi.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;


    public Viaggio saveViaggio(ViaggioDto viaggioDto){
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(viaggioDto.getDestinazione());
        viaggio.setData(viaggioDto.getData());
        return viaggioRepository.save(viaggio);


    }

    public List<Viaggio> getViaggi(){
        return viaggioRepository.findAll();
    }


    public Viaggio getViaggio(int id) throws NonTrovatoException {
        return viaggioRepository.findById(id).
                orElseThrow(()-> new NonTrovatoException("Viaggio non trovato"));
    }

    public Viaggio updateViaggio(int id, ViaggioDto viaggioDto) throws NonTrovatoException {

        Viaggio viaggio= getViaggio(id);
        viaggio.setDestinazione(viaggioDto.getDestinazione());
        viaggio.setData(viaggioDto.getData());
        return viaggioRepository.save(viaggio);

    }

    public void deleteViaggio(int id) throws NonTrovatoException {
        Viaggio viaggioX = getViaggio(id);
        viaggioRepository.delete(viaggioX);
    }

    public String patchViaggio(int id, String stato) throws NonTrovatoException {
        Viaggio viaggio = getViaggio(id);
        try {
            StatoViaggio nuovoStato = StatoViaggio.valueOf(stato.toUpperCase());
            viaggio.setStatoViaggio(nuovoStato);
            viaggioRepository.save(viaggio);
            return nuovoStato.name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Stato viaggio non valido");
        }
    }


}
