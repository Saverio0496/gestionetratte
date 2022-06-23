package it.prova.gestionetratte.repository.airbus;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionetratte.model.Airbus;

public interface AirbusRepository extends CrudRepository<Airbus, Long>, CustomAirbusRepository {

	Airbus findByCodiceAndDescrizione(String codice, String descrizione);

	@Query("select distinct a from Airbus a left join fetch a.tratte ")
	List<Airbus> findAllEager();

	@Query("from Airbus a left join fetch a.tratte where a.id=?1")
	Airbus findByIdEager(Long idAirbus);

	@Query(value = "select distinct a.* from Tratta t1, Tratta t2, Airbus a where t1.airbus_id = a.id and t1.airbus_id = t2.airbus_id and t1.id <> t2.id and ((t1.oraatterraggio between t2.oradecollo and t2.oraatterraggio) or (t1.oradecollo between t2.oradecollo and t2.oraatterraggio));", nativeQuery = true)
	List<Airbus> findAllWithSovrapposizione();
	
}

