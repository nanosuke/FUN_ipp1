/**
 * 
 */
package exercise3b;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class PrepaidCard {
	private String owner;
	private int credit;
	
	/*コンストラクタ*/
	public PrepaidCard(String x) {
		this.owner = x;
		this.credit = 0;
	}
	public PrepaidCard(String y, int z) {
		this.owner = y;
		this.credit = z;
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
	
	/*インスタンスメソッドtoString*/
	public String toString() {
		return "owner: "+owner+" (credit: "+credit+")";
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
		PrepaidCard c1 = new PrepaidCard ("Mirai Masaru");
		System.out.println("Card Info.:: " + c1.toString());
		// 3-2テスト用追加コード for EF class
		
				// chargeテスト1
				System.out.println("1. c1カードに100チャージして，ちゃんと100加わっているか");
				c1.charge(100);	// 操作
				System.out.println(c1.toString());
				
				// chargeテスト2 
				System.out.println("2. c1カードに-100チャージしても，残額変わらないか");
				c1.charge(-100); // 操作
				System.out.println(c1.toString());
				
				// payテスト1
				System.out.println("3. c1カードで10をpayしたら，trueが帰ってきて，残額は90になるか");
				System.out.println(c1.pay(10));	// 操作&結果プリント
				System.out.println(c1.toString());
				
				// payテスト2
				System.out.println("4. c1カードで残額を超える200をpayしようとしたら，falseが帰ってきて，残額は90から変化なしか");
				System.out.println(c1.pay(200));	// 操作&結果プリント
				System.out.println(c1.toString());
				
				// transferテスト準備1
				System.out.println("5（準備）違う所有者名のカードを作る");
				PrepaidCard c2 = new PrepaidCard("The C2 owner");
				System.out.println(c2.toString());
				
				// transferテスト準備2
				System.out.println("6（準備）同じ所有者名の　「別なカード」を作る");
				PrepaidCard c1_extra = new PrepaidCard("Mirai Masaru");
				System.out.println(c1_extra.toString());
				
				// transferテスト1
				System.out.println("7. 残額90のc1カードを，同じ所有者名のc1_extraカードにtransferしようとしても，なにもおきないか");
				c1.transfer(c1_extra);	// 操作
				System.out.println(c1.toString());
				System.out.println(c1_extra.toString());
				
				// transferテスト2
				System.out.println("8. 残額90のc1カードを，別な所有者名のc2カードにtransferすると，c1は0になりc2は90になるか．");
				c1.transfer(c2);	// 操作
				System.out.println(c1.toString());
				System.out.println(c2.toString());
		// 3-3テスト用追加コード for EF class
				// 現状c1は残額0で，c2は残額90なので，c1_extraに100入れてからテスト開始
				System.out.println("3-3テスト準備現状の金額把握");
				c1_extra.charge(100);
				System.out.println(c1.toString());
				System.out.println(c2.toString());
				System.out.println(c1_extra.toString());
					
				// クラスメソッドtransfer（作業１）テスト1
				System.out.println("3-3-1. 残高90のc2カードから残高0のc1カードにお金を移すとc1が90, c2が0になるか");
				PrepaidCard.transfer(c2, c1);	// クラスメソッドで操作
				System.out.println(c1.toString());
				System.out.println(c2.toString());
				System.out.println(c1_extra.toString());
				
				// クラスメソッドtransfer（作業１）テスト2
				System.out.println("3-3-2. 残高90になったc1カードから残高100のc1_extraカードにお金を移しても，所有者名が同じだから変化なしになるか");
				PrepaidCard.transfer(c1, c1_extra);	// クラスメソッドで操作
				System.out.println(c1.toString());
				System.out.println(c2.toString());
				System.out.println(c1_extra.toString());	
				
				// クラスメソッドtransfer(作業2)テスト1
				System.out.println("3-3-3. 残高90のc1カードから残高0のc2カードに10だけお金を移すと，c1は80, c2は10になるか");
				System.out.println(PrepaidCard.transfer(c1, c2, 10));	// クラスメソッドで操作&結果プリント
				System.out.println(c1.toString());
				System.out.println(c2.toString());
				System.out.println(c1_extra.toString());
				
				// クラスメソッドtransfer(作業2)テスト2
				System.out.println("3-3-3. 残高80のc1カードから残高10のc2カードに, c1の残高を超える100をお金を移そうとしても，変化なしになるか");
				System.out.println(PrepaidCard.transfer(c1, c2, 100));
				System.out.println(c1.toString());
				System.out.println(c2.toString());
				System.out.println(c1_extra.toString());
			
	}
}
