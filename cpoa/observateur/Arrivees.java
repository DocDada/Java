package observateur;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Arrivees implements Observateur {

    TreeSet<Position> voiliersArrives;
    
    public Arrivees() {
        this.voiliersArrives = new TreeSet<Position>();
    }
    
    public void actualise(Observable o) {
        // we take the last rankings added
        Set<Position> ensemble = ((Classements)o).getDernierClassement();
        // we check for each sailboat
        for (Position pos : ensemble) {
            // if the sailboat has arrived
            if (pos.getDateEtHeure() != null) {
                // no need to check if the treeset contains already the sailboat
                voiliersArrives.add(pos);
            }
        }
    }
    
    public String toString() {
        String display = new String();
        Iterator<Position> iter = this.voiliersArrives.iterator();
        // il faut declarer un iterateur pour parcourir un TreeSet
        while(iter.hasNext()) {
            display += iter.next() + " ";
        }
        return display;
    }

    
    public int count() {
        return voiliersArrives.size();
    }
}
