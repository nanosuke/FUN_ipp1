/**
 * 
 */
package medals1;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class Ranking {
	final int NUM_OF_COUNTRIES = 1000;
    Country[] countries;
    int next;
  
    public Ranking() {
    	countries = new Country[NUM_OF_COUNTRIES];
        next = 0;
    }
  
    /**
     * 指定された国が配列の何番に登録されているか探し、その添え字を返す
     * @param name 国(3文字のIOCコード)
     * @return countryNameがcountryの何番に格納されているか、なければ-1
     */
    public int indexOfCountry(String name) {
        for (int i = next - 1; i >= 0; i--) {
            // i番目の国名がcountryNameと同じ文字列ならば i を返す
            if (countries[i].getName().equals(name)) return i;
        }
        return -1; // 見つからなければ -1 を返す
    }
  
    /**
     * IOCコードで指定された国に指定された色のメダルを1つ追加
     * @param name 国(3文字のIOCコード)
     * @param color メダルの色
     */
    public void addMedal(Color color, String name) {
        // countryNameが配列の何番目に格納されているか探す
        int index = indexOfCountry(name);
        if (index < 0) { // 見つからなかった場合は新たに格納し、nextを増やす
            countries[next] = new Country(name);
            index = next;
            next ++;
        }
        // 色に対応するメダルの数を増やす
        countries[index].add(color);
    }
  
    public void sortResults() {
        
    }
  
    public void printResults() {
        // 集計結果を表示
        for (int i = 0; i < countries.length && countries[i] != null; i++) {
            System.out.println(countries[i].toString());
        }
    }
}
