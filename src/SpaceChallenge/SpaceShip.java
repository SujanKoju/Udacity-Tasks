package SpaceChallenge;

public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item var1);

    void carry(Item var1);
}
