package chess;

import java.util.HashMap;
import java.util.LinkedList;

class Chessboard {

    int lastMoveFromX = -1, lastMoveFromY = -1;
    int lastMoveToX = -1, lastMoveToY = -1;
    int whiteKingX=7, whiteKingY=4;
    int blackKingX=0, blackKingY=4;
    int currMove=0;
    int moveNumber=1;
    LinkedList<char[][]>moveHistory=new LinkedList<>();

    char[][] board;
    int size = 8;

    Chessboard() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 1) board[i][j] = 'p';
                else if (i ==6) board[i][j] = 'P';
                else if(i==0){
                    if(j==0 || j==7) board[i][j]='r';
                    if(j==1 || j==6) board[i][j]='n';
                    if(j==2 || j==5) board[i][j]='b';
                    if(j==3) board[i][j]='q';
                    if(j==4) board[i][j]='k';
                }
                else if(i==7){
                    if(j==0 || j==7) board[i][j]='R';
                    if(j==1 || j==6) board[i][j]='N';
                    if(j==2 || j==5) board[i][j]='B';
                    if(j==3) board[i][j]='Q';
                    if(j==4) board[i][j]='K';
                }
                else board[i][j] = '.';
            }
        }

        moveHistory.addFirst(copyBoard(board));
         char[][] lastBoard = moveHistory.getLast();
            printBoard(lastBoard);
    };

    void printBoard(char[][] board) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    };

   char[][] copyBoard(char[][] board) {
    char[][] copy = new char[8][8];
    for (int i = 0; i < 8; i++) {
        System.arraycopy(board[i], 0, copy[i], 0, 8);
    }
    return copy;
};

void undoMove() {
        if (moveHistory.size() > 1) {
            moveHistory.removeLast();
            board = moveHistory.getLast();
            moveNumber--;
            printBoard(board);
        } else {
            System.out.println("No moves to undo.");
        }
    };

 void resetBoard() {
    if (moveHistory.size() > 1) {
        char[][] initialBoard = moveHistory.getFirst();
        moveHistory.clear();
        moveHistory.addLast(copyBoard(initialBoard));
        moveNumber = 0;
        board = copyBoard(initialBoard);
        System.out.println("Board reset to initial state.");
        printBoard(board);
    }
}


boolean isLegalMove(char[][] board, int x, int y, int newX, int newY, Chessboard state) {
    if (board[x][y] == '.') return false; // no piece to move

    char[][] tempBoard = state.copyBoard(board);

    // Simulate move
    tempBoard[newX][newY] = tempBoard[x][y];
    tempBoard[x][y] = '.';

    // Adjust simulated king positions if king is moving
    int simulatedWhiteKingX = state.whiteKingX;
    int simulatedWhiteKingY = state.whiteKingY;
    int simulatedBlackKingX = state.blackKingX;
    int simulatedBlackKingY = state.blackKingY;

    char piece = board[x][y];

    if (Character.toLowerCase(piece) == 'k') {
        if (state.currMove == 0) { // white's turn
            simulatedWhiteKingX = newX;
            simulatedWhiteKingY = newY;
        } else { // black's turn
            simulatedBlackKingX = newX;
            simulatedBlackKingY = newY;
        }
    }

    // Check if move leaves king in check
    boolean stillInCheck = Game.isCheck(
        tempBoard,
        simulatedWhiteKingX,
        simulatedWhiteKingY,
        simulatedBlackKingX,
        simulatedBlackKingY,
        state.currMove
    );

    return !stillInCheck;
}



int movePiece(int x, int y, int newX, int newY) {
    char piece = board[x][y];
    boolean valid = false;

    // Check if the move is legal (i.e., doesn't leave the king in check)
    if (isLegalMove(board, x, y, newX, newY, this)) {
        switch (Character.toLowerCase(piece)) {
            case 'p':
                Pawn.move(board, x, y, newX, newY, lastMoveFromX, lastMoveToX, lastMoveToY, this);
                valid = true;
                break;
            case 'r':
                Rook.move(board, x, y, newX, newY);
                valid = true;
                break;
            case 'n':
                Knight.move(board, x, y, newX, newY);
                valid = true;
                break;
            case 'b':
                bishop.move(board, x, y, newX, newY);
                valid = true;
                break;
            case 'q':
                Queen.move(board, x, y, newX, newY);
                valid = true;
                break;
            case 'k':
                King.move(board, x, y, newX, newY);
                valid = true;
                break;
        }
    }

    if (valid) {
        // Save current board state
        moveHistory.addLast(copyBoard(board));
        moveNumber++;

        printBoard(moveHistory.getLast());

        // 1. Check for checkmate
        if (Game.isCheckmate(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) {
            System.out.println("CHECKMATE! Game over.");
            return 2;
        }

        // 2. Check for draw
        int drawResult = Game.isDraw(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove);
        if (drawResult == 1) {
            System.out.println("Draw by stalemate.");
            return 3;
        } else if (drawResult == 2) {
            System.out.println("Draw by insufficient material.");
            return 4;
        }

        // 3. Check for check
        if (Game.isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) {
            System.out.println("CHECK!");
            currMove = 1 - currMove;
            return 1;
        }

        // 4. Normal valid move
        currMove = 1 - currMove;
        return 5;
    } else {
        // Move is invalid (illegal or causes own king to be in check)
        System.out.println("Illegal move: Either not allowed or puts king in check.");
        return 0;
    }
};



    void validPawnMove(int x, int y) {
        Pawn.showValidMoves(board, x, y);
    };

    void validRookMove(int x, int y) {
    Rook.showValidMoves(board, x, y);
};

    void validKnightMove(int x, int y) {
        Knight.showValidMoves(board, x, y);
    };
    void validBishopMove(int x, int y) {
        bishop.showValidMoves(board, x, y);
    };
    void validQueenMove(int x, int y) {
        Queen.showValidMoves(board, x, y);
    };
    void validKingMove(int x, int y) {
        King.showValidMoves(board, x, y);
    };
        


    public static void main(String args[]) {
        Chessboard board = new Chessboard();

        // board.PrintBoard(board.board);

        // En Passant Scenario
        board.movePiece(6, 0, 4, 0); // White pawn 2-step
        board.movePiece(1, 5, 3, 5); // Black pawn 2-step
        board.movePiece(4, 0, 3, 0); // White pawn 1-step
        board.movePiece(1, 1, 3, 1); // Black pawn 2-step
        board.movePiece(3, 0, 2, 1); // En Passant by white

        board.movePiece(6,1,4,1);
        

        // board.PrintBoard(board.board);
    }
}
