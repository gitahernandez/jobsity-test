package jobsity.assesmenttest.main;

import jobsity.assesmenttest.objects.BoardDTO;
import jobsity.assesmenttest.processor.BowlingScoring;
import jobsity.assesmenttest.processor.BowlingScoringFileReader;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class BowlingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String pathFile = "/Users/andresfelipehernandezrocha/Desktop/file.txt";
        String separator = " ";

        BowlingScoringFileReader bowlingScoreFileReader = new BowlingScoringFileReader(separator, pathFile);

        Supplier<Stream<String>> streamSupplier = () -> bowlingScoreFileReader.readFile();

        BowlingScoring bowlingScore = new BowlingScoring();

        if (bowlingScore.validateInput(streamSupplier.get())) {
            BoardDTO boardDTO = bowlingScore.convertInputInGameInformation(streamSupplier.get());
            boardDTO.setPlayers(bowlingScore.calculateScoreByPlayer(boardDTO.getPlayers(), boardDTO.getFrames()));
            bowlingScore.printScore(boardDTO.getPlayers());
        } else {
            System.out.println("There are errors in Input File, please check file");
        }

    }
}
