package xx.brot;

public final class NumberUtils {

	private NumberUtils() {}
	
	public static double interpolate( double from, double fromIntervalStart, double fromIntervalEnd, double destIntervalStart, double destIntervalEnd ) {
		
		double fromWidth = fromIntervalEnd - fromIntervalStart;
		double destWidth = destIntervalEnd - destIntervalStart;
		
		double alignedFrom = from - fromIntervalStart;
		
		return destIntervalStart +  (destWidth / fromWidth) * alignedFrom; 
	}
	
}
