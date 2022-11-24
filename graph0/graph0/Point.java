/**
 * 
 */
package graph0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b1021164 下村蒔里萌
 *
 */
public class Point {
    // TODO インスタンス変数(フィールド)は必要に応じて宣言
 
    /**
     * コンストラクタ
     * @param id 地点id
     */
	int id; // 地点id
	HashMap <Point,Integer> map; // 次の地点への経路を格納するmap
    public Point(int id) {
    	map=new HashMap<>();
    	this.id=id;
    }
 
    /**
     * 地点idのゲッターメソッド 
     * @return 地点id
     */
    public int getId() {
        return this.id;
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
        // TODO 問題文の指示に沿って実装
        int x=Integer.MAX_VALUE;
        if(goal.id==this.id) {
            return 0;
        }
        for (Map.Entry<Point, Integer> e: map.entrySet()){
            if(goal.id==e.getKey().id) {
                x=e.getValue();
                break;
            }
            if(e.getKey().id!=goal.id) {
                continue;
            }
        
        }
        return x;
    }
 
    /*
     * @return idを文字列化したもの
     */
    public String toString() {
        return String.valueOf(getId());
    }
}
