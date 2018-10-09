package tp4;

import java.util.Iterator;
import java.util.Map;

/**
 * Les sp�cifications d'un instrument; diff�rent en fonction du type de l'instrument
 * @author prepain
 *
 */
public class InstrumentSpec {
	/**
	 * une map contenant les sp�cifications, avec en cl� le nom de la sp�cification
	 */
	private Map<String, Object> properties;
	
	/**
	 * Renvoie un bool�en indiquant si this est �quivalent aux sp�cifiactions pass�es en param�tres
	 * @param otherSpec des sp�cifications
	 * @return un bool�en
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
	 * Initialise des sp�cfications avec une map
	 * @param instrSpec une map de sp�cifications
	 */
	public InstrumentSpec(Map instrSpec) {
		this.properties = instrSpec;
	}

	/**
	 * Renvoie la map contenant les sp�cifications
	 * @return une map de sp�cifications
	 */
	public Map getProperties() {
		return properties;
	}
	/**
	 * Modifie les sp�cifications de la map
	 * @param properties des sp�cifications
	 */
	public void setProperties(Map properties) {
		this.properties = properties;
	}

}
