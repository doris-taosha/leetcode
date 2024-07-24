package top150;

/**
 * 73. 设置矩阵零点
 * 给定一个m x n整数矩阵matrix，如果一个元素为0，则将其整个行和列设置为0。
 * 一定要做到位。
 *
 *
 * 示例 1：
 输入：矩阵 = [[1,1,1],[1,0,1],[1,1,1]]
 输出： [[1,0,1],[0,0,0],[1,0,1]]

 示例 2：
 输入：矩阵 = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 输出： [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 */

public class D4_73_setZeroes {



    //不额外使用空间，用原数组的第一行 第一列存储
    //时间 O(m) O(1)

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        for(int i = 0; i < m; i++){
            //记录第0列是否有元素为0，有的话后面要特殊处理
            if(matrix[i][0] == 0) isCol0 = true;
        }

        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0) isRow0 = true;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){ //记录为0的元素，将对应行，对应列的第一个元素置0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] =0;
                }
            }
        }
        if(isRow0){ //初始矩阵第0行存在元素为0
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(isCol0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }



    }
    public void setZeroes11(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;
        for(int col = 0; col < n; col++){
            if(matrix[0][col] == 0)  isRow0 = true;  //记录第0行是否有元素0
        }

        for(int row = 0; row < m; row++){
            if(matrix[row][0] == 0) isCol0 = true; //记录第0列是否有元素0
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    //(1,1) 到(m,n) 如有元素为0，就把[i][0]和[0][j]置于0
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }

        if(isRow0){
            //单独处理第0行，如果原始的第0行就存在0，就是第0行置0
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(isCol0){
            //单独处理第0列，如果原始的第0列就存在0，就是第0列置0
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }

    }


        // 时间 O(m) O(m + n)
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows[i] || cols[j]) matrix[i][j] = 0;
            }
        }



    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        //先遍历数组 记录下出现0的位置
        int[] rows = new int[m];  //总共m行，每个元素代表某一行是否有0
        int[] cols = new int[n];  //总共n列，每个元素代表某一列是否有0
        for(int row = 0; row < m; row ++){
            for(int col = 0; col < n; col ++){
                if(matrix[row][col] == 0){
                    rows[row] = 1;
                    cols[col] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    //当前位置的行或者是列 存在元素为0
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
