// TP GIT
//
public class Heros
    {
    private String nom ;
    private String classe ;
    private char genre ;
    private int pointsDeVie = 100 ;
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
        }

    public String toString()
        {
        if (genre=='f')
            return nom+" la "+classe ;
        else
            return nom+" le "+classe ;
        }

    public boolean estVivant()
        {
        return pointsDeVie>0 ;
        }

    public void Attaquer(Heros defen)
        {
        double proba = Math.random() ;
        if (proba >= this.attaque/(this.attaque+defen.defense))
            {
            System.out.println(this.toString()+" attaque "+defen.toString()+ " et inflige "+this.dommages+" points de dommages") ;
            defen.pointsDeVie -= this.dommages ;
            }
        else
            System.out.println(this.toString()+" attaque "+defen.toString()+ " et rate !") ;
        }

    public static void main(String []args)
        {
        Heros Bob = new Heros("Bob", "Magicien", 'm') ;
        System.out.println(Bob);// inutile d'ajouter .toString
        // println prend automatiquement la methode toString

        Heros Zoe = new Heros("Zoe", "Barbare", 'f') ;
        System.out.println(Zoe);

        System.out.println(Zoe.estVivant());
        Zoe.Attaquer(Bob) ;
        }
    }
