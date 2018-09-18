package tp3;

public abstract class Instrument {

    private String serialNumber;
    private double price;
    private InstrumentSpec instrSpec;

    public Instrument(String serialNumber, double price, InstrumentSpec instrSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrSpec = instrSpec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public InstrumentSpec getInstrumentSpec() {
        return instrSpec;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setGuitarSpec(InstrumentSpec instrSpec) {
        this.instrSpec = instrSpec;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
}
