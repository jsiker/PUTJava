package Ch4;

/**
 * Created by m805958 on 5/13/15.
 */
public class FootballTeam implements Comparable<FootballTeam>{
    private int gamesWon;



    public FootballTeam(int gamesWon) {
        this.gamesWon = gamesWon;

        if (gamesWon < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballTeam)) return false;

        FootballTeam that = (FootballTeam) o;

        if (gamesWon != that.gamesWon) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();
    }
}
