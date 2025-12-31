/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double d = 1.0;                      
    	double h = Math.sqrt(d*d - (d/2)*(d/2)); 
		sierpinski(n, 0.0, d / 2.0, d, 0.0, h, 0.0);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if(n == 0) return;							
		
		StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x1, y1, x3, y3);

		double mx12 = (x1 + x2) / 2.0;
        double my12 = (y1 + y2) / 2.0;

        double mx23 = (x2 + x3) / 2.0;
        double my23 = (y2 + y3) / 2.0;

        double mx13 = (x1 + x3) / 2.0;
        double my13 = (y1 + y3) / 2.0;

		StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.line(mx12, my12, mx23, my23);
        StdDraw.line(mx23, my23, mx13, my13);
        StdDraw.line(mx13, my13, mx12, my12);

		StdDraw.setPenColor(StdDraw.BLACK);

		sierpinski(n - 1, x1, mx12, mx13, y1, my12, my13);
        sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23);
        sierpinski(n - 1, mx13, mx23, x3, my13, my23, y3);
	}
}
