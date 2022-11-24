/**
 * 
 */
package medals1;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class Country {
	private String name;
    private int gold, silver, bronze;
    public Country (String countryName) {
        this.name = countryName;
        this.gold = 0;
        this.silver = 0;
        this.bronze = 0;
    }
    
    public String getName() {return this.name;}
    
    public void add(Color a) {
    	if(a.equals(Color.Gold)) {
    		gold++;
    	}
    	if(a.equals(Color.Silver)) {
    		silver++;
    	}
    	if(a.equals(Color.Bronze)) {
    		bronze++;
    	}
    }
    
    public String toString(){
    	int x=gold+silver+bronze;
    	return name+"("+gold+","+silver+","+bronze+")["+x+"]";
    }
}



