package tp3;

public class GuitarSpec extends InstrumentSpec {

    private int numString;

    public GuitarSpec(Builder builder, String model, int numString, Type type, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.numString = numString;
    }

    public boolean matches(GuitarSpec g) {
        if (super.matches(g)) {
            if (this.numString == g.numString) {
                return true;
            }
        }
        return false;
    }

}
