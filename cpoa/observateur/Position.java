package observateur;

import java.util.GregorianCalendar;

public class Position {

	private String nom;
	private String skipper;
	private double distance;
	private GregorianCalendar dateEtHeure;
	private boolean abandon;

	public Position(String nom, String skipper, double distance,
			GregorianCalendar dateEtHeure, boolean abandon) {
		this.nom = nom;
		this.skipper = skipper;
		this.distance = distance;
		this.dateEtHeure = dateEtHeure;
		this.abandon = abandon;
	}

}
