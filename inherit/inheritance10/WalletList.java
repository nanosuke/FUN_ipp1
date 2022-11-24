/**
 * 
 */
package inheritance10;

import java.util.ArrayList;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class WalletList {
	private ArrayList<Wallet> wallet;
	public WalletList() {
		
	}
	
	public void addWallet(Wallet wallet) {
		this.wallet.add(wallet);
	}
	
	public String toString() {
		String x="";
		x=x+wallet.toString();
		return x;
	}



	public static void main(String[] args) {
	    WalletList list = new WalletList();
	    list.addWallet(new Wallet("first"));
	    list.addWallet(new Wallet("second"));
	    list.addWallet(new Wallet("third"));
	    list.addWallet(new Wallet("fourth"));
	    System.out.print(list.toString());
	}
}

