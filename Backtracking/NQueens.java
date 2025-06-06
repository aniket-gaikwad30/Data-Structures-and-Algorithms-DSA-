
public class NQueens {

    public static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;
        // up
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == '\u2655') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == '\u2655') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '\u2655') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]){
        System.out.println("----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();   
            
        }
    }

    public static void nQueens(char board[][], int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
          if(isSafe(board, row, i)){
              board[row][i] = '\u2655';
              nQueens(board, row + 1);
              board[row][i] = '\u25A1';
          }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char [n][n];

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                board[i][j] = '\u25A1';
            }
            
        }
         nQueens(board, 0);
    }

}
