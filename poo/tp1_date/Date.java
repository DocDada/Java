package tp1_date ;
import tp4_except.ExceptionDate ;
import java.util.GregorianCalendar ;
import java.util.Calendar ;

public class Date
    {
    private int chJour ;
    private int chJourSemaine ;
    private int chMois ;
    private int chAnnee ;

    // Question 4 tp4
    public Date()
    	{
    	// donne la date courante
    	GregorianCalendar aujourdhui = new GregorianCalendar() ;
    	chAnnee = aujourdhui.get(Calendar.YEAR) ;
    	chMois = aujourdhui.get(Calendar.MONTH)+1;// les mois commencent à 0
    	chJour = aujourdhui.get(Calendar.DAY_OF_MONTH);
    	chJourSemaine = aujourdhui.get(Calendar.DAY_OF_WEEK);// dimanche = 1
    	}// Date()
    
    
    public Date (int parJ, int parM, int parA) throws ExceptionDate
        {
    	// on gère les exceptions
    	if (parA<1583)
    		throw new ExceptionDate("L'année doit être supérieure à 1582.");
    	if (parM<=0 || parM>12)
    		throw new ExceptionDate("Le mois doit être compris entre 1 et 12.");
    	if (parJ<=0 || parJ>Date.dernierJourDuMois(parM, parA))
    		throw new ExceptionDate("Le jour doit être compris entre 1 et "+Date.dernierJourDuMois(parM, parA));
    	
    	GregorianCalendar date = new GregorianCalendar(parJ, parM, parA);
    	

    	
        chJour = parJ ;// jour
        chMois = parM ;// mois
        chAnnee = parA ;// annee
        chJourSemaine = date.get(Calendar.DAY_OF_WEEK);
        }// Date

    // Question 1
    public String toString()
        {
    	String jours[] = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"} ;
    	String mois[] = {"janvier, février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "novmebre", "octobre", "décembre"} ;
        return jours[chJourSemaine-1]+" "+chJour+" "+mois[chMois]+" "+chAnnee;
        }// toString

    public static boolean estBissextile(int parAnnee)
        {
        return (parAnnee%4==0 && parAnnee%100!=0) || parAnnee%400==0 ;
        }// estBissextile

    public static int dernierJourDuMois(int parMois, int parAnnee)
        {
        switch (parMois)
            {
            case 2:// si c'est le fevrier
                if (estBissextile(parAnnee))
                    return 29 ;
                return 28 ;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31 ;
            default:// avril, juin, septembre, novembre
                return 30 ;
            }
        }// dernierJourDuMois

    // Question 3
    public boolean estValide()
        {
        if (this.chAnnee<1583)
            return false ;
        if (this.chMois>0 && this.chMois<=12 && this.chJour<=dernierJourDuMois(this.chMois, this.chAnnee) && this.chJour>0)
            return true ;
        return false ;
        }// estValide

    // Question 6
    public static Date lireDate() throws ExceptionDate
        {
        System.out.println("Entrez le jour, le mois puis l'annee") ;
        return new Date(Clavier.lireInt(), Clavier.lireInt(), Clavier.lireInt()) ;
        }// lireDate

    // Question 8
    // si this < parDate ---> -1
    // si this = parDate --->  0
    // si this > parDate ---> +1
    public int compareTo(Date parDate)
        {
        if (this.chAnnee==parDate.chAnnee && this.chMois==parDate.chMois && this.chJour==parDate.chJour)
            return 0 ;// si dates equivalentes
        if (this.chAnnee<=parDate.chAnnee)
            {
            if (this.chMois<=parDate.chMois)
                {
                if (this.chJour<=parDate.chJour)
                    return 1 ;// ici, parDate posterieure en tous points
                return -1 ;
                }
            return -1 ;
            }
        return -1 ;
        }// compareTo


    // Question 10
    public Date dateDuLendemain()
        {
        int jour = dernierJourDuMois(this.chMois, this.chAnnee) ;
        if (this.chJour == jour)// si jour egal dernier jour du mois
            {
            if (this.chMois != 12)// si ce n'est pas decembre
                this.chMois++ ;// on passe au mois suivant
            else
                {
                this.chMois = 1 ;// cas particulier : on passe de decembre
                this.chAnnee++ ;// ... a janvier
                }
            this.chJour = 1 ;// premier jour du mois
            }
        else
            this.chJour++ ;// on passe au jour suivant
        return this ;
        }// dateDuLendemain

    // Question 11
    public Date dateDeLaVeille()
        {
        if (this.chJour == 1)// si premier jour du mois
            {
            if (this.chMois == 1)// si janvier
                {
                this.chMois = 13 ;// va etre decrementé
                this.chAnnee-- ;// on passe a l'annee precedente
                }
            this.chMois-- ;
            this.chJour = dernierJourDuMois(chMois, chAnnee) ;
            }
        else
            this.chJour-- ;
        return this ;
        }// dateDeLaVeille
    
    public int getChAnnee() 
    	{
    	return chAnnee ;
    	}
    
    public int getChMois()
    	{
    	return chMois ;
    	}
    
    public int getChJour()
    	{
    	return chJour ;
    	}

    }// Date
