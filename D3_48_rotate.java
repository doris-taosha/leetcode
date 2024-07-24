package top150;

/**
 * 48.旋转图像
 * 给定一个n x n 的 2Dmatrix图像，将图像旋转90度（顺时针）。
 *
 * 您必须就地旋转图像，这意味着您必须直接修改输入的 2D 矩阵。请勿分配另一个 2D 矩阵并进行旋转。
 */


public class D3_48_rotate {
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(matrix);

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int left = 0, right = n - 1;
        while(left < right){
            for(int i = 0; i < n; i++){
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
            }
            left++;
            right--;
        }
    }

}
