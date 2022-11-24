/**
 * 
 */
package graph4;

/**
 * @author b1021164 下村蒔里萌
 *
 */
import java.util.ArrayList;

public class Main3 {
 
    public static void main(String[] args) {
        int[][] paths = {
                {0,1,1},    {0,4,10},   {0,8,14},   {0,11,10},
                {0,12,5},   {0,14,7},   {0,16,14},  {0,19,8},
                {0,20,15},  {0,21,8},   {0,24,20},  {0,25,20},
                {0,27,6},   {0,37,14},  {0,38,12},  {0,39,14},
                {0,41,6},   {0,47,30},  {0,53,6},   {1,4,1},
                {1,7,5},    {1,8,5},    {1,11,11},  {1,12,12},
                {1,14,8},   {1,19,7},   {1,20,11},  {1,24,10},
                {1,25,5},   {1,27,5},   {1,30,6},   {1,37,14},
                {1,39,30},  {1,41,14},  {1,47,30},  {1,53,30},
                {4,7,1},    {4,11,13},  {4,12,4},   {4,14,5},
                {4,16,5},   {4,19,7},   {4,20,15},  {4,21,10},
                {4,24,15},  {4,25,15},  {4,27,9},   {4,30,9},
                {4,37,10},  {4,38,9},   {4,39,15},  {4,41,30},
                {4,47,30},  {4,53,30},  {7,8,1},    {7,11,5},
                {7,12,4},   {7,16,7},   {7,19,7},   {7,20,11},
                {7,21,11},  {7,24,13},  {7,27,15},  {7,30,20},
                {7,37,11},  {7,38,10},  {7,39,20},  {7,41,30},
                {7,47,30},  {7,53,30},  {8,11,1},   {8,12,7},
                {8,14,7},   {8,16,8},   {8,19,8},   {8,20,9},
                {8,24,8},   {8,25,12},  {8,27,10},  {8,30,9},
                {8,37,14},  {8,38,15},  {8,39,20},  {8,41,10},
                {8,47,30},  {8,53,30},  {11,12,1},  {11,14,9},
                {11,16,15}, {11,19,15}, {11,20,12}, {11,21,14},
                {11,24,10}, {11,27,10}, {11,30,10}, {11,37,10},
                {11,38,20}, {11,39,20}, {11,41,30}, {11,47,30},
                {11,53,30}, {12,14,1},  {12,16,3},  {12,19,2},
                {12,20,14}, {12,21,8},  {12,24,4},  {12,25,10},
                {12,27,10}, {12,30,10}, {12,37,15}, {12,38,20},
                {12,39,14}, {12,41,20}, {12,47,15}, {12,53,20},
                {14,16,1},  {14,19,15}, {14,20,9},  {14,21,14},
                {14,24,10}, {14,25,13}, {14,27,13}, {14,37,14},
                {14,38,14}, {14,39,15}, {14,41,20}, {14,47,20},
                {14,53,12}, {16,19,1},  {16,20,9},  {16,24,9},
                {16,25,10}, {16,27,15}, {16,30,5},  {16,37,9},
                {16,38,5},  {16,39,15}, {16,41,4},  {16,47,8},
                {16,53,10}, {19,20,1},  {19,21,5},  {19,24,6},
                {19,25,12}, {19,27,15}, {19,30,10}, {19,37,14},
                {19,38,11}, {19,39,20}, {19,41,30}, {19,47,30},
                {19,53,30}, {20,21,1},  {20,24,7},  {20,25,4},
                {20,27,10}, {20,30,12}, {20,37,13}, {20,38,12},
                {20,39,14}, {20,41,20}, {20,53,20}, {21,24,1},
                {21,25,13}, {21,27,13}, {21,30,11}, {21,37,15},
                {21,38,13}, {21,39,20}, {21,41,20}, {21,47,20},
                {21,53,20}, {24,25,1},  {24,27,9},  {24,37,2},
                {24,38,15}, {24,39,6},  {24,41,8},  {24,47,10},
                {24,53,10}, {25,27,1},  {25,30,10}, {25,37,10},
                {25,38,10}, {25,39,10}, {25,41,9},  {25,47,13},
                {25,53,20}, {27,30,1},  {27,37,12}, {27,38,9},
                {27,39,10}, {27,41,14}, {27,47,20}, {27,53,20},
                {30,37,1},  {30,38,9},  {30,39,9},  {30,41,7},
                {30,47,5},  {30,53,9},  {37,38,1},  {37,39,10},
                {37,41,6},  {37,47,10}, {37,53,4},  {38,39,1},
                {38,41,10}, {38,47,9},  {38,53,14}, {39,41,1},
                {39,47,10}, {39,53,1},  {41,47,1},  {41,53,9},
                {47,53,1},
        };
        Point[] points = new Point[54];
 
        // pathsの情報をpointsに変換
        for (int[] p: paths) {
            if (points[p[0]] == null) points[p[0]] = new Point(p[0]);
            if (points[p[1]] == null) points[p[1]] = new Point(p[1]);
            points[p[0]].addPath(points[p[1]], p[2]);
        }
 
        long t1, t2;
         
        t1 = System.currentTimeMillis();
        System.out.println(points[0].timeTo(points[53], new ArrayList<>()));
        t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
        /*
        t1 = System.currentTimeMillis();
        System.out.println(points[0].lessTimeTo(points[53], new ArrayList<>(), Integer.MAX_VALUE));
        t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + " ms");
        */
    }
}

