package xx.brot.factories;

import java.util.Properties;

import xx.brot.RandomSet;
import xx.brot.SetFn;

public class RandomFactory implements SetFnFactory {

	@Override
	public String getName() {
		return "Random";
	}

	@Override
	public Properties createDefaultCreateProperties() {
		return new Properties();
	}

	@Override
	public SetFn createSetFn() {
		return new RandomSet();
	}

	@Override
	public SetFn createSetFn(Properties createProperties) {
		return new RandomSet();
	}

}
