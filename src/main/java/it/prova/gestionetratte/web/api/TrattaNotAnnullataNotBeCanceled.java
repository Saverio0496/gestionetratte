package it.prova.gestionetratte.web.api;

public class TrattaNotAnnullataNotBeCanceled extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TrattaNotAnnullataNotBeCanceled(String message) {
		super(message);
	}

}
