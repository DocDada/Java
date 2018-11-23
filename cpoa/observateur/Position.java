package observateur;

import java.util.GregorianCalendar;

public class Position implements Comparable<Position> {

    private String nom;
    private String skipper;
    private double distance;
    private GregorianCalendar dateEtHeure;
    private boolean abandon;

    public Position(String nom, String skipper, double distance,
            GregorianCalendar dateEtHeure, boolean abandon) {
        this.nom = nom;
        this.skipper = skipper;
        this.distance = distance;
        this.dateEtHeure = dateEtHeure;
        this.abandon = abandon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSkipper() {
        return skipper;
    }

    public void setSkipper(String skipper) {
        this.skipper = skipper;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public GregorianCalendar getDateEtHeure() {
        return dateEtHeure;
    }

    public void setDateEtHeure(GregorianCalendar dateEtHeure) {
        this.dateEtHeure = dateEtHeure;
    }

    public boolean isAbandon() {
        return abandon;
    }

    public void setAbandon(boolean abandon) {
        this.abandon = abandon;
    }

    public String toString() {
        return this.nom;
    }

    public int compareTo(Position pos) {
        if (this.getDateEtHeure().compareTo(pos.getDateEtHeure()) < 0) {
            return -1;
        } else if (this.getDateEtHeure().compareTo(pos.getDateEtHeure()) > 0) {
            return 1;
        }
        return 0;
    }

}
