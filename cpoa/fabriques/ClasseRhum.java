package fabriques;

public enum ClasseRhum {
    ULTIME, MULTI50, IMOCA, CLASS40, RHUMMULTI, RHUMMONO;

    public String toString() {
        switch (this) {
            case ULTIME:
                return "ULTIME";
            case MULTI50:
                return "MULTI50";
            case IMOCA:
                return "IMOCA";
            case CLASS40:
                return "CLASS40";
            case RHUMMULTI:
                return "RHUMMULTI";
            case RHUMMONO:
                return "RHUMMONO";
            default:
                return " ";
        }
    }
}
