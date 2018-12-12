package strategie;

import fabriques.ClasseRhum;

public class Monocoque extends Voilier {

    public Monocoque(String nomVoilier, SuivreRoute suivreRoute) {
        super(nomVoilier, suivreRoute);
    }

    public Monocoque(String nom, ClasseRhum classe) {
        super(nom, classe);
    }

    public Monocoque(String nom) {
        super(nom);
    }

    public String toString() {
        return "Monocoque : " + this.nom;
    }
}
