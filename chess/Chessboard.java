package chess;

class Chessboard {

    int lastMoveFromX = -1, lastMoveFromY = -1;
    int lastMoveToX = -1, lastMoveToY = -1;
    int whiteKingX=7, whiteKingY=4;
    int blackKingX=0, blackKingY=4;
    int currMove=0;

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
    }

    void PrintBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    };



    void movePiece(int x, int y, int newX, int newY) {
        if (board[x][y] == 'p' || board[x][y] == 'P') {
            Pawn.move(board, x, y, newX, newY, lastMoveFromX, lastMoveToX, lastMoveToY, this);
        }
        else if(board[x][y]=='r'|| board[x][y]=='R'){
            Rook.move(board, x, y, newX, newY);
        }
        else if(board[x][y]=='n'|| board[x][y]=='N'){
            Knight.move(board, x, y, newX, newY);
        }
        else if(board[x][y]=='b'|| board[x][y]=='B'){
            bishop.move(board, x, y, newX, newY);
        }
        else if(board[x][y]=='q'|| board[x][y]=='Q'){
            Queen.move(board, x, y, newX, newY);
        }
        else if(board[x][y]=='k'|| board[x][y]=='K'){
            King.move(board, x, y, newX, newY);
        }
         else {
            System.out.println("Invalid move: only pawn can move");
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

        board.PrintBoard();

        // En Passant Scenario
        board.movePiece(6, 0, 4, 0); // White pawn 2-step
        board.movePiece(1, 5, 3, 5); // Black pawn 2-step
        board.movePiece(4, 0, 3, 0); // White pawn 1-step
        board.movePiece(1, 1, 3, 1); // Black pawn 2-step
        board.movePiece(3, 0, 2, 1); // En Passant by white

        board.movePiece(6,1,4,1);


        board.PrintBoard();
    }
}
