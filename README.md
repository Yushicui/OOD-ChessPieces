# Chess Game: Object-Oriented Design

### <br>**Overview**<br>
This project aims to design and implement various chess pieces with their respective movements and actions on a chess board.

Chess Board Representation
Cell Addressing: Each cell on the board is represented by a (row, column) tuple.
Rows increase from bottom to top.
Columns increase from left to right.
Traditional Layout: The black pieces are traditionally arranged in the top two rows.

### **Chess Pieces Behavior**

**Bishop:**<br>
Movement: Diagonal only.<br>
Killing: Diagonally, occupying the opponent's position.<br>

**Knight:**<br>
Movement: L pattern (two cells horizontally and one vertically or vice versa).<br>
Killing: Occupying the opponent's position following its movement rule.<br>

**Rook:**<br>
Movement: Horizontally or vertically.<br>
Killing: Along its path, occupying the opponent's position.<br>

**Queen:**<br>
Movement: Horizontally, vertically, and diagonally.<br>
Killing: Along its path, occupying the opponent's position.<br>

**King:**<br>
Movement: One square in any direction.<br>
Killing: Occupying the opponent's position in any adjacent cell.<br>

**Pawn:**<br>
Movement: Forward only, with a special two-square move at the start.<br>
Killing: Diagonally forward.<br>

### **Core Components**<br>

**ChessPiece Interface:**<br>
- Defines the core methods that each chess piece class should implement.<br>
Includes methods like getRow(), getColumn(), getColor(), canMove(int row, int col), and canKill(ChessPiece piece).<br>

**Color Enum:**<br>
- Defines the two colors a chess piece can have: BLACK and WHITE.<br>

**Piece Classes: Bishop, Knight, Rook, Queen, King, Pawn.**<br>
- Each implements the ChessPiece interface.<br>
- Constructors initialize the piece's position and color.<br>
- Unique movement and killing rules are defined within the corresponding methods.<br>

### **Key Takeaways**<br>
- The project showcases the intricate rules of chess through an object-oriented lens.<br>
- The design is modular, allowing for easy extensions and adaptability.<br>
- Potential for further expansion, such as integrating this into a chess game with a GUI, adding game state management, etc.<br>
