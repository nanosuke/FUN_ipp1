/**
 * 
 */
package exercise1;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class CubicRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calcCBRoot(2));
	}
	
	
	public static double calcCBRoot(int s){
		double x0,x1;
		x0=1.0;
		for(int i=0; i<10; i++) {
			x1=(2*x0+s/(x0*x0))/3;
			System.out.println(x1);
			x0=x1;
		}
		return x0;
	}
}
