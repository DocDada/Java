package tp4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new LinkedList<Instrument>();
    }

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
    

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrSpec) {
        instruments.add(new Instrument(serialNumber, price, instrSpec));
    }

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
