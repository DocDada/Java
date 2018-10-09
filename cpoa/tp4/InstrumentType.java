package tp4;

/**
 * Désigne le type d'un instrument
 * @author prepain
 *
 */
public enum InstrumentType {
	GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN;

	/**
	 * Renvoie un string du type de l'instrument
	 */
	public String toString() {
		switch (this) {
		case GUITAR:
			return "Guitar";
		case BANJO:
			return "Banjo";
		case DOBRO:
			return "Dobro";
		case FIDDLE:
			return "Fiddle";
		case BASS:
			return "Bass";
		case MANDOLIN:
			return "Mandolin";
		default:
			return "Unspecified";
		}

	}
}
