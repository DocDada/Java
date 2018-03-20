package modele;

public class TestModele {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalendrierDuMois cal ;
		for (int i = 3 ; i<6 ; i++) {
			cal = new CalendrierDuMois(i, 2018);
			/*System.out.print(Date.getChMoisString(i)+" "+cal.getDates().size()+" dates : ");
			System.out.println(cal.getDates().toString());*/
			System.out.println(cal);
		}
		
	}

}