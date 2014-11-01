import java.io.File;
import java.util.concurrent.Callable;

/**
 * File created by jcdesimp on 10/31/14.
 * Class that implements callable
 * to perform the file searching concurrently
 */
public class FileGrep<Found> implements Callable<Found> {

    private File fileToGrep;
    private String pattern;

    /**
     * COnstructor for FileGrap
     * @param fileToGrep file that will be searched
     * @param pattern to search for
     */
    public FileGrep(File fileToGrep, String pattern) {
        this.fileToGrep = fileToGrep;
        this.pattern = pattern;
    }

    /**
     * Should parse files looking for pattern given in each line
     * @return Found object containing necessary data
     */
    @Override
    public Found call() {
        /**
         * TODO parse file, look for pattern matching lines (Using java.util.regex)
         * TODO You can call addFoundLine(String) on an instantiated Found
         * TODO to add each line, then return the fully constructed found object.
         */
        return null;
    }
}
