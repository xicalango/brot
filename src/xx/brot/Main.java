package xx.brot;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(new BrotPanel(new MandelbrotSet(100, 2)) );
//		f.add(new BrotPanel(new CircleSet()));
		f.pack();
		
		f.setVisible(true);
		
		
	}

}
