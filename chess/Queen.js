import { Bishop } from './Bishop.js';
import { Rook } from './Rook.js';

export class Queen {
  static move(board, x, y, newX, newY) {
    if (Math.abs(newX - x) === Math.abs(newY - y)) {
      Bishop.move(board, x, y, newX, newY);
    } else if (newX === x || newY === y) {
      Rook.move(board, x, y, newX, newY);
    } else {
      console.log("Invalid move for Queen");
    }
  }

  static showValidMoves(board, x, y) {
    Bishop.showValidMoves(board, x, y);
    Rook.showValidMoves(board, x, y);
  }
}
