package decorateur;

import strategie.Voilier;

public class Winchs extends ArmementSupplementaire {

	public Winchs(Voilier voilierDecore) {
		super(voilierDecore);
	}

	public String toString() {
		return super.toString() + " avec Winchs";
	}
}
