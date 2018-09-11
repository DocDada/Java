package tp2;

public class GuitarSpec {

    private String model;
    private Builder builder;
    private Type type;
    private Wood backWood, topWood;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }
    
    public int compareTo(GuitarSpec g) {
        if (builder != g.builder && type != g.type && backWood != g.backWood && topWood != g.topWood)
            return -1;
        String model = g.getModel().toLowerCase();
        if ((model != null) && (!model.equals("")) && (!model.equals(this.model.toLowerCase())))
            return -1;
        return 0;
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
