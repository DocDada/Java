package tp5_collection;
import tp2_event.Evenement;
import java.util.ArrayList ;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet ;

import tp1_date.Date;

public class AgendaV2 {
	private ArrayList<Evenement> listEvts ;
	private TreeSet<Evenement> arbreEvts ;
	private TreeMap<Integer, Evenement> treeMapEvts ;
	private HashMap<Integer, Evenement> mapEvts ;
	
	// Question 1, 5
	public AgendaV2() {
		listEvts = new ArrayList<Evenement>();
		arbreEvts = new TreeSet<Evenement>() ;
		treeMapEvts = new TreeMap<Integer, Evenement>();
		mapEvts = new HashMap<Integer, Evenement>() ;
	}// AgendaV2()
	
	// Question 7, 8
	public String toString() {
		String string = new String();
		string += listEvts.toString()+"\n" ;
		string+= arbreEvts.toString()+"\n" ;
		string += treeMapEvts.toString()+"\n" ;
		string += mapEvts.toString();
		return string ;
	}//toString()
	
	// Question 1, 5
	public void ajout(Evenement parEvt) {
		listEvts.add(parEvt);
		arbreEvts.add(parEvt);
		treeMapEvts.put(parEvt.getChDate().getChJourSemaine(), parEvt) ;
		mapEvts.put(parEvt.getChDate().getChJourSemaine(), parEvt) ;
	}//ajout
	
	
	// Question 3
	public int nbExpose() {
		// retourne le nombre de fois où il y a "exposé" dans le titre d'un événement
		// dans l'agenda;pas le nombre de fois où il y a "exposé" dans le titre
		int iter = 0 ;
		for(int index = 0 ; index < this.listEvts.size() ; index++)
			if(this.listEvts.get(index).getChTitre().contains("exposé"))
				iter++ ;
		return iter;
	}// nbExpose()
	
	
	// Question 4
	public int nbEvtEnregistre(Date parDate) {
		// retourne le nombre d'événements qui ont
		// une même date que celle passée en paramètre
		int nbEvts = 0 ;
		Iterator<Evenement> iter = this.arbreEvts.iterator();
		// il faut déclarer un itérateur pour parcourir une ArrayList
		while(iter.hasNext())
			if (iter.next().getChDate().compareTo(parDate)==0)
				nbEvts++ ;
		return nbEvts ;
	}// nbEvtEnregistre
}
