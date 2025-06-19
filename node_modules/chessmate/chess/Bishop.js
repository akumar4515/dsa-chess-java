export class Bishop {
  static isClear(board, x, y, newX, newY) {
    const dx = newX - x;
    const dy = newY - y;
    const stepX = Math.sign(dx);
    const stepY = Math.sign(dy);

    for (let i = 1; i < Math.abs(dx); i++) {
      if (board[x + i * stepX][y + i * stepY] !== '.') {
        return false;
      }
    }
    return true;
  }

  static move(board, x, y, newX, newY) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();
    const target = board[newX][newY];

    if (!this.isClear(board, x, y, newX, newY)) {
      console.log("Invalid move for Bishop: Path is blocked");
      return;
    }

    if (
      newX >= 0 &&
      newX < 8 &&
      newY >= 0 &&
      newY < 8 &&
      Math.abs(newX - x) === Math.abs(newY - y)
    ) {
      if (
        (isWhite && (target === '.' || target === target.toLowerCase())) ||
        (!isWhite && (target === '.' || target === target.toUpperCase()))
      ) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      }
    }
  }

  static showValidMoves(board, x, y) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();

    // Direction vectors for bishop
    const directions = [
      [-1, -1], // Up-Left
      [-1, 1],  // Up-Right
      [1, -1],  // Down-Left
      [1, 1]    // Down-Right
    ];

    for (const [dx, dy] of directions) {
      let i = 1;
      while (true) {
        const newX = x + i * dx;
        const newY = y + i * dy;

        if (newX < 0 || newX >= 8 || newY < 0 || newY >= 8) break;

        const target = board[newX][newY];

        if (target === '.') {
          board[newX][newY] = 'x';
        } else {
          if (
            (isWhite && target === target.toLowerCase()) ||
            (!isWhite && target === target.toUpperCase())
          ) {
            board[newX][newY] = 'x';
          }
          break;
        }
        i++;
      }
    }
  }
}
