package strategie;

public class Monocoque extends Voilier {

	public Monocoque(String nomVoilier, SuivreRoute suivreRoute) {
		super(nomVoilier, suivreRoute);
	}

	public String toString() {
		return "Monocoque : " + this.nom;
	}
}
