# Chessmate

A JavaScript chess logic library implemented from scratch in pure JavaScript.It was Written in Java, but it Further Converted Into JavaScript So That It can Be Used In Web Application And App. It Supports all standard moves including En Passant, Check, Checkmate, and Stalemate.

## 📦 Installation

```bash
npm install chessmate


🔧 Usage
javascript
import { Chessboard } from 'chessmate';

const board = new Chessboard();

board.printBoard();

// En Passant Example
board.movePiece(6, 0, 4, 0); // White pawn 2-step
board.movePiece(1, 5, 3, 5); // Black pawn 2-step
board.movePiece(4, 0, 3, 0); // White pawn 1-step
board.movePiece(1, 1, 3, 1); // Black pawn 2-step
board.movePiece(3, 0, 2, 1); // En Passant by white
board.movePiece(6, 1, 4, 1); // White pawn normal move

board.printBoard();


♟ Features
Fully functional chess logic

Support for:

Pawn promotion

En Passant

Check and Checkmate detection

Stalemate and Draw

Easy-to-use API

No external dependencies



📁 File Structure
chessmate/
├── chess/
│   ├── Bishop.js
│   ├── King.js
│   ├── Knight.js
│   ├── Pawn.js
│   ├── Queen.js
│   ├── Rook.js
│   └── Game.js
├── Chessboard.js
└── index.js



🔄 Future Improvements
Add castling support
Add Draw Game Support
Board State Tracking
Undo Redo Moves
PGN parsing & move history



👨‍💻 Author
Aman Kumar

