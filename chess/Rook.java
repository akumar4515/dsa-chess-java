package chess;

public class Rook {
    static void move(char[][] board, int x, int y, int newX, int newY){
        char piece=board[x][y];
        boolean isWhite=Character.isUpperCase(piece);
        char target=board[newX][newY];
        if(isWhite && newX>=0 && newX<8 && newY>=0 && newY<8 && (newX==x || newY==y)){
            if(target=='.'|| Character.isLowerCase(target)){
                board[newX][newY]=piece;
                board[x][y]='.';
            }

        }
        else if(!isWhite && newX>=0 && newX<8 && newY>=0 && newY<8 && (newX==x || newY==y)){
            if(target=='.'|| Character.isUpperCase(target)){
                board[newX][newY]=piece;
                board[x][y]='.';
            }
        }
        else{
            System.out.println("Invalid move for Rook");

        }

    };

     static void showValidMoves(char[][] board, int x, int y) {
        char piece = board[x][y];
        boolean isWhite = Character.isUpperCase(piece);

        // Up
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == '.') {
                board[i][y] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[i][y])) ||
                    (!isWhite && Character.isUpperCase(board[i][y]))) {
                    board[i][y] = 'x';
                }
                break;
            }
        }

        // Down
        for (int i = x + 1; i < 8; i++) {
            if (board[i][y] == '.') {
                board[i][y] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[i][y])) ||
                    (!isWhite && Character.isUpperCase(board[i][y]))) {
                    board[i][y] = 'x';
                }
                break;
            }
        }

        // Right
        for (int j = y + 1; j < 8; j++) {
            if (board[x][j] == '.') {
                board[x][j] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x][j])) ||
                    (!isWhite && Character.isUpperCase(board[x][j]))) {
                    board[x][j] = 'x';
                }
                break;
            }
        }

        // Left
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == '.') {
                board[x][j] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x][j])) ||
                    (!isWhite && Character.isUpperCase(board[x][j]))) {
                    board[x][j] = 'x';
                }
                break;
            }
        }
    }
}
