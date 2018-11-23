package observateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Classements implements Observable {

    private List<Set<Position>> classements;
    private List<Observateur> listeObservateurs;

    public Classements() {
        classements = new ArrayList<Set<Position>>();
        listeObservateurs = new ArrayList<Observateur>();
    }

    public void enregistreObservateur(Observateur o) {
        listeObservateurs.add(o);
    }

    public void desenregistreObservateur(Observateur o) {
        listeObservateurs.remove(o);
    }

    public void informeObservateur() {
        for (int i = 0; i != listeObservateurs.size(); i++) {
            Observateur o = listeObservateurs.get(i);
            o.actualise(this);
        }
    }

    public void ajoutClassement(Set<Position> positions) {
        classements.add(positions);
        informeObservateur();
    }

    public List<Observateur> getListeObservateurs() {
        return listeObservateurs;
    }

    public void setListeObservateurs(List<Observateur> listeObservateurs) {
        this.listeObservateurs = listeObservateurs;
    }

    public Set<Position> getDernierClassement() {
        return this.classements.get(this.classements.size() - 1);
    }

}
