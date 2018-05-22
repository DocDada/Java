package modele;

import java.io.Serializable;

public class Heure implements Serializable {
    private int heures;
    private int minutes;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public Heure() {
        heures = 0;
        minutes = 0;
    }

    public Heure(int parH, int parM) {
        heures = parH;
        minutes = parM;
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public String toString() {
        return heures + ":" + minutes;
    }

    public static String[] heureString(boolean heure) {
        int taille = (heure) ? 24 : 60;
        String heures[] = new String[taille];
        for (int i = 0; i < taille; i++)
            heures[i] = ((i < 10) ? "0" : "") + Integer.toString(i);
        return heures;
    }

    public static String[] minuteString() {
        String minutes[] = new String[60];
        for (int i = 0; i < 60; i++)
            minutes[i] = ((i < 10) ? "0" : "") + Integer.toString(i);
        return minutes;
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}// Heure