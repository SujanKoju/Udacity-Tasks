package ChessGame;

public class Main {
    public static void main(String []args)
    {
        Piece rock1 = new Rock();
        Position currPos = new Position(1,1);
        rock1.position=currPos;
        Position newPos = new Position(1,7);
        System.out.println(rock1.isValidMove(newPos));

    }
}
