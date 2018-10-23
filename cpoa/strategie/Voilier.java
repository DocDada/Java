package strategie;

public abstract class Voilier {

	protected String nom;
	protected SuivreRoute suivreRoute;

	public String toString() {
		return nom;
	}

	public void setSuivreRoute(SuivreRoute suivreRoute) {
		this.suivreRoute = suivreRoute;
	}

	public void appliqueSuivreRoute() {
		suivreRoute.suivreRoute();
	}
}
