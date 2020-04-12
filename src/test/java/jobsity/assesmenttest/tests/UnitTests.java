package jobsity.assesmenttest.tests;

import jobsity.assesmenttest.objects.BoardDTO;
import jobsity.assesmenttest.objects.PlayerDTO;
import jobsity.assesmenttest.processor.BowlingScoring;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class UnitTests {

    public UnitTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void validateInputTrue() {

        BowlingScoring bowlingScore = new BowlingScoring();
        Stream<String> stream = Stream.of("Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Angie 1", "Angie 7", "Angie 3", "Angie 9", "Angie 0", "Angie 10", "Angie 0", "Angie 8", "Angie 8", "Angie 2", "Angie 0", "Angie 6", "Angie 10", "Angie 10", "Angie 10", "Angie 8", "Angie 1");
        boolean result = bowlingScore.validateInput(stream);
        assertEquals(true, result);
    }

    @Test
    public void validateInputFalse() {

        BowlingScoring bowlingScore = new BowlingScoring();
        Stream<String> stream = Stream.of(" &&", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Angie 1", "Angie 7", "Angie 3", "Angie 9", "Angie 0", "Angie 10", "Angie 0", "Angie 8", "Angie 8", "Angie 2", "Angie 0", "Angie 6", "Angie 10", "Angie 10", "Angie 10", "Angie 8", "Angie 1");
        boolean result = bowlingScore.validateInput(stream);
        assertEquals(false, result);
    }

    @Test
    public void convertInputInGameInformation() {

        Gson gson = new Gson();
        BowlingScoring bowlingScore = new BowlingScoring();
        Stream<String> stream = Stream.of("Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Angie 1", "Angie 7", "Angie 3", "Angie 9", "Angie 0", "Angie 10", "Angie 0", "Angie 8", "Angie 8", "Angie 2", "Angie 0", "Angie 6", "Angie 10", "Angie 10", "Angie 10", "Angie 8", "Angie 1");

        String expectedBoardDTOjson = "{\"frames\":[{\"number\":1,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":2,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":3,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":4,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":5,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":6,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":7,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":8,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":9,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":10,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":11,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":12,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":1,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":1,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":7,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":2,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":3,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":9,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":3,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":10,\"type\":\"SPARE\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":4,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":5,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":2,\"type\":\"SPARE\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":6,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":6,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":7,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":8,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":9,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":10,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":1,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"}],\"players\":[{\"name\":\"Felipe\"},{\"name\":\"Angie\"}]}";
        BoardDTO expectedBoardDTO = gson.fromJson(expectedBoardDTOjson, BoardDTO.class);

        BoardDTO boardDTO = bowlingScore.convertInputInGameInformation(stream);

        assertEquals(expectedBoardDTO.getPlayers().size(), boardDTO.getPlayers().size());
        assertEquals(expectedBoardDTO.getFrames().size(), boardDTO.getFrames().size());
        assertEquals(expectedBoardDTO.getPlayers().get(0).getName(), boardDTO.getPlayers().get(0).getName());
        assertEquals(expectedBoardDTO.getPlayers().get(1).getName(), boardDTO.getPlayers().get(1).getName());
    }

    @Test
    public void calculateScoreByPlayer() {

        Gson gson = new Gson();
        BowlingScoring bowlingScore = new BowlingScoring();

        String expectedBoardDTOjson = "{\"frames\":[{\"number\":1,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":2,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":3,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":4,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":5,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":6,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":7,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":8,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":9,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":10,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":11,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":12,\"playerDTO\":{\"name\":\"Felipe\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":1,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":1,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":7,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":2,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":3,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":9,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":3,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":10,\"type\":\"SPARE\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":4,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":5,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":2,\"type\":\"SPARE\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":6,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":0,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":6,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":7,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":8,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":9,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":10,\"type\":\"STRIKE\"},\"secondRollDTO\":{\"pinfalls\":0,\"type\":\"NONEED\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"},{\"number\":10,\"playerDTO\":{\"name\":\"Angie\"},\"firstRollDTO\":{\"pinfalls\":8,\"type\":\"NORMAL\"},\"secondRollDTO\":{\"pinfalls\":1,\"type\":\"NORMAL\"},\"score\":0,\"PinFallsText\":\"\",\"scoreText\":\"\"}],\"players\":[{\"name\":\"Felipe\"},{\"name\":\"Angie\"}]}";
        BoardDTO expectedBoardDTO = gson.fromJson(expectedBoardDTOjson, BoardDTO.class);

        ArrayList<PlayerDTO> PlayerDTOList = bowlingScore.calculateScoreByPlayer(expectedBoardDTO.getPlayers(), expectedBoardDTO.getFrames());

        assertEquals("PinFalls \t\t X\t X\t X\t X\t X\t X\t X\t X\t X\t X X X", PlayerDTOList.get(0).getPinFallsText());
        assertEquals("Score \t\t\t30\t60\t90\t120\t150\t180\t210\t240\t270\t300", PlayerDTOList.get(0).getScoreText());

    }
}
