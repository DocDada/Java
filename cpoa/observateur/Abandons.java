package observateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Abandons implements Observateur {

    private List<String> listeAbandons;
    
    
    public Abandons() {
        listeAbandons = new ArrayList<String>();
    }

    public String toString() {
        return listeAbandons.toString();
    }

    public void actualise(Observable o) {
        Set<Position> ensemble = ((Classements)o).getDernierClassement();
        for (Position pos : ensemble) {
            if (pos.isAbandon()) {
                if (!listeAbandons.contains(pos.getNom())) {
                    listeAbandons.add(pos.getNom());
                }
            }
        }
    }
    
    public int count() {
        return listeAbandons.size();
    }
}
