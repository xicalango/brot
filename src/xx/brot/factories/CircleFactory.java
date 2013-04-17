package xx.brot.factories;

import java.util.Properties;

import xx.brot.CircleSet;
import xx.brot.SetFn;

public class CircleFactory implements SetFnFactory {

	@Override
	public String getName() {
		return "Circle";
	}

	@Override
	public Properties createDefaultCreateProperties() {
		Properties p = new Properties();
		p.setProperty("radius", "2");
		return p;
	}

	@Override
	public SetFn createSetFn() {
		return new CircleSet(2);
	}

	@Override
	public SetFn createSetFn(Properties createProperties) {
		return new CircleSet(Double.valueOf(createProperties.getProperty("radius", "2")));
	}

}
