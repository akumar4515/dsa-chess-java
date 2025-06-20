// Chessboard.js

class Chessboard {
    constructor() {
        this.lastMoveFromX = -1;
        this.lastMoveFromY = -1;
        this.lastMoveToX = -1;
        this.lastMoveToY = -1;
        this.whiteKingX = 7;
        this.whiteKingY = 4;
        this.blackKingX = 0;
        this.blackKingY = 4;
        this.currMove = 0;
        this.moveNumber = 1;
        this.moveHistory = [];
        this.size = 8;
        this.board = Array.from({ length: this.size }, () => Array(this.size).fill('.'));

        for (let i = 0; i < this.size; i++) {
            for (let j = 0; j < this.size; j++) {
                if (i === 1) this.board[i][j] = 'p';
                else if (i === 6) this.board[i][j] = 'P';
                else if (i === 0) {
                    if (j === 0 || j === 7) this.board[i][j] = 'r';
                    if (j === 1 || j === 6) this.board[i][j] = 'n';
                    if (j === 2 || j === 5) this.board[i][j] = 'b';
                    if (j === 3) this.board[i][j] = 'q';
                    if (j === 4) this.board[i][j] = 'k';
                } else if (i === 7) {
                    if (j === 0 || j === 7) this.board[i][j] = 'R';
                    if (j === 1 || j === 6) this.board[i][j] = 'N';
                    if (j === 2 || j === 5) this.board[i][j] = 'B';
                    if (j === 3) this.board[i][j] = 'Q';
                    if (j === 4) this.board[i][j] = 'K';
                }
            }
        }

        this.moveHistory.push(this.copyBoard(this.board));
        this.printBoard(this.board);
    }

    printBoard(board) {
        console.log("\nCurrent Board:");
        board.forEach(row => console.log(row.join(" ")));
        console.log();
    }

    copyBoard(board) {
        return board.map(row => [...row]);
    }

    undoMove() {
        if (this.moveHistory.length > 1) {
            this.moveHistory.pop();
            this.board = this.copyBoard(this.moveHistory[this.moveHistory.length - 1]);
            this.moveNumber--;
            this.printBoard(this.board);
        } else {
            console.log("No moves to undo.");
        }
    }

    resetBoard() {
        if (this.moveHistory.length > 1) {
            const initialBoard = this.moveHistory[0];
            this.moveHistory = [this.copyBoard(initialBoard)];
            this.board = this.copyBoard(initialBoard);
            this.moveNumber = 0;
            console.log("Board reset to initial state.");
            this.printBoard(this.board);
        }
    }

    isLegalMove(x, y, newX, newY) {
        if (this.board[x][y] === '.') return false;
        const tempBoard = this.copyBoard(this.board);
        const piece = tempBoard[x][y];
        tempBoard[newX][newY] = piece;
        tempBoard[x][y] = '.';

        let wX = this.whiteKingX, wY = this.whiteKingY;
        let bX = this.blackKingX, bY = this.blackKingY;

        if (piece.toLowerCase() === 'k') {
            if (this.currMove === 0) {
                wX = newX;
                wY = newY;
            } else {
                bX = newX;
                bY = newY;
            }
        }

        return !Game.isCheck(tempBoard, wX, wY, bX, bY, this.currMove);
    }

    movePiece(x, y, newX, newY) {
        const piece = this.board[x][y];
        let valid = false;

        if (this.isLegalMove(x, y, newX, newY)) {
            const lower = piece.toLowerCase();
            if (lower === 'p') Pawn.move(this.board, x, y, newX, newY, this);
            else if (lower === 'r') Rook.move(this.board, x, y, newX, newY);
            else if (lower === 'n') Knight.move(this.board, x, y, newX, newY);
            else if (lower === 'b') Bishop.move(this.board, x, y, newX, newY);
            else if (lower === 'q') Queen.move(this.board, x, y, newX, newY);
            else if (lower === 'k') King.move(this.board, x, y, newX, newY);
            else return 0;
            valid = true;
        }

        if (valid) {
            this.moveHistory.push(this.copyBoard(this.board));
            this.moveNumber++;
            this.printBoard(this.board);

            if (Game.isCheckmate(this.board, this.whiteKingX, this.whiteKingY, this.blackKingX, this.blackKingY, this.currMove)) {
                console.log("CHECKMATE! Game over.");
                return 2;
            }

            const drawResult = Game.isDraw(this.board, this.whiteKingX, this.whiteKingY, this.blackKingX, this.blackKingY, this.currMove);
            if (drawResult === 1) {
                console.log("Draw by stalemate.");
                return 3;
            } else if (drawResult === 2) {
                console.log("Draw by insufficient material.");
                return 4;
            }

            if (Game.isCheck(this.board, this.whiteKingX, this.whiteKingY, this.blackKingX, this.blackKingY, this.currMove)) {
                console.log("CHECK!");
                this.currMove = 1 - this.currMove;
                return 1;
            }

            this.currMove = 1 - this.currMove;
            return 5;
        } else {
            console.log("Illegal move: Either not allowed or puts king in check.");
            return 0;
        }
    }

    // Visual helpers (optional)
    validPawnMove(x, y) { Pawn.showValidMoves(this.board, x, y); }
    validRookMove(x, y) { Rook.showValidMoves(this.board, x, y); }
    validKnightMove(x, y) { Knight.showValidMoves(this.board, x, y); }
    validBishopMove(x, y) { Bishop.showValidMoves(this.board, x, y); }
    validQueenMove(x, y) { Queen.showValidMoves(this.board, x, y); }
    validKingMove(x, y) { King.showValidMoves(this.board, x, y); }
}

module.exports = Chessboard;
