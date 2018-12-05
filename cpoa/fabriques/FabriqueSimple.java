package fabriques;

import strategie.Multicoque;
import strategie.Monocoque;
import strategie.Voilier;
import fabriques.ClasseRhum;

public class FabriqueSimple {

    public Voilier creerVoilier(String nom, ClasseRhum classe) {
        switch (classe) {
            case ULTIME:
            case MULTI50:
            case RHUMMULTI:
                return new Multicoque(nom, classe);
            case IMOCA:
            case CLASS40:
            case RHUMMONO:
                return new Monocoque(nom, classe);
            default:
                return new Monocoque(nom, classe);
        }
    }

    public Voilier createSailboat(String nom, ClasseRhum classe) {
        FabriqueMulticoque pereNoel = new FabriqueMulticoque();
        FabriqueMonocoque pereFouras = new FabriqueMonocoque();

        switch (classe) {
            case ULTIME:
            case MULTI50:
            case RHUMMULTI:
                return pereNoel.factoryMethod(nom, classe);
            case IMOCA:
            case CLASS40:
            case RHUMMONO:
                return pereFouras.factoryMethod(nom, classe);
            default:
                return pereFouras.factoryMethod(nom, classe);
        }
    }

}
