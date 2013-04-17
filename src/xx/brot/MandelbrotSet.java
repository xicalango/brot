package xx.brot;

public class MandelbrotSet implements SetFn {

	private int maxIterations;
	private double upperBound;
	
	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public int includes(double x, double y) {
		
		double zX = 0;
		double zY = 0;
		
		for( int i = 0; i < maxIterations; i++ ) {
			double newZX = (zX * zX) - (zY * zY) + x;
			double newZY = (2 * zX * zY) + y;
			
			double length = lengthSquared(newZX, newZY);
			
			if(length >= upperBound * upperBound) {
				return (int)(255 * (i / (double)maxIterations));
			}
			
			zX = newZX;
			zY = newZY;
		}
		
		
		return 0;
	}
	
	public MandelbrotSet(int maxIterations, double upperBound) {
		super();
		this.maxIterations = maxIterations;
		this.upperBound = upperBound;
	}

	private double lengthSquared(double x, double y) {
		return x * x + y * y;
	}


}
