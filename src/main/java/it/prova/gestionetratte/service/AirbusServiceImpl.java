package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;

@Service
public class AirbusServiceImpl implements AirbusService {

	@Autowired
	private AirbusRepository airbusRepository;

	public List<Airbus> listAllElements() {
		return null;
	}

	public List<Airbus> listAllElementsEager() {
		return null;
	}

	public Airbus caricaSingoloElemento(Long id) {
		return null;
	}

	public Airbus caricaSingoloElementoConTratte(Long id) {
		return null;
	}

	public Airbus aggiorna(Airbus airbusInstance) {
		return null;
	}

	public Airbus inserisciNuovo(Airbus airbusInstance) {
		return airbusRepository.save(airbusInstance);
	}

	public void rimuovi(Airbus airbusInstance) {
	}

	public List<Airbus> findByExample(Airbus example) {
		return null;
	}

	public Airbus cercaPerCodiceEDescrizione(String codice, String descrizione) {
		return airbusRepository.findByCodiceAndDescrizione(codice, descrizione);
	}

}
