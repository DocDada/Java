// TP GIT
import java.util.Scanner ;


public class Heros
    {
    private String nom ;
    private String classe ;
    private char genre ;
    private int pointsDeVie = 100 ;
    private int pointsDeVieMax = 100 ;
    private int attaque = 10 ;
    private int defense = 10 ;
    private int dommages = 10 ;

    public Heros(String parNom, String parClasse, char parGenre)
        {
        nom = parNom ;
        classe = parClasse ;
        genre = parGenre ;
        }

    public Heros(int pv, int atk, int def, int domm)
        {
        pointsDeVie = pv ;
        attaque = atk ;
        defense = def ;
        dommages = domm ;
        }// Heros

    public String toString()
        {
        if (genre=='f')
            return nom+" la "+classe ;
        else
            return nom+" le "+classe ;
        }// toString

    public boolean estVivant()
        {
        return pointsDeVie>0 ;
        }// estVivant

    public void Soigner()
        {
        this.pointsDeVie = pointsDeVieMax ;
        System.out.println(this.toString()+" a regagné tous ses points de vie !");
        }// Soigner

    public void Attaquer(Heros defens)
        {
        Scanner sc = new Scanner(System.in);// on entre son choix au clavier
        int choix ;
        switch (this.classe)// en fonction de la classe du personnage ...
            {
            case "Barbare":// ... differentes attaques il y a
                System.out.println("--> Attaque normale\n--> Frappe éclair\n--> Frappe de l'ours") ;
                choix = sc.nextInt() ;// on recupere un entier ...
                switch (choix)// ... pour choisir l'attaque
                    {
                    case 1:
                        this.AttaqueSpe(defens, 0, 0, "un coup d'épée") ;
                        return ;
                    case 2 :
                        this.AttaqueSpe(defens, 0.1f, -1, "un coup fulgurant") ;
                        return ;
                    case 3:
                        this.AttaqueSpe(defens, -0.2f, +5, "l'attaque de l'ours") ;
                        return ;
                    }
            case "Magicien":
                System.out.println("--> Attaque normale\n--> Boule de feu\n--> Cyclone de Turchin\n--> Soin") ;
                choix = sc.nextInt() ;
                switch (choix)
                    {
                    case 1:
                        this.AttaqueSpe(defens, 0, 0, "un petit coup de baton") ;
                        return ;
                    case 2 :
                        this.AttaqueSpe(defens, -0.1f, 1, "une boule incandescente, s'abattant") ;
                        return ;
                    case 3:
                        this.AttaqueSpe(defens, 0.2f, +5, "la puissance d'un cyclone") ;
                        return ;
                    case 4:
                        this.Soigner() ;
                        return ;
                    }
            }
        }// Attaquer

    public void AttaqueSpe(Heros defens, float factProba, int factAttaq, String nomAttaq)
        {
        double proba = Math.random() ;
        float prob=((float)(attaque)/(float)(defens.attaque+defens.defense));
        if (proba < prob+factProba)// condition pour que l'attaque reussisse
            {
            this.dommages = this.DommagesAleatoire() ;
            defens.pointsDeVie -= this.dommages + factAttaq ;
            System.out.println(this.toString()+" envoie "+nomAttaq+" sur "+defens.toString()+" et lui inflige "+this.dommages+" points de dommages !");
            }
        else
            System.out.println(this.toString()+" effectue "+nomAttaq+" sur "+defens.toString()+" ... et rate.");
        }// AttaqueSpe

    public int DommagesAleatoire()
        {
        return this.attaque + (int)(Math.random()*10) ;
        }// DommagesAleatoire

    public void AffichePV(Heros defens)
        {
        int i = 0 ;
        for ( ; i < 55 ; i++)// esthetique
            System.out.print("_") ;
        System.out.println("") ;
        System.out.println("\n>>> "+this.toString()+" ||  POINTS DE VIE : "+this.pointsDeVie+"/"+this.pointsDeVieMax+"\t<<<") ;
        // le personnage attaquant est designe par des fleches >>> ...
        System.out.println("\n--- "+defens.toString()+" || POINTS DE VIE : "+defens.pointsDeVie+"/"+defens.pointsDeVieMax+"\t---") ;
        // ... et le peronnage se defendant par ---
        for (i = 0 ; i < 55 ; i++)// esthetique
            System.out.print("_") ;
        System.out.println("\n") ;
        }// Affiche PV

    public void Combat(Heros defens)
        {
        for (int compteur=0;this.pointsDeVie>0 && defens.pointsDeVie>0;compteur++)
            {
            // tant qu'aucun joueur n'est mort :
            if (compteur%2 == 0)
                {
                this.AffichePV(defens) ;// on affiche les pv ...
                this.Attaquer(defens) ;// ... et on attaque
                }
            else
                {
                defens.AffichePV(this) ;
                defens.Attaquer(this) ;
                }
            }
        if (this.pointsDeVie<=0)
            System.out.println(this.toString()+" est mort.") ;
        else
            System.out.println(defens.toString()+" est mort.") ;
        }// Combat

    public static void main(String []args)
        {
        Heros Bob = new Heros("Bob", "Magicien", 'm') ;
        System.out.println(Bob);// inutile d'ajouter .toString
        // println prend automatiquement la methode toString

        Heros Zoe = new Heros("Zoe", "Barbare", 'f') ;
        System.out.println(Zoe);

        Bob.Combat(Zoe);
        }// main
    }
