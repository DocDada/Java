package strategie;

import fabriques.ClasseRhum;

public class Multicoque extends Voilier {

    public Multicoque(String nomVoilier, SuivreRoute suivreRoute) {
        super(nomVoilier, suivreRoute);
    }

    public Multicoque(String nom, ClasseRhum classe) {
        super(nom, classe);
    }

    public String toString() {
        return "Multicoque : " + this.nom;
    }
}
