export class Pawn {
  static move(board, x, y, newX, newY, lastMoveFromX, lastMoveToX, lastMoveToY, chessboard) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();
    const target = board[newX][newY];

    if (isWhite) {
      if (target === '.' && newX === x - 1 && newY === y) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (target === '.' && x === 6 && newX === x - 2 && newY === y) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (target !== '.' && target === target.toLowerCase() && newX === x - 1 && Math.abs(newY - y) === 1) {
        console.log("Captured " + target);
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (
        target === '.' &&
        x === 3 &&
        newX === 2 &&
        Math.abs(newY - y) === 1 &&
        board[x][newY] === 'p' &&
        lastMoveFromX === 1 &&
        lastMoveToX === 3 &&
        lastMoveToY === newY
      ) {
        console.log("En Passant!");
        board[newX][newY] = piece;
        board[x][y] = '.';
        board[newX + 1][newY] = '.';
      } else {
        console.log("Invalid move for White Pawn");
        return;
      }
    } else {
      if (target === '.' && newX === x + 1 && newY === y) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (target === '.' && x === 1 && newX === x + 2 && newY === y) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (target !== '.' && target === target.toUpperCase() && newX === x + 1 && Math.abs(newY - y) === 1) {
        console.log("Captured " + target);
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else if (
        target === '.' &&
        x === 4 &&
        newX === 5 &&
        Math.abs(newY - y) === 1 &&
        board[x][newY] === 'P' &&
        lastMoveFromX === 6 &&
        lastMoveToX === 4 &&
        lastMoveToY === newY
      ) {
        console.log("En Passant!");
        board[newX][newY] = piece;
        board[x][y] = '.';
        board[newX - 1][newY] = '.';
      } else {
        console.log("Invalid move for Black Pawn");
        return;
      }
    }

    // Update last move
    chessboard.lastMoveFromX = x;
    chessboard.lastMoveFromY = y;
    chessboard.lastMoveToX = newX;
    chessboard.lastMoveToY = newY;
  }

  static showValidMoves(board, x, y) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();

    if (piece !== 'P' && piece !== 'p') return;

    if (isWhite) {
      if (x > 0 && board[x - 1][y] === '.') board[x - 1][y] = 'x';
      if (x === 6 && board[x - 1][y] === '.' && board[x - 2][y] === '.') board[x - 2][y] = 'x';
      if (x > 0 && y > 0 && board[x - 1][y - 1] !== '.' && board[x - 1][y - 1] === board[x - 1][y - 1].toLowerCase())
        board[x - 1][y - 1] = 'x';
      if (x > 0 && y < 7 && board[x - 1][y + 1] !== '.' && board[x - 1][y + 1] === board[x - 1][y + 1].toLowerCase())
        board[x - 1][y + 1] = 'x';
    } else {
      if (x < 7 && board[x + 1][y] === '.') board[x + 1][y] = 'x';
      if (x === 1 && board[x + 1][y] === '.' && board[x + 2][y] === '.') board[x + 2][y] = 'x';
      if (x < 7 && y > 0 && board[x + 1][y - 1] !== '.' && board[x + 1][y - 1] === board[x + 1][y - 1].toUpperCase())
        board[x + 1][y - 1] = 'x';
      if (x < 7 && y < 7 && board[x + 1][y + 1] !== '.' && board[x + 1][y + 1] === board[x + 1][y + 1].toUpperCase())
        board[x + 1][y + 1] = 'x';
    }
  }
}
