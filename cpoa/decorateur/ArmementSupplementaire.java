package decorateur;

import strategie.SuivreRoute;
import strategie.Voilier;

public abstract class ArmementSupplementaire extends Voilier {

	private Voilier voilierDecore;

	public ArmementSupplementaire(Voilier voilierDecore) {
		this.voilierDecore = voilierDecore;
	}

	public void appliqueSuivreRoute() {
		voilierDecore.appliqueSuivreRoute();
	}

	public void setSuivreRoute(SuivreRoute suivreRoute) {
		voilierDecore.setSuivreRoute(suivreRoute);
	}

	public String toString() {
		return voilierDecore.toString();
	}

}
