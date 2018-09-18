package tp3;

public class MandolinSpec extends InstrumentSpec {

    private Style style;

    public MandolinSpec(Builder builder, String model, Style style, Type type, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public boolean matches(MandolinSpec m) {
        if (super.matches(m)) {
            if (this.style == m.style) {
                return true;
            }
        }
        return false;
    }
}
