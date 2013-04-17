package xx.brot;

import java.util.Random;

public class RandomSet implements SetFn {
	
	public RandomSet() {
		
	}
	
	@Override
	public int includes(double x, double y) {
		x*=128;
		y*=128;
		double val = (Math.sin(y) * Math.cos(x) + 2)/4;
		
		return (int)(255 * val);
	}

}
