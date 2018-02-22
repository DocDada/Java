package tp3_agenda;
import tp2_event.Evenement;
import tp4_except.ExceptionDate;
import tp1_date.Date ;

public class TestAgenda {

	public static void main(String[] args) {
		Agenda monAgenda = new Agenda(3) ;
		try {
		for (int i = 0 ; i < 2 ; i++) {
			if (!monAgenda.ajout(Evenement.lireEvenement()))
				System.out.println("Evénement non ajouté.") ;
		}
		
		int indice = monAgenda.getEvenement(Evenement.lireEvenement()) ;
		if (indice == -1)
			System.out.println("L'événement n'y est point.") ;
		else
			System.out.println("Evenement trouvé") ;
		System.out.println(monAgenda) ;
		//indice = monAgenda.rechercheMinimum(0, 1) ;
		//System.out.println(indice) ;
		monAgenda.triParInsertion() ;
		System.out.println(monAgenda) ;
		
		Date date = new Date() ;
		System.out.println(date) ;
		Date date2 = Date.lireDate();
		System.out.println(date2);
		}
		
		catch(ExceptionDate parExc) {
			System.out.println(parExc.getMessage());
		}
	}// main

}
