package top150;

import java.util.Arrays;

/**
 *
 452. 爆破气球所需的最少箭数

 示例 1：

 输入： points = [[10,16],[2,8],[1,6],[7,12]]
 输出： 2
 解释：气球可以被 2 支箭刺破：
 - 向 x = 6 射一支箭，戳破气球 [2,8] 和 [1,6]。
 - 向 x = 11 射一支箭，戳破气球 [10,16] 和 [7,12]。
 示例 2：

 输入： points = [[1,2],[3,4],[5,6],[7,8]]
 输出： 4
 解释：每个气球需要射出一支箭，总共需要 4 支箭。
 示例 3：

 输入： points = [[1,2],[2,3],[3,4],[4,5]]
 输出： 2
 解释：气球可以被 2 支箭刺破：
 - 向 x = 2 射一支箭，戳破气球 [1,2] 和 [2,3]。
 - 向 x = 4 射一支箭，戳破气球 [3,4] 和 [4,5]。

 */

public class F4_452_findMinArrowShots {


    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
        int[][] pp = {{1,2},{2,4},{2,6},{7,8}};
        System.out.println(findMinArrowShots(pp));
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0 || points.length == 1) return points.length;

        //按照尾坐标排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int end = points[0][1];
        int count = 1;

        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

}
