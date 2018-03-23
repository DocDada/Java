package modele;

public class Heure {
	private int heures ;
	private int minutes ;
	
	public Heure() {
		heures = 0;
		minutes = 0 ;
	}
	
	public Heure(int parH, int parM) {
		heures = parH;
		minutes = parM ;
	}

	public int getHeures() {
		return heures;
	}

	public void setHeures(int heures) {
		this.heures = heures;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
