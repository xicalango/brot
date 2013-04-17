package xx.brot.factories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SetFnFactoryManager {

	private Map<String,SetFnFactory> factories = new HashMap<>();
	
	public void addSetFn(SetFnFactory factory) {
		factories.put(factory.getName(), factory);
	}

	public SetFnFactory getFactory(String name) {
		return factories.get(name);
	}
	
	public SetFnFactory getRandomFactory() {
		return factories.values().iterator().next();
	}
	
	public Collection<SetFnFactory> getAllFactories() {
		return factories.values();
	}
	
}
