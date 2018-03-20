package modele;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;

public class CalendrierDuMois {	
  
	private Collection <Date> dates;	  
	  
	public CalendrierDuMois(int mois, int annee) {			   
		dates = new TreeSet <Date> ();
		Date date = new Date (1, mois, annee);// premier du mois
		int indiceJour = date.getJourSemaine() == 1 ? 6 : date.getJourSemaine()-2;
		// si c'est dimanche
		for (int x = indiceJour ; x>=0 ; x--) {
			dates.add(date);// on ajoute les dates, de la plus grande à la plus petite	    	
			date = date.dateDeLaVeille();// decremente date
		}	    
		date = new Date (2, mois, annee);
		indiceJour = indiceJour+1 % 7 ;
		while (date.getChMois() == mois) {
			while(indiceJour<7) {
				dates.add(date);
				date = date.dateDuLendemain();
				indiceJour++ ;
			}
			indiceJour=0;
		}
	}
	
	public String toString() {
		Iterator<Date> iter = dates.iterator();
		return Date.getChMoisString(iter.next().getChMois())+" "+dates.size()+" dates : "+dates.toString() ;
	}

	  
	public Collection <Date> getDates() {
		return dates;
	}
    
}