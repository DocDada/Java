package tp2;

public class Guitar {

    private String serialNumber;
    private double price;
    private GuitarSpec guitarSpec;

    public Guitar(String serialNumber, double price, GuitarSpec guitarSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.guitarSpec = guitarSpec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public GuitarSpec getGuitarSpec() {
        return guitarSpec;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setGuitarSpec(GuitarSpec guitarSpec) {
        this.guitarSpec = guitarSpec;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

}
