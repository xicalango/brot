package xx.brot;

public class CircleSet implements SetFn {

	private double radius;
	
	public CircleSet(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public int includes(double x, double y) {
		return (x * x + y * y) <= radius*radius ? 255 : 0;
	}



}
