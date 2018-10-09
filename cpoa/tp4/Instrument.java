package tp4;

/**
 * Un instrument caractérisé par son numéro de série, son prix et ses spécifications
 * @author prepain
 *
 */
public class Instrument {

	/**
	 * Numéro de série
	 */
	private String serialNumber;
	
	/**
	 * Prix d'un instrument
	 */
	private double price;
	
	/**
	 * Caractéristiques d'un instrument
	 */
	private InstrumentSpec instrumentSpec;

	/**
	 * Initialise un instrument
	 * @param serialNumber numéro de série
	 * @param price prix
	 * @param instrumentSpec spécifications
	 */
	public Instrument(String serialNumber, double price,
			InstrumentSpec instrumentSpec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.instrumentSpec = instrumentSpec;
	}

	/**
	 * Renvoie le numéro de série
	 * @return le numéro de série
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Renvoie le prix
	 * @return le prix
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Renvoie les spécifications
	 * @return les spécifications
	 */
	public InstrumentSpec getInstrumentSpec() {
		return instrumentSpec;
	}

	/**
	 * Modifie le numéro de série
	 * @param serialNumber
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Modifie les spécifications
	 * @param instrumentSpec
	 */
	public void setInstrumentSpec(InstrumentSpec instrumentSpec) {
		this.instrumentSpec = instrumentSpec;
	}

	/**
	 * Modifie le prix
	 * @param newPrice
	 */
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
}
