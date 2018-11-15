package strategie;

public abstract class ArmementSupplementaire extends Voilier {

	private Voilier voilierDecore;

	public ArmementSupplementaire(Voilier voilierDecore) {
		this.voilierDecore = voilierDecore;
	}

	public void appliqueSuivreRoute() {
		getVoilier().appliqueSuivreRoute();
	}

	public void setSuivreRoute(SuivreRoute suivreRoute) {
		getVoilier().setSuivreRoute(suivreRoute);
	}

	public String toString() {
		return voilierDecore.toString();
	}

	public Voilier getVoilier() {
		return voilierDecore;
	}

}
