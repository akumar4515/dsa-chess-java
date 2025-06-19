export class Game {
  static isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove) {
    const len = board.length;

    const knightThreats = (x, y, threat) => {
      const moves = [
        [2, 1], [2, -1], [-2, 1], [-2, -1],
        [1, 2], [1, -2], [-1, 2], [-1, -2]
      ];
      for (const [dx, dy] of moves) {
        const nx = x + dx, ny = y + dy;
        if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8 && board[nx][ny] === threat) return true;
      }
      return false;
    };

    const pawnThreats = (x, y, threats) => {
      for (const [dx, dy] of threats) {
        const nx = x + dx, ny = y + dy;
        if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8 && board[nx][ny] === threats[0][2]) return true;
      }
      return false;
    };

    const checkStraight = (x, y, threats) => {
      // Vertical down
      for (let i = x + 1; i < 8; i++) {
        if (board[i][y] !== '.') {
          if (threats.includes(board[i][y])) return true;
          break;
        }
      }
      // Vertical up
      for (let i = x - 1; i >= 0; i--) {
        if (board[i][y] !== '.') {
          if (threats.includes(board[i][y])) return true;
          break;
        }
      }
      return false;
    };

    const checkDiagonals = (x, y, threats) => {
      const dirs = [[1,1],[1,-1],[-1,1],[-1,-1]];
      for (const [dx, dy] of dirs) {
        let i = x + dx, j = y + dy;
        while (i >= 0 && j >= 0 && i < 8 && j < 8) {
          if (board[i][j] !== '.') {
            if (threats.includes(board[i][j])) return true;
            break;
          }
          i += dx;
          j += dy;
        }
      }
      return false;
    };

    if (currMove === 0) { // white turn, check if white king is attacked
      if (
        checkStraight(whiteKingX, whiteKingY, ['q', 'r']) ||
        checkDiagonals(whiteKingX, whiteKingY, ['q', 'b']) ||
        knightThreats(whiteKingX, whiteKingY, 'n') ||
        pawnThreats(whiteKingX, whiteKingY, [[-1, -1, 'p'], [-1, 1, 'p']])
      ) return true;
    } else { // black turn
      if (
        checkStraight(blackKingX, blackKingY, ['Q', 'R']) ||
        checkDiagonals(blackKingX, blackKingY, ['Q', 'B']) ||
        knightThreats(blackKingX, blackKingY, 'N') ||
        pawnThreats(blackKingX, blackKingY, [[1, -1, 'P'], [1, 1, 'P']])
      ) return true;
    }

    return false;
  }

  static isCheckmate(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove) {
    if (!this.isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) return false;

    const dx = [-1, 0, 1, 0, -1, -1, 1, 1];
    const dy = [0, -1, 0, 1, -1, 1, -1, 1];

    for (let i = 0; i < dx.length; i++) {
      const newX = (currMove === 0 ? whiteKingX : blackKingX) + dx[i];
      const newY = (currMove === 0 ? whiteKingY : blackKingY) + dy[i];
      if (newX >= 0 && newY >= 0 && newX < 8 && newY < 8) {
        if (!this.isCheck(board,
          currMove === 0 ? newX : whiteKingX,
          currMove === 0 ? newY : whiteKingY,
          currMove === 1 ? newX : blackKingX,
          currMove === 1 ? newY : blackKingY,
          currMove)) {
          return false;
        }
      }
    }

    return true;
  }

  static isStalemate(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove) {
    if (this.isCheck(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) return false;

    const dx = [-1, 0, 1, 0, -1, -1, 1, 1];
    const dy = [0, -1, 0, 1, -1, 1, -1, 1];

    for (let i = 0; i < dx.length; i++) {
      const newX = (currMove === 0 ? whiteKingX : blackKingX) + dx[i];
      const newY = (currMove === 0 ? whiteKingY : blackKingY) + dy[i];
      if (newX >= 0 && newY >= 0 && newX < 8 && newY < 8) {
        if (!this.isCheck(board,
          currMove === 0 ? newX : whiteKingX,
          currMove === 0 ? newY : whiteKingY,
          currMove === 1 ? newX : blackKingX,
          currMove === 1 ? newY : blackKingY,
          currMove)) {
          return false;
        }
      }
    }

    return true;
  }

  static isDraw(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove) {
    if (this.isStalemate(board, whiteKingX, whiteKingY, blackKingX, blackKingY, currMove)) return 1;

    let onlyKings = true;
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[i].length; j++) {
        const piece = board[i][j];
        if (piece !== '.' && piece !== 'K' && piece !== 'k') {
          onlyKings = false;
          break;
        }
      }
      if (!onlyKings) break;
    }

    if (onlyKings) return 2;

    return 0;
  }
}
