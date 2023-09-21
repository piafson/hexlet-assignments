package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AppTest {

    @Test
    void testTake() {
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result1 = App.take(numbers1, 2);
        Assertions.assertEquals(result1.size(), 2);
        Assertions.assertEquals(result1.get(0), 1);
        Assertions.assertEquals(result1.get(1), 2);
        Assertions.assertEquals(result1.toString(), "[1, 2]");


        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = App.take(numbers2, 8);
        Assertions.assertEquals(result2.size(), 3);
        Assertions.assertEquals(result2.get(1), 3);
        Assertions.assertEquals(result2.get(2), 10);
        Assertions.assertEquals(result2.toString(), "[7, 3, 10]");
    }
}
