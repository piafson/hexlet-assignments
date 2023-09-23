package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testDoubleStringNull() {
        assertThat(App.enlargeArrayImage(null)).isEqualTo(null);
    }

    @Test
    void testDoubleArray() {
        String[][] image = {
            {"*", "*", "*", "*"},
            {"*", " ", " ", "*"},
            {"*", " ", " ", "*"},
            {"*", "*", "*", "*"},
        };

        String[][] imageLarged = {
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
        };

        String[][] enlargedImage = App.enlargeArrayImage(image);
        assertThat(imageLarged).isEqualTo(enlargedImage);
    }
}



