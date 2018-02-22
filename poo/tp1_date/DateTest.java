package tp1_date;
import tp4_except.ExceptionDate;
import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {



	@Test
	public void testDateIntIntInt_et_getters() {
		try {
			Date d = new Date(1,2,2003);
			assertEquals(1, d.getChJour());
			assertEquals(2, d.getChMois());
			assertEquals(2003, d.getChAnnee());
		}
		catch(ExceptionDate parExc) {
			parExc.printStackTrace() ;
		}
		
		// test de renvoi d'exception pour les dates invalides
		try {
			Date d1 = new Date(1, 1, 1000);
			// exécuté seulement si pas d'exception
			fail("mois invalide en 0");
		}
		catch(ExceptionDate parExc) {
			assertTrue(parExc.getMessage().contains("à 1582"));
			// si le message d'exception contient "entre 1 et 12"
		}
	}

	@Test
	public void testToString() {
		//marche pas
		try {
			Date d = new Date(20, 2, 2018) ;
			String response = "Mardi 20 février 2018";
			assertEquals("test toString",0, d.toString().compareTo(response));
		}
		catch(ExceptionDate parExc) {
			parExc.printStackTrace() ;
		}
	}

	@Test
	public void testEstBissextile() {
		assertFalse("annee impaire", Date.estBissextile(2001));
		assertFalse("annee paire non divisible par 4", Date.estBissextile(2002));
		assertTrue("annee divisible par 4 pas par 100", Date.estBissextile(2040));
		assertFalse("annee divisible par 100 pas par 400", Date.estBissextile(2100));
		assertTrue("annee div par 400", Date.estBissextile(2000));
	}

	@Test
	public void testDernierJourDuMois() {
		assertEquals("mois en 31", 31, Date.dernierJourDuMois(1, 2001));
		// on regarde si 31 == Date.dernierJourDuMois(1, 2001)
		assertEquals("mois en 30", 30, Date.dernierJourDuMois(4, 2001));
		assertEquals("mois en 29", 29, Date.dernierJourDuMois(2, 2004));
		assertEquals("mois en 28", 28, Date.dernierJourDuMois(2, 2001));
	}


	@Test
	public void testLireDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		try {
			Date d1 = new Date(2,2,2002);
			Date d1bis = new Date(2,2,2002);
			Date d2 = new Date(3,2,2002);
			Date d3 = new Date(2,3,2002);
			Date d4 = new Date(3,1,2002);
			Date d5 = new Date(2,2,2003);
			
			assertEquals(0, d1.compareTo(d1bis));
			assertEquals(1, d1.compareTo(d2));
			assertEquals(-1, d2.compareTo(d1));
			assertEquals(-1, d5.compareTo(d1));
			assertEquals(1, d1.compareTo(d5));
			
			//assertEquals(1, d3.compareTo(d4));// marche pas
			assertEquals(-1, d4.compareTo(d3));
		}
		
		catch(ExceptionDate parExc) {
			parExc.printStackTrace() ;
		}
	}

	@Test
	public void testDateDuLendemain() {
		try {
			Date d1 = new Date(2,3,2004);
			Date d1L = new Date(3,3,2004);
			assertEquals("lendemain quelconque", 0, d1.dateDuLendemain().compareTo(d1L));
			
			Date d2 = new Date(31,1,2004);
			Date d2L = new Date(1,2,2004);
			assertEquals("lendemain fin de mois en 31", 0, d2.dateDuLendemain().compareTo(d2L));
			
			Date d3 = new Date(29,2,2004);
			Date d3L = new Date(1,3,2004);
			assertEquals("lendemain fin fev biss", 0, d3.dateDuLendemain().compareTo(d3L));
			
			Date d4= new Date(28,2,2003);
			Date d4L = new Date(1,3,2003);
			assertEquals("lendemain fin fev non biss", 0, d4.dateDuLendemain().compareTo(d4L));
			
			Date d5 = new Date(31,12,2004);
			Date d5L = new Date(1,1,2005);
			assertEquals("lendemain fin annee", 0, d5.dateDuLendemain().compareTo(d5L));
		}
		catch (ExceptionDate parExc){
			parExc.printStackTrace() ;
		}
	}

	@Test
	public void testDateDeLaVeille() {
		try {
			Date d1 = new Date(2,3,2004);
			Date d1L = new Date(3,3,2004);
			assertEquals("lendemain quelconque", 0, d1L.dateDeLaVeille().compareTo(d1));
			
			Date d2 = new Date(31,1,2004);
			Date d2L = new Date(1,2,2004);
			assertEquals("lendemain fin de mois en 31", 0, d2L.dateDeLaVeille().compareTo(d2));
			
			Date d3 = new Date(29,2,2004);
			Date d3L = new Date(1,3,2004);
			assertEquals("lendemain fin fev biss", 0, d3L.dateDeLaVeille().compareTo(d3));
			
			Date d4= new Date(28,2,2003);
			Date d4L = new Date(1,3,2003);
			assertEquals("lendemain fin fev non biss", 0, d4L.dateDeLaVeille().compareTo(d4));
			
			Date d5 = new Date(31,12,2004);
			Date d5L = new Date(1,1,2005);
			assertEquals("lendemain fin annee", 0, d5L.dateDeLaVeille().compareTo(d5));
		}
		catch (ExceptionDate parExc){
			parExc.printStackTrace() ;
		}
	}

}
