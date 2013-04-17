package xx.brot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import xx.brot.factories.SetFnFactory;
import xx.brot.factories.SetFnFactoryManager;

public class MainFrame extends JFrame {

	private BrotPanel brotPanel;
	private SetFnFactoryManager factoryManager;
	private SetFnFactory currentSetFn;
	
	private class SetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			changeDrawSet(e.getActionCommand());
		}
		
	}
	
	public MainFrame(SetFnFactoryManager factoryManager) {
		this.factoryManager = factoryManager;
		
		currentSetFn = factoryManager.getRandomFactory();		
		
		brotPanel = new BrotPanel(currentSetFn.createSetFn());
		
		add(brotPanel);
		
		setupMenu();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
	}

	public void changeDrawSet(String actionCommand) {
		currentSetFn = factoryManager.getFactory(actionCommand);
		brotPanel.setToDrawSet(currentSetFn.createSetFn());
	}

	private void setupMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");

		JMenuItem quitMenuItem = new JMenuItem("Quit");
		quitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		fileMenu.add(quitMenuItem);
		menuBar.add(fileMenu);
		
		
		JMenu setsMenu = new JMenu("Sets");
		
		for( SetFnFactory factory : factoryManager.getAllFactories() ) {
			JMenuItem menuItem = new JMenuItem(factory.getName());
			menuItem.addActionListener(new SetActionListener());
			setsMenu.add(menuItem);
		}
		
		menuBar.add(setsMenu);
		
		
		
		setJMenuBar(menuBar);
	}
	
}
