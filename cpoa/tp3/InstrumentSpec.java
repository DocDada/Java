package tp3;

public abstract class InstrumentSpec {
    private String model;
    private Builder builder;
    private Type type;
    private Wood backWood, topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matches(InstrumentSpec g) {
        if (builder != g.builder && type != g.type && backWood != g.backWood && topWood != g.topWood)
            return false;
        String model = g.getModel().toLowerCase();
        if ((model != null) && (!model.equals("")) && (!model.equals(this.model.toLowerCase())))
            return false;
        return true;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}
