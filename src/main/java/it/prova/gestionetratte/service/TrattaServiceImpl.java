package it.prova.gestionetratte.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.tratta.TrattaRepository;

@Service
public class TrattaServiceImpl implements TrattaService {

	@Autowired
	private TrattaRepository trattaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Tratta> listAllElements(boolean eager) {
		if (eager)
			return (List<Tratta>) trattaRepository.findAllTrattaEager();

		return (List<Tratta>) trattaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tratta caricaSingoloElemento(Long id) {
		return trattaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Tratta caricaSingoloElementoEager(Long id) {
		return trattaRepository.findSingleTrattaEager(id);
	}

	@Override
	@Transactional
	public Tratta aggiorna(Tratta trattaInstance) {
		return trattaRepository.save(trattaInstance);
	}

	@Override
	@Transactional
	public Tratta inserisciNuovo(Tratta trattaInstance) {
		return trattaRepository.save(trattaInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Tratta trattaInstance) {
		trattaRepository.delete(trattaInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tratta> findByExample(Tratta example) {
		return trattaRepository.findByExample(example);
	}

	@Override
	@Transactional
	public List<Tratta> cercaPerCodiceEDescrizione(String codice, String descrizione) {
		return trattaRepository.findByCodiceAndDescrizione(codice, descrizione);
	}

	@Override
	@Transactional
	public void concludiTratte() {
		trattaRepository.concludiTratte(LocalTime.now());
	}

}
