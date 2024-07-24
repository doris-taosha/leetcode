package top150;

public class D5_289_gameOfLife {
    private int die = 2;
    private int live = 3;



    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

    public void gameOfLife11(int[][] board) {
        // we only flip the 1 to die and 0 to live
        // so when we find a die around, it must be a previous 1
        // then we can count the 1s without being affected
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int around = countLive(i,j,board);
                if (board[i][j] == 0 && around == 3)
                    board[i][j] = live;
                else if (board[i][j] == 1){
                    if (around == 2 || around ==3)
                        continue;
                    if (around < 2 || around > 3)
                        board[i][j] = die;
                }
            }
        }

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (board[i][j] == die)
                    board[i][j] = 0;
                if (board[i][j] == live)
                    board[i][j] = 1;
            }
        }

    }

    private int countLive(int i, int j,int[][] board){
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        for (int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if (x>=0 && y>=0 && x < board.length && y<board[0].length ){

                if (board[x][y] == 1 || board[x][y] == die)
                    count ++;
            }
        }

        return count;

    }
}