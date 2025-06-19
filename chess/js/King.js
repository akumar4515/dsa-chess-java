export class King {
  static move(board, x, y, newX, newY) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();
    const target = board[newX][newY];

    if (newX < 0 || newX >= 8 || newY < 0 || newY >= 8) {
      console.log("Invalid move for King");
      return;
    }

    if (Math.abs(newX - x) <= 1 && Math.abs(newY - y) <= 1) {
      if (
        (isWhite && (target === '.' || target === target.toLowerCase())) ||
        (!isWhite && (target === '.' || target === target.toUpperCase()))
      ) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else {
        console.log("Invalid move for King");
      }
    } else {
      console.log("Invalid move for King");
    }
  }

  static showValidMoves(board, x, y) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();

    const directions = [
      [1, 0], [1, 1], [1, -1],
      [0, 1], [0, -1],
      [-1, 0], [-1, 1], [-1, -1]
    ];

    for (const [dx, dy] of directions) {
      const newX = x + dx;
      const newY = y + dy;

      if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
        const target = board[newX][newY];
        if (
          target === '.' ||
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[newX][newY] = 'x';
        }
      }
    }
  }
}
