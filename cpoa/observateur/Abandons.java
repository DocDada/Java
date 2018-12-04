package observateur;

import java.util.HashSet;
import java.util.Set;

public class Abandons implements Observateur {

    private HashSet<String> listeAbandons;

    public Abandons() {
        listeAbandons = new HashSet<String>();
    }

    public String toString() {
        return listeAbandons.toString();
    }

    public void actualise(Observable o) {
        Set<Position> ensemble = ((Classements) o).getDernierClassement();
        for (Position pos : ensemble) {
            // we check if the skipper has given up
            if (pos.isAbandon()) {
                // no use to check if the list already contains the skipper, it is a hashset
                listeAbandons.add(pos.getNom());
            }
        }
    }

    public int count() {
        return listeAbandons.size();
    }
}
