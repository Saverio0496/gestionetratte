package it.prova.gestionetratte;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.Stato;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.AirbusService;
import it.prova.gestionetratte.service.TrattaService;

@SpringBootApplication
public class GestionetratteApplication implements CommandLineRunner {

	@Autowired
	private AirbusService airbusService;

	@Autowired
	private TrattaService trattaService;

	public static void main(String[] args) {
		SpringApplication.run(GestionetratteApplication.class, args);
	}

	public void run(String... args) throws Exception {

		String codiceAirbus1 = "H67K984";
		String descrizioneAirbus1 = "A380";
		Airbus airbus1 = airbusService.cercaPerCodiceEDescrizione(codiceAirbus1, descrizioneAirbus1);

		if (airbus1 == null) {
			airbus1 = new Airbus(codiceAirbus1, descrizioneAirbus1, LocalDate.of(2000, 10, 9), 300);
			airbusService.inserisciNuovo(airbus1);
		}

		Tratta milanoTorino = new Tratta("KO9756R", "Milano-Torino", LocalDate.of(2021, 4, 23), LocalTime.of(17, 15),
				LocalTime.of(19, 30), Stato.ATTIVA, airbus1);
		if (trattaService.cercaPerCodiceEDescrizione(milanoTorino.getCodice(), milanoTorino.getDescrizione()).isEmpty())
			trattaService.inserisciNuovo(milanoTorino);

		String codiceAirbus2 = "F67I934";
		String descrizioneAirbus2 = "B900";
		Airbus airbus2 = airbusService.cercaPerCodiceEDescrizione(codiceAirbus2, descrizioneAirbus2);

		if (airbus2 == null) {
			airbus2 = new Airbus(codiceAirbus2, descrizioneAirbus2, LocalDate.of(2011, 2, 13), 1000);
			airbusService.inserisciNuovo(airbus2);
		}

		Tratta romaGenova = new Tratta("L90P56R", "Roma-Genova", LocalDate.of(2022, 7, 19), LocalTime.of(10, 20),
				LocalTime.of(12, 10), Stato.ATTIVA, airbus2);
		if (trattaService.cercaPerCodiceEDescrizione(romaGenova.getCodice(), romaGenova.getDescrizione()).isEmpty())
			trattaService.inserisciNuovo(romaGenova);
	}

}
