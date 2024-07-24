package top150;
import java.util.*;


/**
 * 54. 螺旋矩阵
 *
 * 给定一个m x n 的 matrix，返回按螺旋顺序排列的所有元素
 *
 *
 * 示例 1：
 * 输入：矩阵 = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出： [1,2,3,6,9,8,7,4,5]
 *
 *
 * 示例 2：
 * 输入：矩阵 = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出： [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class D2_54_spiralOrder {
    public static void main(String[] args) {
        //int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int left =0, right = n-1, top = 0, bottom =m-1;
        while(left <= right && top<=bottom){

            for(int i=left; i<= right; i++){
                resultList.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<= bottom; i++){
                resultList.add(matrix[i][right]);
            }
            right--;

            if(bottom >= top){
                for(int i = right; i >= left; i--){
                    resultList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(right >= left){
                for(int i = bottom; i >= top; i--){
                    resultList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return resultList;



    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
         int m = matrix.length, n = matrix[0].length;
         int left = 0, right = n-1, top = 0, bottom = m-1;
         while(res.size() < m * n){
             for(int i = left; i <= right  && res.size() < m * n; i++){
                 res.add(matrix[top][i]);
             }
             top++;
             for(int j = top; j <= bottom && res.size() < m * n; j++){
                 res.add(matrix[j][right]);
             }
             right--;
             for(int k = right; k >= left && res.size() < m * n; k--){
                 res.add(matrix[bottom][k]);
             }
             bottom--;

             for(int p = bottom; p >= top && res.size() < m * n; p--){
                 res.add(matrix[p][left]);
             }
             left++;
         }
        return res;
    }
}
