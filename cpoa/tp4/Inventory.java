package tp4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * liste d'instruments
 * @author prepain
 *
 */
public class Inventory {
	/**
	 * une liste d'instruments
	 */
    private List<Instrument> instruments;

    /**
     * initialise une liste vide
     */
    public Inventory() {
        instruments = new LinkedList<Instrument>();
    }

    /**
     * Affiche les instruments avec les m�mes sp�cifications
     * ou rien s'il n'y en a pas
     * @param g un instrument
     */
    public void display(Instrument g) {
        List<Instrument> matchingGuitars = this.search(g.getInstrumentSpec());
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator<Instrument> i = matchingGuitars.iterator(); i.hasNext();) {
            	Instrument guitar = i.next();
            	InstrumentSpec gs = guitar.getInstrumentSpec();
                System.out.println("  We have a " + gs.getProperties().get("Builder") + " " + gs.getProperties().get("Model") + " " + gs.getProperties().get("Type") + " guitar:\n     " + gs.getProperties().get("BackWood") + " back and sides,\n     " + gs.getProperties().get("TopWood") + " top.\n  You can have it for only $" + guitar.getPrice() + "!\n  ----");
            }
        }
        else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }
    
    /**
     * Ajoute un instrument � l'inventaire
     * @param serialNumber num�ro de s�rie
     * @param price prix de l'instrument
     * @param instrSpec sp�cifications de l'instrument
     */
    public void addInstrument(String serialNumber, double price, InstrumentSpec instrSpec) {
        instruments.add(new Instrument(serialNumber, price, instrSpec));
    }

    /**
     * Renvoie l'instrument avec le m�me num�ro de s�rie donn� en param�tre
     * @param serialNumber num�ro de s�rie
     * @return un intrument
     */
    public Instrument getInstrument(String serialNumber) {
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext();) {
            Instrument instr = i.next();
            if (instr.getSerialNumber().equals(serialNumber)) {
                return instr;
            }
        }
        return null;
    }

    /*
    public List<Instrument> search(InstrumentSpec searchInstr) {
        List<Instrument> matchingInstruments = new LinkedList<Instrument>();
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext();) {
            Instrument instrument = i.next();
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (!searchInstr.matches(instrument.getInstrumentSpec()))
                continue;
            matchingInstruments.add(instrument);
        }
        return matchingInstruments;
    }
    */
    
    /**
     * Renvoie une liste d'instruments dont les sp�cifications sont les m�mes
     * que celles pass�es en param�tres
     * @param searchSpec les sp�cifications
     * @return une liste d'instruments
     */
    public List<Instrument> search(InstrumentSpec searchSpec) {
    	List<Instrument> matchingList = new LinkedList<Instrument>();
    	for (Iterator<Instrument> i = instruments.iterator();i.hasNext();) {
    		Instrument instrument = i.next();
    		if (instrument.getInstrumentSpec().matches(searchSpec))
    			matchingList.add(instrument);
    	}
    	return matchingList;
    }
    
    
}
