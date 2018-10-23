package strategie;

public class Multicoque extends Voilier {
	public Multicoque(String nomVoilier, SuivreRoute suivreRoute) {
		super(nomVoilier, suivreRoute);
	}

	public String toString() {
		return "Multicoque : " + this.nom;
	}
}
