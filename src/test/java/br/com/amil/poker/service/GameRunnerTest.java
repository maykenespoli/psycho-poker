package br.com.amil.poker.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GameRunnerTest {

    private String gameLine;

    public GameRunnerTest(String gameLine) {
        this.gameLine = gameLine;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "TH JH QC QD QS QH KH AH 2S 6S" },
                { "2H 2S 3H 3S 3C 2D 3D 6C 9C TH" },
                { "2H 2S 3H 3S 3C 2D 9C 3D 6C TH" },
                { "2H AD 5H AC 7H AH 6H 9H 4H 3C" },
                { "AC 2D 9C 3S KD 5S 4D KS AS 4C" },
                { "KS AH 2H 3C 4H KC 2C TC 2D AS" },
                { "AH 2C 9S AD 3C QH KS JS JD KD" },
                { "6C 9C 8C 2D 7C 2H TC 4C 9S AH" },
                { "3D 5S 2H QD TD 6S KH 9H AD QH" }
        };
        return Arrays.asList(data);
    }

    @Test
    public void runGames() {
        GameRunner gameRunner = new GameRunner();
        gameRunner.runLine(gameLine);
    }
}
