package fabriques;

import strategie.Monocoque;
import strategie.Voilier;

public class FabriqueMonocoque implements FabriqueVoilier {
    
    public FabriqueMonocoque() {
        
    }

    public Voilier creerVoilier(String nom, ClasseRhum classe) {
        return new Monocoque(nom, classe);
    }

    public Voilier factoryMethod(String nom, ClasseRhum classe) {
        switch (classe) {
            case IMOCA:
                return new Imoca(nom);
            case CLASS40:
                return new Class40(nom);
            case RHUMMONO:
                return new RhumMono(nom);
            default:
                return new RhumMono(nom);
        }
    }

}
