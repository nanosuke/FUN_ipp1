/**
 * 
 */
package inheritance2;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class PrepaidPointCardABC extends PrepaidPointCard{

	/**
	 * @param owner
	 * @param name
	 * @param credit
	 */
	public PrepaidPointCardABC(String owner, String name, int credit) {
		super(owner, name, credit);
		// TODO Auto-generated constructor stub
	}
	private int abcPoint = 0;
	
	public int getAbcPoint() {
		return this.abcPoint;
	}
	
	public boolean pay(int a) {
		boolean result = super.pay(a);
		if(result == true) {
			abcPoint = abcPoint + 1;
		}
		return result;
	}
	
	public String toString() {
		return getName()+" (owner: "+getOwner()+", credit: "+getCredit()+", point: "+getCommonPoint()+", ABC point: "+getAbcPoint()+")";
	}
}
