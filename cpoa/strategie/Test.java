package strategie;

public class Test {

	public static void main(String[] args) {
		Voilier a = new Monocoque("A", new Alizes());
		// Voilier b = new Multicoque("B", new Orthodromie());
		a = new Foils(a);
		System.out.println(a.toString());
		a = new Foils(a);
		System.out.println(a.toString());

		a.appliqueSuivreRoute();
		a = new Winchs(a);
		System.out.println(a.toString());
		a.appliqueSuivreRoute();
		a.setSuivreRoute(new Orthodromie());
		a.appliqueSuivreRoute();
	}

}
