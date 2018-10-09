package tp4;

import java.util.HashMap;
import java.util.Map;

/**
 * Le main pour faire des tests, initialiser un inventaire
 * @author prepain
 *
 */
public class ClientInstrument {

	/**
	 * Le main
	 * @param args
	 */
    public static void main(String[] args) {
        // Set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("IntrumentType", InstrumentType.GUITAR);
        map.put("Builder", Builder.COLLINGS);
        map.put("Model", "CJ");
        map.put("numString", 3);
        map.put("Type", Type.ACOUSTIC);
        map.put("TopWood", Wood.INDIAN_ROSEWOOD);
        map.put("BackWood", Wood.SITKA);
        Instrument whatErinLikes = new Instrument("11277", 3999.95, new InstrumentSpec(map));
        inventory.display(whatErinLikes);
    }

    /**
     * Initialise un inventaire
     * @param inventory un inventaire
     */
    public static void initializeInventory(Inventory inventory) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("IntrumentType", InstrumentType.GUITAR);
        map.put("Builder", Builder.COLLINGS);
        map.put("Model", "CJ");
        map.put("numString", 3);
        map.put("Type", Type.ACOUSTIC);
        map.put("TopWood", Wood.INDIAN_ROSEWOOD);
        map.put("BackWood", Wood.SITKA);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(map));
        /*inventory.addInstrument("11277", 3999.95, new InstrumentSpec(InstrumentType.GUITAR, Builder.COLLINGS, "CJ", 3, Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA));
        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 5, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95, new GuitarSpec(Builder.FENDER, "Stratocastor", 7, Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("122784", 5495.95, new GuitarSpec(Builder.MARTIN, "D-18", 4, Type.ACOUSTIC, Wood.MAHOGANY, Wood.ADIRONDACK));
        inventory.addInstrument("76531", 6295.95, new GuitarSpec(Builder.MARTIN, "OM-28", 4, Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("70108276", 2295.95, new GuitarSpec(Builder.GIBSON, "Les Paul", 4, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("82765501", 1890.95, new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", 5, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("77023", 6275.95, new GuitarSpec(Builder.MARTIN, "D-28", 8, Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("1092", 12995.95, new GuitarSpec(Builder.OLSON, "SJ", 5, Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
        inventory.addInstrument("566-62", 8999.95, new GuitarSpec(Builder.RYAN, "Cathedral", 4, Type.ACOUSTIC, Wood.COCOBOLO, Wood.CEDAR));
        inventory.addInstrument("6 29584", 2100.95, new GuitarSpec(Builder.PRS, "Dave Navarro Signature", 3, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE));

        inventory.addInstrument("9019920", 5495.99, new MandolinSpec(Builder.PRS, "DRSM-008 E", Style.F, Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE));
        inventory.addInstrument("7819920", 5400.99, new MandolinSpec(Builder.GIBSON, "F-5G", Style.A, Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE));*/
    }
}
