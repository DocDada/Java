package strategie;

import fabriques.ClasseRhum;

public class Monocoque extends Voilier {

    public Monocoque(String nomVoilier, SuivreRoute suivreRoute) {
        super(nomVoilier, suivreRoute);
    }

    public Monocoque(String nom, ClasseRhum classe) {
        super(nom, classe);
    }

    public String toString() {
        return "Monocoque : " + this.nom;
    }
}
