/**
 * 
 */
package graph2;

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
	public int timeTo(Point goal) {
		int a;
		int min=Integer.MAX_VALUE;
		if(goal.id==this.id) {
			return 0;
		}
		else {
			for (Entry<Point, Integer> e: map.entrySet()) {
				Integer value=e.getValue();
				a=e.getKey().timeTo(goal);
				if(a!=Integer.MAX_VALUE)
					a+=value;
				if(min>a) {
					min=a;	
				}
			}
		}
		return min;
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