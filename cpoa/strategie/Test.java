package strategie;

public class Test {

	public static void main(String[] args) {
		Voilier a = new Monocoque("A", new Alizes());
		Voilier b = new Multicoque("B", new Orthodromie());
		
		a.appliqueSuivreRoute();
		a.setSuivreRoute(new Orthodromie());
		a.appliqueSuivreRoute();
	}

}
