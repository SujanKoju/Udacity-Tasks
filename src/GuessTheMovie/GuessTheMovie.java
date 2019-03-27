package GuessTheMovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheMovie {
    private boolean winFlag = false;
    private List<String> movies = new ArrayList<>();
    private List<Character> wrongGuesses = new ArrayList<>();
    private int noOfMovie = 0;

    public boolean isWinFlag() {
        return winFlag;
    }

    public void setWinFlag(boolean winFlag) {
        this.winFlag = winFlag;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public List<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(List<Character> wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    public int getNoOfMovie() {
        return noOfMovie;
    }

    public void setNoOfMovie(int noOfMovie) {
        this.noOfMovie = noOfMovie;
    }

    public void startPlaying() {

        getMoviesFromFile();
        String randomMovie = getRandomMovie();
        String randomMovieInUnderscore = getRandomMovieInUnderScore(randomMovie);
        System.out.println(randomMovie);
        enterTheGame(randomMovie, randomMovieInUnderscore);
        checkForWinOrLose();
    }


    public void getMoviesFromFile() {
        File movieList = new File("movieList.txt");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(movieList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileScanner.hasNextLine()) {
            getMovies().add(fileScanner.nextLine());
            setNoOfMovie(getNoOfMovie() + 1);

        }
    }

    public String getRandomMovie() {
        Random random = new Random();
        int randomMovieNo = random.nextInt(getNoOfMovie());
        return getMovies().get(randomMovieNo);
    }

    public String getRandomMovieInUnderScore(String randomMovie) {
        return randomMovie.replaceAll("[a-zA-Z]", "_");
    }

    public void enterTheGame(String randomMovie, String randomMovieInUnderscore) {
        for (int wrongGuess = 0; wrongGuess < 10; wrongGuess++) {
            System.out.println("You Are Guessing :" + randomMovieInUnderscore);
            System.out.println("You have Guessed (" + wrongGuess + ") Wrong Letters:" + getWrongGuesses());
            System.out.print("Guess a Letter :");

            Scanner userScanner = new Scanner(System.in);
            char guessedLetter = userScanner.next().charAt(0);
            StringBuilder newRandomMovieInUnderscore = new StringBuilder(randomMovieInUnderscore);
            if (randomMovie.indexOf(guessedLetter) == -1) {
                getWrongGuesses().add(guessedLetter);
            } else {

                for (int i = 0; i < randomMovie.length(); i++) {
                    if (randomMovie.charAt(i) == guessedLetter) {
                        newRandomMovieInUnderscore.setCharAt(i, guessedLetter);
                    }
                }
                wrongGuess--;
            }
            System.out.println(newRandomMovieInUnderscore);
            randomMovieInUnderscore = newRandomMovieInUnderscore.toString();
            if (randomMovieInUnderscore.indexOf('_') == -1) {
                setWinFlag(true);
                break;
            }
        }
    }

    public void checkForWinOrLose() {
        if (isWinFlag()) {
            System.out.println("******** YOU WIN *********");
        } else {
            System.out.println("******** YOU LOSE *********");
            System.out.println("******** The Movie was  --> "+getRandomMovie()+"********");
        }
    }


}
