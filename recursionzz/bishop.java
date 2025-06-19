package recursionzz;

public class bishop {

    public static boolean isSafe(char board[][], int row, int col){
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='b'){
                return false;
            }
        }
        //dia right
        for(int i=row-1,j=col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='b'){
               return false;
            }
        }
        return true;

    }
    public static void nBishop(char board[][], int row){
        if(row==board.length){
            System.out.println(">>>>>>>>>>>>>>bishop<<<<<<<<<<<<<<<");
            printBoard(board);
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j]='b';
                nBishop(board, row+1);
                board[row][j]='.';

            }
         
        }
    }
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length; i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
              
    
            }
            System.out.println();
           }

    }



    public static void main(String args[]){
        int n=2;
        char board[][]=new char[n][n];
        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        nBishop(board, 0);
    }
    
}
