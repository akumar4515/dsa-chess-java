export class Rook {
  static move(board, x, y, newX, newY) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();
    const target = board[newX][newY];

    if (
      newX >= 0 && newX < 8 &&
      newY >= 0 && newY < 8 &&
      (newX === x || newY === y)
    ) {
      if (
        (isWhite && (target === '.' || target === target.toLowerCase())) ||
        (!isWhite && (target === '.' || target === target.toUpperCase()))
      ) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else {
        console.log("Invalid move for Rook");
      }
    } else {
      console.log("Invalid move for Rook");
    }
  }

  static showValidMoves(board, x, y) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();

    // Up
    for (let i = x - 1; i >= 0; i--) {
      const target = board[i][y];
      if (target === '.') {
        board[i][y] = 'x';
      } else {
        if (
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[i][y] = 'x';
        }
        break;
      }
    }

    // Down
    for (let i = x + 1; i < 8; i++) {
      const target = board[i][y];
      if (target === '.') {
        board[i][y] = 'x';
      } else {
        if (
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[i][y] = 'x';
        }
        break;
      }
    }

    // Right
    for (let j = y + 1; j < 8; j++) {
      const target = board[x][j];
      if (target === '.') {
        board[x][j] = 'x';
      } else {
        if (
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[x][j] = 'x';
        }
        break;
      }
    }

    // Left
    for (let j = y - 1; j >= 0; j--) {
      const target = board[x][j];
      if (target === '.') {
        board[x][j] = 'x';
      } else {
        if (
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[x][j] = 'x';
        }
        break;
      }
    }
  }
}
