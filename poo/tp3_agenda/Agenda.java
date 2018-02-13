package paquet.tp3_agenda;
import paquet.tp2_event.Evenement;

public class Agenda {
	private final int  LONGUEUR ;
	private int nbEvenements ;
	private Evenement tabEvenements[] ;
	
	public Agenda(int parLONGUEUR) {
		LONGUEUR = parLONGUEUR ;
		tabEvenements = new Evenement[LONGUEUR] ;
	}// Agenda()
	
	public boolean ajout(Evenement parEvt) {
		if (nbEvenements == LONGUEUR)
			return false ;
		tabEvenements[nbEvenements] = parEvt ;
		nbEvenements++ ;
		return true ;
	}// ajout
	
	public int getEvenement(Evenement parEvt) {
		for (int indice = 0 ; indice < nbEvenements ; indice++) 
			if (parEvt.compareTo(tabEvenements[indice])==0)
				return indice ;
		return -1 ;
	}// getEvenement
	
	public String toString() {
		String chaine = new String() ;
		for (int indice = 0 ; indice < nbEvenements ; indice++)
			chaine += tabEvenements[indice] + "\n" ;
		return chaine ;
	}// toString()
	
	// Question 6
	// renvoie l'indice de l'événement le plus petit entre
	// les indices parDebut et parFin
	public int rechercheMinimum(int parDebut, int parFin) {
		Evenement min = tabEvenements[parDebut] ;
		for ( ; parDebut < parFin ; ++parDebut) {
			if (tabEvenements[parDebut].compareTo(min)<0)
				min = tabEvenements[parDebut] ;
		}
		return parDebut ;
	}// rechercheMinimum
	
	public void triParSelection() {
		for (int i = 0 ; i < nbEvenements ; i++) {
			
		}
	}// triParSelection()
}
