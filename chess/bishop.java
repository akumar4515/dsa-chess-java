package chess;

public class bishop {
    static boolean isClear(char[][] board, int x, int y, int newX, int newY){
        int dx = newX - x;
        int dy = newY - y;
        int stepX = Integer.signum(dx);
        int stepY = Integer.signum(dy);
        

        
        for (int i = 1; i < Math.abs(dx); i++) {
            if (board[x + i * stepX][y + i * stepY] != '.') {
                return false;
            }
        }
        return true;
    }
    static void move(char[][] board, int x, int y, int newX, int newY){
        char piece=board[x][y];
        boolean isWhite=Character.isUpperCase(piece);
        char target=board[newX][newY];
        if(!isClear(board, x, y, newX, newY)){
            System.out.println("Invalid move for Bishop: Path is blocked");
            return;
        }
        else{
            if(isWhite  && newX>=0 && newX<8 && newY>=0 && newY<8 && Math.abs(newX-x)==Math.abs(newY-y)){
            if(target=='.' || Character.isLowerCase(target)){
                board[newX][newY]=piece;
                board[x][y]='.';
            }

        }
        else if(!isWhite && newX>=0 && newX<8 && newY>=0 && newY<8 && Math.abs(newX-x)==Math.abs(newY-y)){
            if(target=='.' || Character.isUpperCase(target)){
                board[newX][newY]=piece;
                board[x][y]='.';
            }
        }

        }
    };

    static void showValidMoves(char[][] board, int x, int y){
        char piece = board[x][y];
        boolean isWhite = Character.isUpperCase(piece);
        
        // Up-Left
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (board[x - i][y - i] == '.') {
                board[x - i][y - i] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x - i][y - i])) ||
                    (!isWhite && Character.isUpperCase(board[x - i][y - i]))) {
                    board[x - i][y - i] = 'x';
                }
                break;
            }
        }

        // Up-Right
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            if (board[x - i][y + i] == '.') {
                board[x - i][y + i] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x - i][y + i])) ||
                    (!isWhite && Character.isUpperCase(board[x - i][y + i]))) {
                    board[x - i][y + i] = 'x';
                }
                break;
            }
        }

        // Down-Left
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            if (board[x + i][y - i] == '.') {
                board[x + i][y - i] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x + i][y - i])) ||
                    (!isWhite && Character.isUpperCase(board[x + i][y - i]))) {
                    board[x + i][y - i] = 'x';
                }
                break;
            }
        }

        // Down-Right
        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            if (board[x + i][y + i] == '.') {
                board[x + i][y + i] = 'x';
            } else {
                if ((isWhite && Character.isLowerCase(board[x + i][y + i])) ||
                    (!isWhite && Character.isUpperCase(board[x + i][y + i]))) {
                    board[x + i][y + i] = 'x';
                }
                break;
            }
        }
    }
    }
