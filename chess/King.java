package chess;

public class King {

    static void move(char[][] board, int x, int y, int newX, int newY){
        char piece=board[x][y];
        boolean isWhite=Character.isUpperCase(piece);
        char target=board[newX][newY];
        if(isWhite &&newX>=0 && newX<8 && newY>=0 && newY<8){
            if(Math.abs(newX-x)<=1 && Math.abs(newY-y)<=1){
                if(target=='.' || Character.isLowerCase(target)){
                    board[newX][newY]=piece;
                    board[x][y]='.';
                }
            } else {
                System.out.println("Invalid move for King");
            }
        } else if(!isWhite && newX>=0 && newX<8 && newY>=0 && newY<8){
            if(Math.abs(newX-x)<=1 && Math.abs(newY-y)<=1){
                if(target=='.' || Character.isUpperCase(target)){
                    board[newX][newY]=piece;
                    board[x][y]='.';
                }
            } else {
                System.out.println("Invalid move for King");
            }
        } else {
            System.out.println("Invalid move for King");

        }

    };

    static void showValidMoves(char[][] board, int x, int y) {
        char piece = board[x][y];
        boolean isWhite = Character.isUpperCase(piece);

        // Possible king moves
        int[][] moves = {
            {1, 0}, {1, 1}, {1, -1},
            {0, 1}, {0, -1},
            {-1, 0}, {-1, 1}, {-1, -1}
        };

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board[newX][newY] == '.' || 
                    (isWhite && Character.isLowerCase(board[newX][newY])) || 
                    (!isWhite && Character.isUpperCase(board[newX][newY]))) {
                    board[newX][newY] = 'x'; // Mark valid move
                }
            }
        }
    }

}
