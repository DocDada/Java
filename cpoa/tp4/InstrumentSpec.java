package tp4;

import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
	private Map<String, Object> properties;
	

	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator<String> i = otherSpec.getProperties().keySet().iterator(); i
				.hasNext();) {
			String k = i.next();
			if (this.getProperties().containsKey(k))
				if (this.getProperties().get(k) == otherSpec.getProperties()
						.get(k))
					continue;
			return false;
		}
		return true;
	}

	public InstrumentSpec(Map instrSpec) {
		this.properties = instrSpec;
	}

	public Map getProperties() {
		return properties;
	}

	public void setProperties(Map properties) {
		this.properties = properties;
	}

}
