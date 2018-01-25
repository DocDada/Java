public class TestDate
    {
    public static void main(String []args)
        {
        Date resultat = new Date(29, 2, 2013) ;
        System.out.println(resultat.toString());

        System.out.println(resultat.estValide());

        Date entree = new Date(1,1,1000) ;
        entree = Date.lireDate(entree);
        System.out.println(entree.toString());

        System.out.println(entree.compareTo(resultat)) ;

        int iter = 0 ;
        Date ancienne = new Date(0, 0, 0) ;
        Date date = ancienne ;
        /*for ( ; iter!=3 ; iter++)
            {
            date = Date.lireDate(date);
            if (ancienne.compareTo(date)>0)
                ancienne = date ;
            }
        */
        System.out.println(ancienne.toString()) ;

        entree = entree.dateDuLendemain() ;
        System.out.println(entree.toString()) ;
        //entree = entree.dateDeLaVeille() ;
        //System.out.println(entree.toString()) ;
        }// main
    }// TestDate
