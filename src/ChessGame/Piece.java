package ChessGame;

public class Piece {
    Position position;

    Piece() {
    }

    public Piece(Position position) {
        this.position = position;
    }

    boolean isValidMove(Position newPosition) {
        if (newPosition.column > 0 && newPosition.column > 0 && newPosition.column < 8 && newPosition.column < 8) {
            return true;
        } else {
            return false;
        }
    }
}
