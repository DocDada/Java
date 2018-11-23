package observateur;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Arrivees implements Observateur {

    TreeSet<String> voiliersArrives;
    
    public Arrivees() {
        this.voiliersArrives = new TreeSet<String>();
    }
    
    public void actualise(Observable o) {
        // we take the last rankings added
        Set<Position> ensemble = ((Classements)o).getDernierClassement();
        // we check for each sailboat
        for (Position pos : ensemble) {
            // if the sailboat has arrived
            if (pos.getDateEtHeure() != null) {
                // if the list doesn't contain already the sailboat
                if (!voiliersArrives.contains(pos.getNom())) {
                    voiliersArrives.add(pos.getNom());
                }
            }
        }
    }
    
    public String toString() {
        String display = new String();
        Iterator<String> iter = this.voiliersArrives.iterator();
        // il faut declarer un iterateur pour parcourir un TreeSet
        while(iter.hasNext()) {
            display += iter.next();
        }
        return display;
    }

    
    public int count() {
        return voiliersArrives.size();
    }
}
