// TP GIT
//
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
    
    public String Soigner()
        {
        this.pointsDeVie = pointsDeVieMax ;
        return this.toString()+" a regagné tous ses points de vie !" ;
        }

    public String Attaquer(Heros defens)
        {
        double proba = Math.random() ;
        if (proba > (float) (this.attaque / (defens.attaque+defens.defense)))
            {
            defens.pointsDeVie -= this.dommages ;
            return this.toString()+" attaque "+defens.toString()+" et lui inflige "+this.dommages+" points de dommages !" ;
            }
        return this.toString()+" attaque "+defens.toString()+" et rate !" ;
        }
    
    public String Combat(Heros defen)
        {
        int compteur = 0 ;
        for ( ; this.pointsDeVie>0 && defen.pointsDeVie>0 ; compteur++)
            {
            if (compteur%2==0)
                System.out.println(this.Attaquer(defen)) ;
            else
                System.out.println(defen.Attaquer(this)) ;
            }
        if (this.pointsDeVie<=0)
            return this.toString()+" est mort." ;
        else
            return defen.toString()+" est mort." ;
        }

    public static void main(String []args)
        {
        Heros Bob = new Heros("Bob", "Magicien", 'm') ;
        System.out.println(Bob);// inutile d'ajouter .toString
        // println prend automatiquement la methode toString

        Heros Zoe = new Heros("Zoe", "Barbare", 'f') ;
        System.out.println(Zoe);
        System.out.println(Bob.Attaquer(Zoe));
        System.out.println(Bob.Combat(Zoe));
        }
    }
