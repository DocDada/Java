package tp4;

/**
 * Désigne le constructeur de l'instrument
 * @author prepain
 *
 */
public enum Builder {

    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    /**
     * Renvoie un string du nom du constructeur
     */
    public String toString() {
        switch (this) {
            case FENDER:
                return "Fender";
            case MARTIN:
                return "Martin";
            case GIBSON:
                return "Gibson";
            case COLLINGS:
                return "Collings";
            case OLSON:
                return "Olson";
            case RYAN:
                return "Ryan";
            case PRS:
                return "PRS";
            default:
                return "Unspecified";
        }
    }
}
