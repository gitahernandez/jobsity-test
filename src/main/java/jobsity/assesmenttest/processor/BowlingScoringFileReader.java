package jobsity.assesmenttest.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import jobsity.assesmenttest.commons.FileReader;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class BowlingScoringFileReader extends FileReader {

    String separator;

    public BowlingScoringFileReader(String separator, String pathFile) {
        super(pathFile);
        this.separator = separator;

    }

    public Stream<String> readFile() {

        Path path = this.getFileFromPath(this.pathFile);
        Stream<String> stream = null;
        try {
            stream = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Error Reading Bowling Score Input File...");
        }
        return stream;
    }

}
