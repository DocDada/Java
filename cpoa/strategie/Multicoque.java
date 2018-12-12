package strategie;

import fabriques.ClasseRhum;

public class Multicoque extends Voilier {

    public Multicoque(String nomVoilier, SuivreRoute suivreRoute) {
        super(nomVoilier, suivreRoute);
    }

    public Multicoque(String nom, ClasseRhum classe) {
        super(nom, classe);
    }

    public Multicoque(String nom) {
        super(nom);
    }

    public String toString() {
        return "Multicoque : " + this.nom;
    }
}
