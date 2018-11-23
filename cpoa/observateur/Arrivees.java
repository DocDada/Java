package observateur;

import java.util.Set;
import java.util.TreeSet;

public class Arrivees implements Observateur {

    TreeSet<String> voiliersArrives;
    
    public Arrivees() {
        this.voiliersArrives = new TreeSet<String>();
    }
    
    public void actualise(Observable o) {
        Set<Position> ensemble = ((Classements)o).getDernierClassement();
        for (Position pos : ensemble) {
            if (pos.getDateEtHeure() != null) {
                if (!voiliersArrives.contains(pos.getNom())) {
                    voiliersArrives.add(pos.getNom());
                }
            }
        }
    }

    
    public int count() {
        return voiliersArrives.size();
    }
}
