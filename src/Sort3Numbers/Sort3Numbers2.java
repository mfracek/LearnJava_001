/**
 * 
 */
package Sort3Numbers;

/**
 * @author mirek F
 *
 */
public class Sort3Numbers2 {
	static int a = 26;
	static int b = 7;
	static int c = -3;
	
	static int ax, bx, cx;

	/**
	 * @author mirek
	 * Returns lower digit from given two
	 */
	static int getLower(int x, int y) {
		if (x < y) {
			return x;
		}			
		else {
			return y;
		}
	  }

	/**
	 * @author mirek
	 * Returns greater from given two
	 */
	static int getGreater(int x, int y) {
		if (x > y) {
			return x;
		}			
		else {
			return y;
		}
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ax = getLower(a, getLower(b ,c));
		cx = getGreater(a, getGreater(b ,c));
		bx = a+b+c-ax-cx;
		System.out.print("To jest:" + ax + " " + bx + " " + cx );

	}

}
