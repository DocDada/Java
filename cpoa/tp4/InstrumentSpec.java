package tp4;

import java.util.Iterator;
import java.util.Map;

/**
 * Les spécifications d'un instrument; diffèrent en fonction du type de l'instrument
 * @author prepain
 *
 */
public class InstrumentSpec {
	/**
	 * une map contenant les spécifications, avec en clé le nom de la spécification
	 */
	private Map<String, Object> properties;
	
	/**
	 * Renvoie un booléen indiquant si this est équivalent aux spécifiactions passées en paramètres
	 * @param otherSpec des spécifications
	 * @return un booléen
	 */
	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator<String> i = otherSpec.getProperties().keySet().iterator(); i
				.hasNext();) {
			String k = i.next();
			if (this.getProperties().containsKey(k)) {
				if (this.getProperties().get(k) == otherSpec.getProperties()
						.get(k)) {
					continue;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * Initialise des spécfications avec une map
	 * @param instrSpec une map de spécifications
	 */
	public InstrumentSpec(Map instrSpec) {
		this.properties = instrSpec;
	}

	/**
	 * Renvoie la map contenant les spécifications
	 * @return une map de spécifications
	 */
	public Map getProperties() {
		return properties;
	}
	/**
	 * Modifie les spécifications de la map
	 * @param properties des spécifications
	 */
	public void setProperties(Map properties) {
		this.properties = properties;
	}

}
