package strategie;

public class Test {

	public static void main(String[] args) {
		Voilier a = Monocoque("A", new Alizes());
		Voilier b = Monocoque("B", new Orthodromie());
	}

}
