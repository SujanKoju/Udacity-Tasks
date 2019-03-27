package GuessingGame;

import java.util.Scanner;

public class GuessingGame {
public void startGuessingGame()
{
    int randomNo = (int) (Math.random() * 100) + 1;
    boolean hasWon = false;

    System.out.println("I have randomly chosen no between 1-100");
    System.out.println("********* TRY TO GUESS **********");

    Scanner scanner = new Scanner(System.in);

    for (int noOfGuessLeft = 10; noOfGuessLeft > 0; noOfGuessLeft--) {
        System.out.println("You have " + noOfGuessLeft + " Guess Left.");
        int guess = scanner.nextInt();
        if (randomNo < guess) {
            System.out.println("It is Less than " + guess);
        } else if (randomNo > guess) {
            System.out.println("It is Greater than " + guess);
        } else {
            hasWon = true;
            break;
        }
    }
    if (hasWon) {
        System.out.println("Correct Guess ..... YOU WIN .......");
    } else {
        System.out.println("GAME OVER.....YOU LOSE.....");
        System.out.println("The No was "+randomNo);
    }
}

    public static void main(String []args) {
        GuessingGame game = new GuessingGame();
        game.startGuessingGame();

    }
}
