/**
 * 
 */
package graph4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class Point {
	// TODO インスタンス変数(フィールド)は必要に応じて宣言
	HashMap<Point, Integer> map; // 次の地点への経路を格納するmap
	private int id; // 地点id



	/**
	 * コンストラクタ
	 * @param id 地点id
	 */
	public Point(int id) {
		map=new HashMap<>();
		this.id=id;
	}

	/**
	 * 地点idのゲッターメソッド
	 * @return 地点id
	 */
	public int getId() {
		return id; 
	}

	/**
	 * 地点pへの経路を追加
	 * @param p 行き先
	 * @param t 移動時間
	 */
	public void addPath(Point p, int t) {
		map.put(p,t);
	}

	/**
	 * 地点goalへの移動時間を返す
	 * @param goal 行き先
	 * @return 移動時間
	 */
	public int timeTo(Point goal, ArrayList<Point> list) {
		int a;
		int min=Integer.MAX_VALUE;
		list.add(this);
		if(goal.id==this.id) {
			System.out.println ( list );
			list.remove(list.size()-1); // list の末尾要素を削除
			return 0;
		} else {
			for (Entry<Point, Integer> e: map.entrySet()) {
				Integer value=e.getValue();
				a=e.getKey().timeTo(goal, list);
				if(a!=Integer.MAX_VALUE)
					a+=value;
				if(min>a) {
					min=a;	
				}
			}
		}
		list.remove(list.size()-1); // list の末尾要素を削除
		return min;
	}
	
	public int lessTimeTo(Point goal, ArrayList<Point> list, int cut) {
		int a;
		int max=Integer.MAX_VALUE;
		list.add(this);
		if(goal.id==this.id) {
			System.out.println ( list );
			list.remove(list.size()-1); // list の末尾要素を削除
			return 0;
		} else if (map.size()!=0) { // mapがあるとき
			int b=cut;
			for(Entry<Point, Integer> e: map.entrySet()) {
				Integer value=e.getValue(); // 次の地点までの距離
				if(value<b) { // 移動距離が第三引数で指定された時間を超える場合は探索を省略する
					a=e.getKey().lessTimeTo(goal, list, b-value);
					if(a>=max){
						value=max;
					} else {
						value+=a;
						b=value; // 更新する
					}
					
					if(value<cut) {
						cut=value;
					}
				}
			}
			list.remove(list.size()-1); // list の末尾要素を削除
			return cut; // 最小値を求めた結果、第三引数で指定された時間の方が小さければ、その値を返す
		} else {
			list.remove(list.size()-1); // list の末尾要素を削除
			return max;
		}
	}
	
	/*
	 * @return idを文字列化したもの
	 */
	public String toString() {
		return String.valueOf(id);
	}
	public void pathTo(Point x,ArrayList<Point> list) {
		list.add(this);

		if(x.id==this.id) {
			System.out.println(list);
		}
		else {
			for (Entry<Point, Integer> e: map.entrySet()) {
				e.getKey().pathTo(x,list);

			}

		}
		list.remove(list.size()-1);
	}
}