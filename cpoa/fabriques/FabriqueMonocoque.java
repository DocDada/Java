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
        return new Monocoque(nom, classe);
    }

}
