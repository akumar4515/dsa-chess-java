package chess;

public class Queen {

    static void move(char[][] board, int x, int y, int newX, int newY){
        if(Math.abs(newX-x)==Math.abs(newY-y)){
             bishop.move(board, x, y, newX, newY);

        }
        else if(newX==x || newY==y){
            Rook.move(board, x, y, newX, newY);
        }
        else{
            System.out.println("Invalid move for Queen");
        }
    };

    static void showValidMoves(char[][] board, int x, int y) {
        bishop.showValidMoves(board, x, y);
        Rook.showValidMoves(board, x, y);
    };
    
}
