package it.prova.gestionetratte.repository.tratta;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionetratte.model.Tratta;

public interface TrattaRepository extends CrudRepository<Tratta, Long>, CustomTrattaRepository {

	List<Tratta> findByCodiceAndDescrizione(String codice, String descrizione);

	@Query("select t from Tratta t join fetch t.airbus")
	List<Tratta> findAllTrattaEager();

}
