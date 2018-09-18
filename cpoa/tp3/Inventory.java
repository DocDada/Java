package tp3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List instruments;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void display(Instrument g) {
        List matchingGuitars = this.search(g);
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                GuitarSpec gs = (GuitarSpec) guitar.getInstrumentSpec();
                System.out.println("  We have a " + gs.getBuilder() + " " + gs.getModel() + " " + gs.getType() + " guitar:\n     " + gs.getBackWood() + " back and sides,\n     " + gs.getTopWood() + " top.\n  You can have it for only $" + guitar.getPrice() + "!\n  ----");
            }
        }
        else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrSpec) {
        Instrument instr;
        if (instrSpec instanceof GuitarSpec) {
            instr = new Guitar(serialNumber, price, instrSpec);
        }
        else if (instrSpec instanceof MandolinSpec) {
            instr = new Mandolin(serialNumber, price, instrSpec);
        }
        instruments.add(instr);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List search(Instrument searchGuitar) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (searchGuitar.getGuitarSpec().matches(guitar.getGuitarSpec()) != 0)
                continue;
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
