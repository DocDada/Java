package fabriques;

import strategie.Multicoque;
import strategie.Voilier;

public class FabriqueMulticoque implements FabriqueVoilier {
    
    public FabriqueMulticoque() {
        
    }

    public Voilier creerVoilier(String nom, ClasseRhum classe) {
        return new Multicoque(nom, classe);
    }
    
    public Voilier factoryMethod(String nom, ClasseRhum classe) {
        switch (classe) {
            case ULTIME:
                return new Ultime(nom);
            case MULTI50:
                return new Multi50(nom);
            case RHUMMULTI:
                return new RhumMulti(nom);
            default:
                return new RhumMulti(nom);
        }
    }
}
