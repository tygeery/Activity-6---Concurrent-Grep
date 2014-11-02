import java.io.*;
import java.util.concurrent.Callable;

/**
 * File created by jcdesimp on 10/31/14.
 * Class that implements callable
 * to perform the file searching concurrently
 */
public class FileGrep implements Callable {

    private File fileToGrep;
    private String pattern;

    /**
     * Constructor for FileGrap
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
        String line = "";
        String complete_pattern = ".*" + pattern + ".*";
        int line_num = 1;
        Found found_lines = new Found(fileToGrep.getName());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToGrep));
            while((line = reader.readLine()) != null)
            {
                if (line.matches(complete_pattern))
                {
                    String result = Integer.toString(line_num) + " " + line;
                    found_lines.addFoundLine(result);

                }
                line_num++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found_lines;
        //return null;
    }
}
