package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MinThread minThread = new MinThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        minThread.start();
        maxThread.start();

        LOGGER.info(minThread.getName() + " started");
        LOGGER.info(maxThread.getName() + " starged");

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info(minThread.getName() + " finished");
        LOGGER.info(maxThread.getName() + " finished");

        return Map.of("min", minThread.getMin(), "max", maxThread.getMax());
    }
    // END
}
