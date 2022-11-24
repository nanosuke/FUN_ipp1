/**
 * 
 */
package inheritance2;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class PrepaidCard implements Comparable{
	private String owner;
	private int credit;
	private String name;
	
	/*コンストラクタ*/
	public PrepaidCard(String x) {
		this.owner = x;
		this.credit = 0;
		this.name="";
	}
	public PrepaidCard(String y, int z) {
		this.owner = y;
		this.credit = z;
		this.name="";
	}
	public PrepaidCard(String x, String y, int z){
		this.owner=x;
		this.name=y;
		this.credit=z;
	}
	
	@Override
	public int compareTo(Object o) {
	    PrepaidCard c = (PrepaidCard)o;
	    return Integer.valueOf(this.credit).compareTo(Integer.valueOf(c.credit));
	}
	
	/*メソッド　ゲッター、セッター*/
	public String getOwner() {
		return owner;
	}
	public void setOwner(String x) {
		this.owner=x;
	}
	public int getCredit() {
		return credit;
	}
	public String getName() {
		return name;
	}
	
	/*インスタンスメソッドtoString*/
	public String toString() {
		return name+" (owner: "+owner+", credit: "+credit+")";
	}
	
	/*インスタンスメソッドcharge*/
	public int charge(int a) {
		if(a<0) {
			return credit;
		} else {
			credit=credit+a;
			return credit;
		}
	}
	
	/*インスタンスメソッドpay*/
	public boolean pay(int b) {
		if(b<0) {
			return false;
		}
		if (b<=credit) {
			credit=credit-b;
			return true;
		}
		if (credit<b) {
			return false;
		}
		return false;
	}
	
	/*インスタンスメソッドtransfer*/
	public void transfer(PrepaidCard c) {
		if(c.owner.equals(owner)==false) {
			c.charge(credit);
			pay(credit);
		}
	}
	
	/*クラスメソッドtransfer*/
	public static void transfer(PrepaidCard i,PrepaidCard j) {
		if(i.owner.equals(j.owner)==false) {
			j.charge(i.credit);
			i.pay(i.credit);
		}
	}
	
	public static boolean transfer(PrepaidCard k,PrepaidCard l,int m) {
		if(k.owner.equals(l.owner)==true) {
			return false;
		}
		if(k.owner.equals(l.owner)==false) {
			if(m<0 || k.credit<m) {
				return false;
			} 
			if(m>=0 && k.credit>=m){
				k.pay(m);
				l.charge(m);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
	    PrepaidCard [] cards = new PrepaidCard[5];
	    cards[0] = new PrepaidCard("Taro Mirai", "nimoca", 100);
	    cards[1] = new PrepaidCard("Taro Mirai", "Suica", 200);
	    cards[2] = new PrepaidCard("Taro Mirai", "PiTaPa", 300);
	    cards[3] = new PrepaidCard("Taro Mirai", "SAPICA", 400);
	    cards[4] = new PrepaidCard("Hana Mirai", "nimoca", 250);
	 
	    Arrays.sort(cards);
	    for (int i = 0; i < 5; i++) {
	        System.out.println("Card Info.:: " + cards[i].toString());
	    }
	}
}
