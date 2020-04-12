package jobsity.assesmenttest.commons;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class FileReader {

    public String pathFile;
    
    public FileReader(String pathFile) {
        this.pathFile = pathFile;
    }
    
    public Path getFileFromPath(String pathFile) {
        Path path = Paths.get(this.pathFile);
        return path;
    }
   
}
