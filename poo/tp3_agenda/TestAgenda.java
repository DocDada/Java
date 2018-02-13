package paquet.tp3_agenda;
import paquet.tp2_event.Evenement;

public class TestAgenda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agenda monAgenda = new Agenda(3) ;
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
		indice = monAgenda.rechercheMinimum(0, 1) ;
		System.out.println(indice) ;
		
	}// main

}
