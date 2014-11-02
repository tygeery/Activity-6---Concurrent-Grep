import java.util.ArrayList;
import java.util.List;

/**
 * File created by jcdesimp on 10/31/14.
 * Object to be wrapped by a future representing matching
 * lines in a file
 */
public class Found {
    private String fileName;
    private List<String> matchingLines;

    /**
     * Constructor for Found
     * @param fileName name of file that was processed
     */
    public Found(String fileName) {
        this.fileName = fileName;
        this.matchingLines = new ArrayList<String>();
    }

    public static Found getNewFound(String fName) {
        return new Found(fName);
    }

    /**
     * Get the name of the file
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Add a string to the found list
     * @param s string, line to add
     */
    public void addFoundLine(String s) {
        matchingLines.add(s);
    }

    /**
     * Print each line that was found
     * if no lines, then nothing is printed.
     */
    public void printFoundLines() {
        System.out.println(fileName);
        for (String line : matchingLines) {
            System.out.println(line);
        }

    }
}
