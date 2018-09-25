package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tp3.Builder;
import tp3.Guitar;
import tp3.GuitarSpec;
import tp3.Instrument;
import tp3.Inventory;
import tp3.Type;
import tp3.Wood;

public class TestInventory {

    Inventory inventory;

    public TestInventory() {
        inventory = new Inventory();
        tp3.FindGuitarTester.initializeInventory(inventory);
    }

    @Test
    public void testInventory() {
        assertTrue(inventory != null);
    }

    @Test
    public void testDisplay() {
        Instrument a = new Guitar("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        inventory.display(a);
    }

    @Test
    public void testAddInstrument() {
        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        assertEquals(inventory.getInstrument("V95693").getSerialNumber(),"V95693");
    }

    @Test
    public void testGetInstrument() {
        assertEquals("11277", inventory.getInstrument("11277").getSerialNumber());
        assertEquals(new Double(3999.95), (Double) inventory.getInstrument("11277").getPrice());
    }

    @Test
    public void testSearch() {
        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        List<Instrument> matchingGuitars = inventory.search(new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        //assertTrue(matchingGuitars.contains(new Guitar("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER))));
        assertTrue(matchingGuitars.size()==3);
    }

}
