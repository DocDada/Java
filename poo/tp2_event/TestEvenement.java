package tp2_event ;
import tp1_date.Date;
import tp4_except.ExceptionDate; ;

public class TestEvenement {
    public static void main(String args[]) {
    	try {
        Date date = new Date(6, 12, 1999) ;
        Evenement nouv = Evenement.lireEvenement() ;
        System.out.println(Evenement.getChNbParametre()) ;
        Evenement nouv2 = Evenement.lireEvenement() ;
        System.out.println(Evenement.getChNbParametre());
        Evenement nouv3 = Evenement.lireEvenement() ;
        System.out.println(Evenement.getChNbParametre()) ;
        System.out.println(nouv.toString()) ;
        System.out.println(nouv2.toString()) ;
        System.out.println(nouv3.toString()) ;
        System.out.println(date.toString()) ;
        System.out.println(Evenement.getChNbParametre()) ;
    	}
    	catch(ExceptionDate parExc) {
    		System.out.println(parExc.getMessage());
    	}
    }
}
