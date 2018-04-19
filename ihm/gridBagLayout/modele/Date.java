package modele;

import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>, Serializable {
    private static final long serialVersionUID = -3310884560241853876L;
    private int chJour;
    private int chJourSemaine;
    private int chSemaine ;
    private int chMois;
    private int chAnnee;

    // Question 4 tp4
    public Date() {
        // donne la date courante
        GregorianCalendar aujourdhui = new GregorianCalendar();
        chAnnee = aujourdhui.get(Calendar.YEAR);
        chMois = aujourdhui.get(Calendar.MONTH) + 1;// janvier = 0
        chJour = aujourdhui.get(Calendar.DAY_OF_MONTH);
        chJourSemaine = aujourdhui.get(Calendar.DAY_OF_WEEK);// dimanche = 1
        chSemaine = aujourdhui.get(Calendar.WEEK_OF_YEAR);
    }// Date()

    public Date(int parJ, int parM, int parA) {
        chJour = parJ;// jour
        chMois = parM;// mois
        chAnnee = parA;// annee
        chJourSemaine = getJourSemaine();
        chSemaine = getSemaine() ;
    }// Date

    // Question 1
    public String toString() {
        String jours[] = { "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi" };
        String mois[] = { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre",
                "novmebre", "octobre", "décembre" };
        return jours[chJourSemaine - 1] + " " + chJour + " " + mois[chMois - 1]/* +" "+chAnnee */;
    }// toString

    public static boolean estBissextile(int parAnnee) {
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }// estBissextile

    public static int dernierJourDuMois(int parMois, int parAnnee) {
        switch (parMois)// en fonction du mois
        {
        case 2:// si c'est février
            if (estBissextile(parAnnee))
                return 29;
            return 28;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        default:// avril, juin, septembre, novembre
            return 30;
        }
    }// dernierJourDuMois

    // Question 3
    public boolean estValide() {
        if (this.chAnnee < 1583)
            return false;
        if (this.chMois > 0 && this.chMois <= 12 && this.chJour <= dernierJourDuMois(this.chMois, this.chAnnee)
                && this.chJour > 0)
            return true;
        return false;
    }// estValide

    // Question 6
    /*
     * public static Date lireDate() throws ExceptionDate {
     * System.out.println("Entrez le jour, le mois puis l'annee") ; return new
     * Date(Clavier.lireInt(), Clavier.lireInt(), Clavier.lireInt()) ; }// lireDate
     */

    // Question 7 tp4
    public static Date lireDate() {
        System.out.println("Entrez le jour, le mois puis l'annee (dd-mm-aaa)");
        String dateStr = Clavier.lireString();// l'utilisateur entre la date
        int valeursDate[] = new int[3];// les valeurs seront récupérées séparément
        StringTokenizer st = new StringTokenizer(dateStr, "-");// le token est le tiret (l'espace: par défaut)
        for (int indice = 0; st.hasMoreTokens(); indice++)// tant qu'il y a encore un token, on prend une valeur
            valeursDate[indice] = Integer.parseInt(st.nextToken());
        return new Date(valeursDate[0], valeursDate[1], valeursDate[2]);
    }

    // Question 8
    // si this < parDate ---> -1
    // si this = parDate ---> 0
    // si this > parDate ---> +1
    public int compareTo(Date parDate) {
        if (this.chAnnee == parDate.chAnnee && this.chMois == parDate.chMois && this.chJour == parDate.chJour)
            return 0;// si dates equivalentes
        if (this.chAnnee <= parDate.chAnnee) {
            if (this.chMois <= parDate.chMois || this.chAnnee < parDate.chAnnee) {
                if (this.chJour <= parDate.chJour || this.chAnnee < parDate.chAnnee || this.chMois < parDate.chMois)
                    return -1;
                return 1;
            }
            return 1;
        }
        return 1;
    }// compareTo

    // CORRECTION
    public Date dateDuLendemain() {
        if (chJour < dernierJourDuMois(chMois, chAnnee))
            return new Date(chJour + 1, chMois, chAnnee);
        else if (chMois < 12)
            return new Date(1, chMois + 1, chAnnee);
        else
            return new Date(1, 1, chAnnee + 1);
    }

    // CORRECTION
    public Date dateDeLaVeille() {
        if (chJour > 1)
            return new Date(chJour - 1, chMois, chAnnee);
        else if (chMois > 1)
            return new Date(Date.dernierJourDuMois(chMois - 1, chAnnee), chMois - 1, chAnnee);
        else
            return new Date(31, 12, chAnnee - 1);
    }

    public int getChAnnee() {
        return chAnnee;
    }

    public int getChMois() {
        return chMois;
    }

    public static String getChMoisString(int chMois) {
        String mois[] = { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre",
                "novembre", "octobre", "décembre" };
        return mois[chMois - 1];
    }

    public int getChJour() {
        return chJour;
    }

    // IHM - TP5 - Question 1
    public int getJourSemaine() {
        GregorianCalendar cal = new GregorianCalendar(chAnnee, chMois - 1, chJour);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public Date datePremierJourSemaine() {
        Date datePrem = this;
        while (datePrem.getJourSemaine() != 2) {
            datePrem = datePrem.dateDeLaVeille();
        }
        return datePrem;
    }

    public boolean isToday() {
        return new Date().compareTo(this) == 0;
    }

    public Date getChDate() {
        return this;
    }

    public int getSemaine() {
        GregorianCalendar calendar = new GregorianCalendar(chAnnee, chMois - 1, chJour);
        return calendar.get(Calendar.WEEK_OF_YEAR);// numero de la semaine dans l'annee
    }

}// Date