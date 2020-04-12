package jobsity.assesmenttest.tests;

import jobsity.assesmenttest.objects.BoardDTO;
import jobsity.assesmenttest.processor.BowlingScoring;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;
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
public class IntegrationTests {

    public IntegrationTests() {
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
    public void integrationTestWith3Players() {
    	
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outContent));
    	
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Felipe 10", "Angie 10", "Angie 7", "Angie 3", "Angie 9", "Angie 0", "Angie 10", "Angie 0", "Angie 8", "Angie 8", "Angie 2", "Angie 0", "Angie 6", "Angie 10", "Angie 10", "Angie 10", "Angie 8", "Angie 1", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0", "Jhon 0" );
                
        BowlingScoring bowlingScore = new BowlingScoring();

        if (bowlingScore.validateInput(streamSupplier.get())) {
            BoardDTO boardDTO = bowlingScore.convertInputInGameInformation(streamSupplier.get());
            boardDTO.setPlayers(bowlingScore.calculateScoreByPlayer(boardDTO.getPlayers(), boardDTO.getFrames()));
            bowlingScore.printScore(boardDTO.getPlayers());
        } else {
            System.out.println("There are errors in Input File, please check file");
        }
        
        assertEquals(true, outContent.toString().contains("X	 X	 X	 X	 X	 X	 X	 X	 X	 X X X"));
        assertEquals(true, outContent.toString().contains("X	7 /	9 0	 X	0 8	8 /	0 6	 X	 X	 X 8 1"));
        assertEquals(true, outContent.toString().contains("0 0	0 0	0 0	0 0	0 0	0 0	0 0	0 0"));

    }
}

