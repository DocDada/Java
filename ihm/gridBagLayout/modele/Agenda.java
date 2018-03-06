package modele;

public class Agenda {
	private final int LONGUEUR ;
	private int nbEvenements ;
	private Evenement tabEvenements[] ;
	
	public Agenda(int parLONGUEUR) {
		LONGUEUR = parLONGUEUR ;
		tabEvenements = new Evenement[LONGUEUR] ;
	}// Agenda()
	
	public boolean ajout(Evenement parEvt) {
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
	
	
	//marche pas
	public void triParSelection() {
		Evenement min ;
		for (int j, i = 0 ; i < nbEvenements ; i++) {
			min = tabEvenements[i] ;
			for (j = i+1 ; j < nbEvenements ; j++)
				if (tabEvenements[j].compareTo(min)<0)
					min = tabEvenements[j] ;
			tabEvenements[j] = tabEvenements[i] ;// echange
			tabEvenements[i] = min ;
		}
	}// triParSelection()
	
	public void triParInsertion() {
		Evenement stock, echange ;
		for (int j, i = 0 ; i < nbEvenements ; i++) {
			stock = tabEvenements[i] ;
			for (j = i ; j>0 && stock.compareTo(tabEvenements[j-1])<0; j--) {
				echange = tabEvenements[j] ;
				tabEvenements[j] = tabEvenements[j-1] ;
				tabEvenements[j-1] = echange ;
			}
			tabEvenements[j] = stock ;
		}
	}// triParInsertion()
}
