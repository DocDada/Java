public class TestEvenement {
    public static void main(String args[]) {
        Date date = new Date(6, 12, 1999) ;
        Evenement nouv = Evenement.lireEvenement() ;
        System.out.println(nouv.toString()) ;
        System.out.println(nouv.getChNbParametre()) ;
    }
}
