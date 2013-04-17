package xx.brot.factories;

import java.util.Properties;

import xx.brot.SetFn;

public interface SetFnFactory {
	String getName();
	Properties createDefaultCreateProperties();
	
	SetFn createSetFn();
	SetFn createSetFn(Properties createProperties);
}
