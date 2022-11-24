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
		for (int i = 0; i < 100; i++) { // 100種類試す
			int n = (int)(Math.random() * Integer.MAX_VALUE); // int型のランダム値
			System.out.print(n);
			System.out.print("=>");
			double cbrt = calcCBRoot(n); // 立方根を計算
			System.out.print(cbrt); // 計算結果を表示
			System.out.print("=>");
			System.out.println(cbrt*cbrt*cbrt); // 三乗した値を表示
		}
	}
	
	public static double calcCBRoot(int s){
		if(s>0) {
			double x0,x1,x2;
			x0=1.0; x2=100.0;
			double epsilon=1e-10;
			while(Math.abs(x2-x0) > epsilon) {
				x1=(2*x0+s/(x0*x0))/3.0;
				x2=x0;
				x0=x1;
			}
			return x0;
		}

		else {
			return 0.0;
		}
	}
}
