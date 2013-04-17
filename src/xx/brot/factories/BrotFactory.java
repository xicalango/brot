package xx.brot.factories;

import java.util.Properties;

import xx.brot.MandelbrotSet;
import xx.brot.SetFn;

public class BrotFactory implements SetFnFactory {

	@Override
	public String getName() {
		return "Brot";
	}

	@Override
	public SetFn createSetFn() {
		return new MandelbrotSet(100, 2);
	}

	@Override
	public SetFn createSetFn(Properties createProperties) {
		int maxIterations = Integer.valueOf( createProperties.getProperty("maxIterations", "1000") );
		double upperBound = Double.valueOf( createProperties.getProperty("upperBound", "1") );
		
		return new MandelbrotSet(maxIterations, upperBound);
	}

	@Override
	public Properties createDefaultCreateProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("maxIterations", "0");
		properties.setProperty("upperBound", "0");

		return properties;
	}



}
