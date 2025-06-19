package recursionzz;

public class Knight {

    public static void printBoard(char board[][]){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        int[][] moves = {
            {-2, -1}, {-2, +1}, // Two rows up
            {-1, -2}, {-1, +2}, // One row up
            {+1, -2}, {+1, +2}, // One row down
            {+2, -1}, {+2, +1}  // Two rows down
        };
        for(int move[]:moves){
            int newRow=row+move[0];
            int newCol=col+move[1];
            if(newRow>=0&& newRow<board.length && newCol>=0 && newCol<board.length){
                if(board[newRow][newCol]=='k'){
                    return false;
                }
            }

        }


    

       return true;

    }

    public static void nKnight(char board[][], int row){
        if(row==board.length){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BOARD<<<<<<<<<<<<<<<<");
            printBoard(board);
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j]='k';
                nKnight(board, row + 1);
                board[row][j]='.';

            }
           
            

        }

    }

    public static void main(String args[]){
        int n=4;
        char board[][]=new char[n][n];
        
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        nKnight(board,0);
    }

    
}
