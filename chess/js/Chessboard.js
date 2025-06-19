import { Pawn } from './Pawn.js';
import { Rook } from './Rook.js';
import { Knight } from './Knight.js';
import { Bishop } from './Bishop.js';
import { Queen } from './Queen.js';
import { King } from './King.js';

export class Chessboard {
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
    this.size = 8;

    this.board = Array.from({ length: this.size }, (_, i) => 
      Array.from({ length: this.size }, (_, j) => {
        if (i === 1) return 'p';
        if (i === 6) return 'P';
        if (i === 0) {
          if (j === 0 || j === 7) return 'r';
          if (j === 1 || j === 6) return 'n';
          if (j === 2 || j === 5) return 'b';
          if (j === 3) return 'q';
          if (j === 4) return 'k';
        }
        if (i === 7) {
          if (j === 0 || j === 7) return 'R';
          if (j === 1 || j === 6) return 'N';
          if (j === 2 || j === 5) return 'B';
          if (j === 3) return 'Q';
          if (j === 4) return 'K';
        }
        return '.';
      })
    );
  }

  printBoard() {
    console.log('\nCurrent Board:');
    this.board.forEach(row => {
      console.log(row.join(' '));
    });
    console.log();
  }

  movePiece(x, y, newX, newY) {
    const piece = this.board[x][y];
    if (piece === 'p' || piece === 'P') {
      Pawn.move(this.board, x, y, newX, newY, this.lastMoveFromX, this.lastMoveToX, this.lastMoveToY, this);
    } else if (piece === 'r' || piece === 'R') {
      Rook.move(this.board, x, y, newX, newY);
    } else if (piece === 'n' || piece === 'N') {
      Knight.move(this.board, x, y, newX, newY);
    } else if (piece === 'b' || piece === 'B') {
      Bishop.move(this.board, x, y, newX, newY);
    } else if (piece === 'q' || piece === 'Q') {
      Queen.move(this.board, x, y, newX, newY);
    } else if (piece === 'k' || piece === 'K') {
      King.move(this.board, x, y, newX, newY);
    } else {
      console.log('Invalid move: only chess pieces can move');
    }
  }

  // Valid move previews
  validPawnMove(x, y) { Pawn.showValidMoves(this.board, x, y); }
  validRookMove(x, y) { Rook.showValidMoves(this.board, x, y); }
  validKnightMove(x, y) { Knight.showValidMoves(this.board, x, y); }
  validBishopMove(x, y) { Bishop.showValidMoves(this.board, x, y); }
  validQueenMove(x, y) { Queen.showValidMoves(this.board, x, y); }
  validKingMove(x, y) { King.showValidMoves(this.board, x, y); }
}
