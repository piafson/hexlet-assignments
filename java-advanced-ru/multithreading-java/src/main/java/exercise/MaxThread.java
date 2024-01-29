package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    private final int[] numbers;

    private int max;

    public int getMax() {
        return max;
    }

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = Arrays.stream(numbers)
                .max()
                .orElse(0);
    }
}
// END
