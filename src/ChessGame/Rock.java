package ChessGame;

public class Rock extends Piece {
    boolean isValidMove(Position newPosition) {
        if (super.isValidMove(newPosition) == false) {
            return false;
        }
        if (newPosition.column == this.position.column || newPosition.row == this.position.row) {
            return true;
        } else {
            return false;
        }
    }
}