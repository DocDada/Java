package fabriques;

import strategie.Voilier;

public interface FabriqueVoilier {

    public Voilier creerVoilier(String nom, ClasseRhum classe);

}
