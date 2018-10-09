package tp4;

/**
 * Type d'une guitare/mandoline
 * @author prepain
 *
 */
public enum Type {

	ACOUSTIC, ELECTRIC;

	/**
	 * Renvoie un string du type d'une guitare/mandoline
	 */
	public String toString() {
		switch (this) {
		case ACOUSTIC:
			return "acoustic";
		case ELECTRIC:
			return "electric";
		default:
			return "unspecified";
		}
	}
}
