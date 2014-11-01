import java.io.File;
import java.util.concurrent.*;

/**
 * Created by Tyler on 10/28/14.
 * Main Driver
 */
public class CGrep {

    /**
     * Main driver method
     * @param args given at commandline, expected ot be filenames
     */
    public static void main(String [ ] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(3);
        final CompletionService<Found> completionService = new ExecutorCompletionService<Found>(pool);

        // Make sure at least the pattern argument is given
        if (args.length < 1) {
            System.out.println("usage: java CGrep pattern [file . . .]");
            return;
        }

        // set the pattern for later use
        String pattern = args[0];

        // Iterate each filename
        for (int i = 1; i < args.length; i++) {
            File f = new File(args[i]);
            if (f.exists()) {
                completionService.submit(new FileGrep<Found>(f, pattern));
            } else {
                System.out.println("File " + args[i] + "not found!");
            }
        }

        // shutdown the pool so no more tasks can be added
        pool.shutdown();

        try {
            // Check if the pool is terminated
            // if not then a future is waiting for retrieval
            // or not all tasks have completed yet
            while (!pool.isTerminated()) {
                // get the latest completed future
                final Future<Found> fut = completionService.take();
                // output the pattern matching lines
                fut.get().printFoundLines();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
