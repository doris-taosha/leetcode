package top150;

import java.util.*;

/**
 * 36. 有效数独
 *
 * 确定 9 x 9数独板是否有效。只有已填充的单元格才需要 根据以下规则进行验证：
 *
 * 每行必须包含无重复的数字 1-9。
 * 每列必须包含无重复的数字 1-9 。
 * 网格的九个 3 x 3子框中的每一个都必须包含无重复的数字 1-9 。
 * 笔记：
 * 数独板（部分填充）可能有效，但不一定可解。
 * 只有已填充的单元格才需要根据所提到的规则进行验证。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入： board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,["。","9","8","。","。","。","6","。"]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,["。,"6"。,"。,"。,"。,"。,"2"。,"8"。,"。]
 * ,[“。”，“。”，“。”，“4”，，“1”，，“9”，，“。”，“。”，“5”]
 * ,["。","。","。","8","。","。","7","9"]]
 * 输出： true
 * 示例 2：
 *
 * 输入： board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,["。","9","8","。","。","。","6","。"]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,["。,"6"。,"。,"。,"。,"。,"2"。,"8"。,"。]
 * ,[“。”，“。”，“。”，“4”，，“1”，，“9”，，“。”，“。”，“5”]
 * ,["。","。","。","8","。","。","7","9"]]
 * 输出： false
 * 解释：与示例 1 相同，只是左上角的5被修改为8。由于左上角 3x3 子框中有两个 8，因此它是无效的。
 */

public class D1_36_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < board.length; i++){
            if(!isValidRow(board, i)
            || !isValidCol(board, i) || !isValidBox(board, i)){
                return false;
            }
        }
        return true;
    }


    public boolean isValidRow(char[][] board, int row){
        Map<Character, Integer> rowMap = new HashMap<>();
        for(int col = 0; col < 9; col++){
            char ch = board[row][col];
            if(ch !='.'){
                 if(rowMap.containsKey(ch)) return false;
                 rowMap.put(ch, 1);
            }
        }
        return true;
    }
    public boolean isValidCol(char[][] board, int col){
        Map<Character, Integer> colMap = new HashMap<>();
        for(int row = 0; row < 9; row++){
            char ch = board[row][col];
            if(ch !='.'){
                if(colMap.containsKey(ch)) return false;
                colMap.put(ch, 1);
            }
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int box){
        Map<Character, Integer> boxMap = new HashMap<>();

        //box     = 0  1  2  3  4  5  6  7  8
        //startRow  0  0  0  3  3  3  6  6  6
        //startCol  0  3  6  0  3  6  0  3  6
        int startRow = 3 * (box / 3);
        int startCol = 3 * (box % 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char ch = board[startRow + i][startCol + j];
                if(ch != '.'){
                    if(boxMap.containsKey(ch)) return false;
                    boxMap.put(ch, 1);
                }
            }
        }
        return true;
    }






    public boolean isValidSudoku1(char[][] board) {
        Map<Character,Integer>[] rowMap = new HashMap[9];
        Map<Character,Integer>[] colMap = new HashMap[9];
        Map<Character,Integer>[] boxMap = new HashMap[9];

        for(int i = 0; i < 9; i++){
            rowMap[i] = new HashMap<>();
            colMap[i] = new HashMap<>();
            boxMap[i] = new HashMap<>();
        }
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char ch = board[row][col];
                if(ch == '.') continue;
                int box = (row / 3) * 3 + (col / 3);
                if(rowMap[row].containsKey(ch) || colMap[col].containsKey(ch) || boxMap[box].containsKey(ch)){
                    return false;
                }
                rowMap[row].put(ch, 1);
                colMap[col].put(ch, 1);
                boxMap[box].put(ch, 1);
            }
        }
        return true;


    }

}
