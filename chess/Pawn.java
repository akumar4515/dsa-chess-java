package chess;

public class Pawn {

    static void move(char[][] board, int x, int y, int newX, int newY,
                     int lastMoveFromX, int lastMoveToX, int lastMoveToY,
                     Chessboard chessboard) {

        char piece = board[x][y];
        boolean isWhite = Character.isUpperCase(piece);
        char target = board[newX][newY];

        if (isWhite) {
            if (target == '.' && newX == x - 1 && newY == y) {
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (target == '.' && x == 6 && newX == x - 2 && newY == y) {
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (Character.isLowerCase(target) && newX == x - 1 && Math.abs(newY - y) == 1) {
                System.out.println("Captured " + target);
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (target == '.' && x == 3 && newX == 2 && Math.abs(newY - y) == 1 &&
                       board[x][newY] == 'p' && lastMoveFromX == 1 && lastMoveToX == 3 && lastMoveToY == newY) {
                System.out.println("En Passant!");
                board[newX][newY] = piece;
                board[x][y] = '.';
                board[newX + 1][newY] = '.';
            }
        } else {
            if (target == '.' && newX == x + 1 && newY == y) {
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (target == '.' && x == 1 && newX == x + 2 && newY == y) {
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (Character.isUpperCase(target) && newX == x + 1 && Math.abs(newY - y) == 1) {
                System.out.println("Captured " + target);
                board[newX][newY] = piece;
                board[x][y] = '.';
            } else if (target == '.' && x == 4 && newX == 5 && Math.abs(newY - y) == 1 &&
                       board[x][newY] == 'P' && lastMoveFromX == 6 && lastMoveToX == 4 && lastMoveToY == newY) {
                System.out.println("En Passant!");
                board[newX][newY] = piece;
                board[x][y] = '.';
                board[newX - 1][newY] = '.';
            }
        }

        chessboard.lastMoveFromX = x;
        chessboard.lastMoveFromY = y;
        chessboard.lastMoveToX = newX;
        chessboard.lastMoveToY = newY;
    }

    static void showValidMoves(char[][] board, int x, int y) {
        char piece = board[x][y];
        boolean isWhite = Character.isUpperCase(piece);

        if (piece != 'P' && piece != 'p') return;

        if (isWhite) {
            if (x > 0 && board[x - 1][y] == '.') board[x - 1][y] = 'x';
            if (x == 6 && board[x - 1][y] == '.' && board[x - 2][y] == '.') board[x - 2][y] = 'x';
            if (x > 0 && y > 0 && Character.isLowerCase(board[x - 1][y - 1])) board[x - 1][y - 1] = 'x';
            if (x > 0 && y < 7 && Character.isLowerCase(board[x - 1][y + 1])) board[x - 1][y + 1] = 'x';
        } else {
            if (x < 7 && board[x + 1][y] == '.') board[x + 1][y] = 'x';
            if (x == 1 && board[x + 1][y] == '.' && board[x + 2][y] == '.') board[x + 2][y] = 'x';
            if (x < 7 && y > 0 && Character.isUpperCase(board[x + 1][y - 1])) board[x + 1][y - 1] = 'x';
            if (x < 7 && y < 7 && Character.isUpperCase(board[x + 1][y + 1])) board[x + 1][y + 1] = 'x';
        }
    }
}
