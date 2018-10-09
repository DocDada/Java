package tp4;

/**
 * Un instrument caract�ris� par son num�ro de s�rie, son prix et ses sp�cifications
 * @author prepain
 *
 */
public class Instrument {

	/**
	 * Num�ro de s�rie
	 */
	private String serialNumber;
	
	/**
	 * Prix d'un instrument
	 */
	private double price;
	
	/**
	 * Caract�ristiques d'un instrument
	 */
	private InstrumentSpec instrumentSpec;

	/**
	 * Initialise un instrument
	 * @param serialNumber num�ro de s�rie
	 * @param price prix
	 * @param instrumentSpec sp�cifications
	 */
	public Instrument(String serialNumber, double price,
			InstrumentSpec instrumentSpec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.instrumentSpec = instrumentSpec;
	}

	/**
	 * Renvoie le num�ro de s�rie
	 * @return le num�ro de s�rie
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
	 * Renvoie les sp�cifications
	 * @return les sp�cifications
	 */
	public InstrumentSpec getInstrumentSpec() {
		return instrumentSpec;
	}

	/**
	 * Modifie le num�ro de s�rie
	 * @param serialNumber
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Modifie les sp�cifications
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
