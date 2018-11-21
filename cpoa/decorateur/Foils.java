package decorateur;

import strategie.Voilier;

public class Foils extends ArmementSupplementaire {

	public Foils(Voilier voilierDecore) {
		super(voilierDecore);
	}

	public String toString() {
		return super.toString() + " avec Foils";
	}
	
}
