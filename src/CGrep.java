import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tyler on 10/28/14.
 * Main Driver
 */
public class CGrep {


    public static void main(String [ ] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(3);
        final ExecutorCompletionService completionService = new ExecutorCompletionService(pool);

    }


}
