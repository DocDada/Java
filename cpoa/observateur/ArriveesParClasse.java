package observateur;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import fabriques.ClasseRhum;

public class ArriveesParClasse implements Observateur {
    private HashMap<ClasseRhum, TreeSet<Position>> arriveesParClasse;
    
    public ArriveesParClasse() {
        this.arriveesParClasse = new HashMap<ClasseRhum, TreeSet<Position>>();
    }

    public void actualise(Observable o) {
       
    }
    
}
