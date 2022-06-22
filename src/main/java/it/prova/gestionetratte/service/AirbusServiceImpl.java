package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;

@Service
public class AirbusServiceImpl implements AirbusService {

	@Autowired
	private AirbusRepository airbusRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Airbus> listAllElements() {
		return (List<Airbus>) airbusRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Airbus caricaSingoloElemento(Long id) {
		return airbusRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Airbus caricaSingoloElementoConTratte(Long id) {
		return airbusRepository.findByIdEager(id);
	}

	@Override
	@Transactional
	public Airbus aggiorna(Airbus airbusInstance) {
		return null;
	}

	@Override
	@Transactional
	public Airbus inserisciNuovo(Airbus airbusInstance) {
		return airbusRepository.save(airbusInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Airbus airbusInstance) {
	}

	@Override
	@Transactional(readOnly = true)
	public List<Airbus> findByExample(Airbus example) {
		return null;
	}

	@Override
	@Transactional
	public Airbus cercaPerCodiceEDescrizione(String codice, String descrizione) {
		return airbusRepository.findByCodiceAndDescrizione(codice, descrizione);
	}

	public List<Airbus> listAllElementsEager() {
		return (List<Airbus>) airbusRepository.findAllEager();
	}

}
