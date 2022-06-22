package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.tratta.TrattaRepository;

@Service
public class TrattaServiceImpl implements TrattaService {

	@Autowired
	private TrattaRepository trattaRepository;

	public List<Tratta> listAllElements(boolean eager) {
		return null;
	}

	public Tratta caricaSingoloElemento(Long id) {
		return null;
	}

	public Tratta caricaSingoloElementoEager(Long id) {
		return null;
	}

	public Tratta aggiorna(Tratta trattaInstance) {
		return null;
	}

	public Tratta inserisciNuovo(Tratta trattaInstance) {
		return trattaRepository.save(trattaInstance);
	}

	public void rimuovi(Tratta trattaInstance) {
	}

	public List<Tratta> findByExample(Tratta example) {
		return null;
	}

	public List<Tratta> cercaPerCodiceEDescrizione(String codice, String descrizione) {
		return trattaRepository.findByCodiceAndDescrizione(codice, descrizione);
	}

}
