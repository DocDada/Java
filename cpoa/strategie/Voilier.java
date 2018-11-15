package strategie;

public abstract class Voilier {

	protected String nom;
	protected SuivreRoute suivreRoute;

	public Voilier(String nom, SuivreRoute suivreRoute) {
		this.nom = nom;
		this.suivreRoute = suivreRoute;
	}

	public Voilier() {

	}

	public String toString() {
		return nom;
	}

	public void setSuivreRoute(SuivreRoute suivreRoute) {
		this.suivreRoute = suivreRoute;
	}

	public void appliqueSuivreRoute() {
		if (suivreRoute != null)
			suivreRoute.suivreRoute();
		else
			this.get().suivreRoute.suivreRoute();
	}
	public Voilier get(){
		return this;
	}
}
