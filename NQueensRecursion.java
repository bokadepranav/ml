public class NQueensRecursion {
    public static void NQueens(char board[][] , int row) {
        if(row==board.length) {
            printBoard(board);
            count++;
            return;
        }
        for(int j=0 ; j<board.length ; j++) {
            if(isSafe(board , row , j)) {
                board[row][j] = 'Q';
                NQueens(board , row+1);//function call
                board[row][j] = 'x';
            }
        }
    }
    public static boolean isSafe(char board[][] , int row , int col) {
        for(int i=row-1 ; i>=0 ; i--) {//checking vertically above
            if(board[i][col]=='Q') {
                return false;
            }
        }
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i--, j--) { // checking diagonally up-left
            if(board[i][j]=='Q') {
                return false;
            }            
        }
        for(int i=row-1 , j=col+1 ; i>=0 && j<board.length ; i-- , j++) {// checking diagonally up-right
            if(board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]) {
        System.out.println("----------Chess Board----------");
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board.length ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void main(String args[]) {
        int n=4;
        char board[][] = new char[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                board[i][j] = 'x';
            }
        }
        NQueens(board , 0);
        System.out.println("total number of ways = " + count);
    }
}
