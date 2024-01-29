package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private final int[] numbers;

    private int min;

    public int getMin() {
        return min;
    }

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = Arrays.stream(numbers)
                .min()
                .orElse(0);
    }
}
// END
