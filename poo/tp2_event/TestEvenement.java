package paquet.tp2_event ;
import paquet.tp1_date.Date;


public class TestEvenement {
    public static void main(String args[]) {
        Date date = new Date(6, 12, 1999) ;
        Evenement nouv = Evenement.lireEvenement() ;
        System.out.println(nouv.getChNbParametre()) ;
        Evenement nouv2 = Evenement.lireEvenement() ;
        System.out.println(nouv.getChNbParametre());
        Evenement nouv3 = Evenement.lireEvenement() ;
        System.out.println(nouv.getChNbParametre()) ;
        System.out.println(nouv.toString()) ;
        System.out.println(nouv.getChNbParametre()) ;
    }
}
