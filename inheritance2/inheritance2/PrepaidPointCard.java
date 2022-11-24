/**
 * 
 */
package inheritance2;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class PrepaidPointCard extends PrepaidCard{
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public PrepaidPointCard(String owner, String name, int credit) {
		super(owner, name, credit);
		// TODO Auto-generated constructor stub
	}
	private int commonPoint = 0;
	
	public int getCommonPoint() {
		return this.commonPoint;
	}
	
	public boolean pay(int a) {
		boolean result = super.pay(a);
		if(result == true) {
			this.commonPoint = (int) (this.commonPoint + a*0.1);
		}
		return result;
	}
	
	public String toString() {
		return getName()+" (owner: "+getOwner()+", credit: "+getCredit()+", point: "+getCommonPoint()+")";
	}
}
