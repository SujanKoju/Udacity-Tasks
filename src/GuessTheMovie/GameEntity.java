package GuessTheMovie;

import java.util.ArrayList;
import java.util.List;

public class GameEntity {
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
}
