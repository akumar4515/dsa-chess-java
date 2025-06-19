export class Knight {
  static move(board, x, y, newX, newY) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();
    const target = board[newX][newY];

    if (newX < 0 || newX >= 8 || newY < 0 || newY >= 8) {
      console.log("Invalid move for Knight");
      return;
    }

    const dx = Math.abs(newX - x);
    const dy = Math.abs(newY - y);

    const validLShape = (dx === 2 && dy === 1) || (dx === 1 && dy === 2);

    if (validLShape) {
      if (
        (isWhite && (target === '.' || target === target.toLowerCase())) ||
        (!isWhite && (target === '.' || target === target.toUpperCase()))
      ) {
        board[newX][newY] = piece;
        board[x][y] = '.';
      } else {
        console.log("Invalid move for Knight");
      }
    } else {
      console.log("Invalid move for Knight");
    }
  }

  static showValidMoves(board, x, y) {
    const piece = board[x][y];
    const isWhite = piece === piece.toUpperCase();

    const knightMoves = [
      [2, 1], [2, -1], [-2, 1], [-2, -1],
      [1, 2], [1, -2], [-1, 2], [-1, -2]
    ];

    for (const [dx, dy] of knightMoves) {
      const newX = x + dx;
      const newY = y + dy;

      if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
        const target = board[newX][newY];
        if (
          target === '.' ||
          (isWhite && target === target.toLowerCase()) ||
          (!isWhite && target === target.toUpperCase())
        ) {
          board[newX][newY] = 'x'; // Mark valid move
        }
      }
    }
  }
}
