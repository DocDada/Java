public class Date
    {
    private int chJour ;
    private int chMois ;
    private int chAnnee ;

    public Date (int parJ, int parM, int parA)
        {
        chJour = parJ ;
        chMois = parM ;
        chAnnee = parA ;
        }// Date

    // Question 1
    public String toString()
        {
        return chJour+"/"+chMois+"/"+chAnnee;
        }// toString

    public static boolean estBissextile(int parAnnee)
        {
        return (parAnnee%4==0 && parAnnee%100!=0) || parAnnee%400==0 ;
        }// estBissextile

    public static int dernierJourDuMois(int parMois, int parAnnee)
        {
        switch (parMois)
            {
            case 2:
                if (estBissextile(parAnnee))
                    return 29 ;
                return 28 ;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31 ;
            default:
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
    public static Date lireDate(Date parEntree)
        {
        System.out.println("Entrez le jour, le mois puis l'annee") ;
        parEntree.chJour = Clavier.lireInt();
        parEntree.chMois = Clavier.lireInt();
        parEntree.chAnnee = Clavier.lireInt();
        return parEntree ;
        }// lireDate

    // Question 8
    public int compareTo(Date parDate)
        {
        if (this.chAnnee==parDate.chAnnee && this.chMois==parDate.chMois && this.chJour==parDate.chJour)
            return 0 ;
        else if (this.chAnnee<=parDate.chAnnee)
            {
            if (this.chMois<=parDate.chMois)
                {
                if (this.chJour<=parDate.chJour)
                    return 1 ;
                else
                    return -1 ;
                }
            else
                return -1 ;
            }
        else
            return -1 ;
        }// compareTo


    // Question 10
    public Date dateDuLendemain()
        {
        int mois = dernierJourDuMois(this.chMois, this.chAnnee) ;
        if (this.chMois == mois)
            {
            if (this.chMois != 12)
                this.chMois += 1 ;
            else
                {
                this.chMois = 1 ;
                this.chAnnee += 1 ;
                }
            this.chJour = 1 ;
            }
        else
            this.chJour += 1 ;
        return this ;
        }// dateDuLendemain

    // Question 11
    public Date dateDeLaVeille()
        {
        if (this.chJour == 1)
            {
            if (this.chMois == 1)
                {
                this.chMois = 13 ;
                this.chAnnee -= 1 ;
                }
            this.chMois -= 1 ;
            this.chJour = dernierJourDuMois(chMois, chAnnee) ;
            }
        else
            this.chJour -= 1 ;
        return this ;
        }// dateDeLaVeille

    }// Date
