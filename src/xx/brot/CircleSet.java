package xx.brot;

public class CircleSet implements SetFn {

	@Override
	public int includes(double x, double y) {
		return (x * x + y * y) <= 4 ? 255 : 0;
	}



}
