package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN

// END
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Car extract(Path path) {
        try {
            return Car.unserialize(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
