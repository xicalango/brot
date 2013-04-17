package xx.brot;


public class RandomSet implements SetFn {
	
	@Override
	public int includes(double x, double y) {
		x*=128;
		y*=128;
		double val = (Math.sin(y) * Math.cos(x) + 2)/4;
		
		return (int)(255 * val);
	}

}
