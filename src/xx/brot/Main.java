package xx.brot;

import xx.brot.factories.BrotFactory;
import xx.brot.factories.CircleFactory;
import xx.brot.factories.RandomFactory;
import xx.brot.factories.SetFnFactoryManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetFnFactoryManager setFnFactoryManager = new SetFnFactoryManager();
		setFnFactoryManager.addSetFn(new BrotFactory());
		setFnFactoryManager.addSetFn(new CircleFactory());
		setFnFactoryManager.addSetFn(new RandomFactory());
		
		MainFrame mf = new MainFrame(setFnFactoryManager);

		mf.setVisible(true);
		
		
	}

}
