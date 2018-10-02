package tp4;

public class Instrument {

	private String serialNumber;
	private double price;
	private InstrumentSpec instrumentSpec;

	public Instrument(String serialNumber, double price,
			InstrumentSpec instrumentSpec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.instrumentSpec = instrumentSpec;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public InstrumentSpec getInstrumentSpec() {
		return instrumentSpec;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setGuitarSpec(InstrumentSpec instrumentSpec) {
		this.instrumentSpec = instrumentSpec;
	}

	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
}
