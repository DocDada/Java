package tp2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void display(Guitar g) {
        List matchingGuitars = this.search(g);
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                GuitarSpec gs = guitar.getGuitarSpec();
                System.out.println("  We have a " + gs.getBuilder() + " " + gs.getModel() + " " + gs.getType() + " guitar:\n     " + gs.getBackWood() + " back and sides,\n     " + gs.getTopWood() + " top.\n  You can have it for only $" + guitar.getPrice() + "!\n  ----");
            }
        }
        else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, new GuitarSpec(builder, model, type, backWood, topWood));
        guitars.add(guitar);
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

    public List search(Guitar searchGuitar) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (searchGuitar.getGuitarSpec().compareTo(guitar.getGuitarSpec()) != 0)
                continue;
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
