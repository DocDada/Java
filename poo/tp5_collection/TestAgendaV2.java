package tp5_collection;
import tp1_date.Date;
import tp2_event.Evenement;
import tp4_except.ExceptionDate;

public class TestAgendaV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AgendaV2 agd = new AgendaV2();
			agd.ajout(new Evenement(new Date(2,1,1999), "Titre", "Lieu"));
			// System.err.println(getMessage()) ;
			// Question 3
			System.out.println("Nombre de fois où il y le mot exposé dans le titre : "+agd.nbExpose());
			// Question 4
			System.out.println("Nombre de fois où la date correspond : "+agd.nbEvtEnregistre(new Date(2,1,1999)));
			// Question 7
			System.out.println(agd.toString());
		}
		
		catch(ExceptionDate parExc) {
			System.out.println(parExc.getMessage());
		}

	}// main

}
