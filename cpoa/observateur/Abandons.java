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
        Set<Position> ensemble = ((Classements) o).getDernierClassement();
        for (Position pos : ensemble) {
            // we check if the skipper has given up
            if (pos.isAbandon()) {
                // we check if the list already contains the skipper
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
