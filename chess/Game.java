package chess;

public class Game {
    static boolean isCheck(char[][] board,int whiteKingX, int whiteKingY, int blackKingX, int blackKingY,int currMove) {
        
        //white king
         
      if(currMove==0){
// check for queen,bishop, rook threat
    
        for(int i=whiteKingX;i<board.length;i++){
            if(board[i][whiteKingY]=='q'||board[i][whiteKingY]=='r'){
                return true;
            }
        };
        for(int i=whiteKingX;i>=0;i--){
            if(board[i][whiteKingY]=='q'||board[i][whiteKingY]=='r'){
                return true;
            }
        };

      // bottom-right diagonal (↘)
int i = whiteKingX + 1, j = whiteKingY + 1;
while(i < 8 && j < 8) {
    if(board[i][j] == 'q' || board[i][j] == 'b') return true;
    if(board[i][j] != '.') break;
    i++;
    j++;
}

// top-right diagonal (↗)
i = whiteKingX - 1;
j = whiteKingY + 1;
while(i >= 0 && j < 8) {
    if(board[i][j] == 'q' || board[i][j] == 'b') return true;
    if(board[i][j] != '.') break;
    i--;
    j++;
}

// bottom-left diagonal (↙)
i = whiteKingX + 1;
j = whiteKingY - 1;
while(i < 8 && j >= 0) {
    if(board[i][j] == 'q' || board[i][j] == 'b') return true;
    if(board[i][j] != '.') break;
    i++;
    j--;
}

// top-left diagonal (↖)
i = whiteKingX - 1;
j = whiteKingY - 1;
while(i >= 0 && j >= 0) {
    if(board[i][j] == 'q' || board[i][j] == 'b') return true;
    if(board[i][j] != '.') break;
    i--;
    j--;
}


        // check for knight threat
        if(whiteKingX+2 < board.length && whiteKingY+1 < board.length && (board[whiteKingX+2][whiteKingY+1]=='n')) {
            return true;
        }
        if(whiteKingX+2 < board.length && whiteKingY-1 >= 0 && (board[whiteKingX+2][whiteKingY-1]=='n')) {
            return true;
        }
        if(whiteKingX-2 >= 0 && whiteKingY+1 < board.length && (board[whiteKingX-2][whiteKingY+1]=='n')) {
            return true;
        }
        if(whiteKingX-2 >= 0 && whiteKingY-1 >= 0 && (board[whiteKingX-2][whiteKingY-1]=='n')) {
            return true;
        }
        if(whiteKingX+1 < board.length && whiteKingY+2 < board.length && (board[whiteKingX+1][whiteKingY+2]=='n')) {
            return true;
        }
        if(whiteKingX+1 < board.length && whiteKingY-2 >= 0 && (board[whiteKingX+1][whiteKingY-2]=='n')) {
            return true;
        }
        if(whiteKingX-1 >= 0 && whiteKingY+2 < board.length && (board[whiteKingX-1][whiteKingY+2]=='n')) {
            return true;
        }
        if(whiteKingX-1 >= 0 && whiteKingY-2 >= 0 && (board[whiteKingX-1][whiteKingY-2]=='n')) {
            return true;
        }
        // check for pawn threat
        if(whiteKingX-1 >= 0 && whiteKingY-1 >= 0 && (board[whiteKingX-1][whiteKingY-1]=='p')) {
            return true;
        }
        if(whiteKingX-1 >= 0 && whiteKingY+1 < board.length && (board[whiteKingX-1][whiteKingY+1]=='p')) {
            return true;
        }

        // Check for threats to the white king
       
       

    }
        //black king
        else{
            // check for queen,bishop, rook threat
    
            for(int i=blackKingX;i<board.length;i++){
                if(board[i][blackKingY]=='q'||board[i][blackKingY]=='r'){
                    return true;
                }
            };
            for(int i=blackKingX;i>=0;i--){
                if(board[i][blackKingY]=='q'||board[i][blackKingY]=='r'){
                    return true;
                }
            };

            // bottom-right diagonal (↘)
int i = blackKingX + 1, j = blackKingY + 1;
while (i < 8 && j < 8) {
    if (board[i][j] == 'q' || board[i][j] == 'b') return true;
    if (board[i][j] != '.') break;
    i++;
    j++;
}

// top-right diagonal (↗)
i = blackKingX - 1;
j = blackKingY + 1;
while (i >= 0 && j < 8) {
    if (board[i][j] == 'q' || board[i][j] == 'b') return true;
    if (board[i][j] != '.') break;
    i--;
    j++;
}

// bottom-left diagonal (↙)
i = blackKingX + 1;
j = blackKingY - 1;
while (i < 8 && j >= 0) {
    if (board[i][j] == 'q' || board[i][j] == 'b') return true;
    if (board[i][j] != '.') break;
    i++;
    j--;
}

// top-left diagonal (↖)
i = blackKingX - 1;
j = blackKingY - 1;
while (i >= 0 && j >= 0) {
    if (board[i][j] == 'q' || board[i][j] == 'b') return true;
    if (board[i][j] != '.') break;
    i--;
    j--;
}


            // check for knight threat
            if(blackKingX+2 < board.length && blackKingY+1 < board.length && (board[blackKingX+2][blackKingY+1]=='N')) {
                return true;
            }
            if(blackKingX+2 < board.length && blackKingY-1 >= 0 && (board[blackKingX+2][blackKingY-1]=='N')) {
                return true;
            }
            if(blackKingX-2 >= 0 && blackKingY+1 < board.length && (board[blackKingX-2][blackKingY+1]=='N')) {
                return true;
            }
            if(blackKingX-2 >= 0 && blackKingY-1 >= 0 && (board[blackKingX-2][blackKingY-1]=='N')) {
                return true;
            }
            if(blackKingX+1 < board.length && blackKingY+2 < board.length && (board[blackKingX+1][blackKingY+2]=='N')) {
                return true;
            }
            if(blackKingX+1 < board.length && blackKingY-2 >= 0 && (board[blackKingX+1][blackKingY-2]=='N')) {
                return true;
            }
            if(blackKingX-1 >= 0 && blackKingY+2 < board.length && (board[blackKingX-1][blackKingY+2]=='N')) {
                return true;
            }
            if(blackKingX-1 >= 0 && blackKingY-2 >= 0 && (board[blackKingX-1][blackKingY-2]=='N')) {
                return true;
            }
            // check for pawn threat
            if(blackKingX+1 < board.length && blackKingY-1 >= 0 && (board[blackKingX+1][blackKingY-1]=='P')) {
                return true;
            }
            if(blackKingX+1 < board.length && blackKingY+1 < board.length && (board[blackKingX+1][blackKingY+1]=='P')) {
                return true;
            }
        }
        return false;

    
};


static boolean isCheckmate(char[][]board, int whiteKingX, int whiteKingY, int blackKingX, int blackKingY, int currMove) {
    // Check if the king is in check
   if(!isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) {
        return false; // Not in check, so not checkmate
    }
    // Check all possible moves for the king
    int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    if(currMove==0){
        for(int i=0;i<dx.length;i++){
            int newX=whiteKingX+dx[i];
            int newY=whiteKingY+dy[i];
            if(!isCheck(board, newX, newY, blackKingX, blackKingY, currMove)) {
                return false; // Found a valid move for the king
            }
        }
    }
    else {
        for(int i=0;i<dx.length;i++){
            int newX=blackKingX+dx[i];
            int newY=blackKingY+dy[i];
            if(!isCheck(board, whiteKingX, whiteKingY, newX, newY, currMove)) {
                return false; // Found a valid move for the king
            }
        }
    }

    return true; // No valid moves found, it's checkmate
};


static boolean isStalemate(char[][] board, int whiteKingX, int whiteKingY, int blackKingX, int blackKingY, int currMove) {
    // Check if the king is in check
    if(isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) {
        return false; // Not stalemate if the king is in check
    }
    
    // Check all possible moves for the king
    int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    if(currMove==0){
        for(int i=0;i<dx.length;i++){
            int newX=whiteKingX+dx[i];
            int newY=whiteKingY+dy[i];
            if(!isCheck(board, newX, newY, blackKingX, blackKingY, currMove)) {
                return false; // Found a valid move for the king
            }
        }
    }
    else {
        for(int i=0;i<dx.length;i++){
            int newX=blackKingX+dx[i];
            int newY=blackKingY+dy[i];
            if(!isCheck(board, whiteKingX, whiteKingY, newX, newY, currMove)) {
                return false; // Found a valid move for the king
            }
        }
    }

    return true; // No valid moves found and not in check
};

static int isDraw(char[][] board, int whiteKingX, int whiteKingY, int blackKingX, int blackKingY, int currMove) {
    // 1. Check for stalemate
    if (isStalemate(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) {
        return 1; // Draw due to stalemate
    }

    // 2. Check for insufficient material (only two kings)
    boolean onlyKings = true;
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            char piece = board[i][j];
            if (piece != '.' && piece != 'K' && piece != 'k') {
                onlyKings = false;
                break;
            }
        }
        if (!onlyKings) break;
    }
    if (onlyKings) return 2; // Draw due to insufficient material

    // 3. Not a draw
    return 0;
}

}