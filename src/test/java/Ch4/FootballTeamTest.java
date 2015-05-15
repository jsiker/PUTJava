package Ch4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final FootballTeam BEARS = new FootballTeam(1);
    private static final FootballTeam PACKERS = new FootballTeam(100);

    public Object[] numberOfGamesWon() {
        return $(0, 1, 2);
    }

    public Object[] illegalNumberOfGamesWon() {
        return $(-10, -1);
    }

    @Test
    @Parameters(method = "numberOfGamesWon")
    public void constructorShouldSetGamesWon(int numberOfGamesWon) {
        FootballTeam team = new FootballTeam(numberOfGamesWon);
        assertEquals(numberOfGamesWon, team.getGamesWon());

    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNumberOfGamesWon")
    public void constructorShouldThrowExceptionForNegativeGames(int illegalNumberOfGames) {
        new FootballTeam(illegalNumberOfGames);
    }

    @Test
    public void shouldBePossibleToCompareTeams() {

        assertTrue(BEARS instanceof Comparable);
    }

    @Test
    public void teamsWithMoreWinsShouldBeGreater() {

        assertTrue("Team with " + PACKERS.getGamesWon() + " games won should be ranked above team with " + BEARS.getGamesWon()
                + " games won.", PACKERS.compareTo(BEARS) > 0);
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeLesser() {

        assertTrue("Team with " + BEARS.getGamesWon() + " games won should be ranked after team with " + PACKERS.getGamesWon()
        + " games won.", BEARS.compareTo(PACKERS) < 0);
    }

    @Test
    public  void teamsWithSameNumberOfMatchesShouldBeEqual() {


        assertTrue("Both teams have won the same amount of games: " + BEARS.getGamesWon() + " vs. " + BEARS.getGamesWon()
        + " and should be ranked equal.", BEARS.compareTo(BEARS) == 0);
    }

}