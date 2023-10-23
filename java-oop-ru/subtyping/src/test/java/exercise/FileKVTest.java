package exercise;

import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private static Path sampleJson = Paths.get("src/test/resources/sample.json").toAbsolutePath().normalize();
    private static Path sample = Paths.get("src/test/resources/sample").toAbsolutePath().normalize();


    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

   @Test
    public void testFileKV() {
        FileKV storage  = new FileKV(sample.toString(), Map.of(
                "key1", "value1", "key2", "value2"
        ));
        storage.writeToFile();
        assertThat(Utils.readFile(sample.toString())).isEqualTo(Utils.readFile(sampleJson.toString()));
        storage.writeToFile();
        assertThat(storage.toMap()).isEqualTo(Map.of("key1", "value1", "key2", "value2"));
        storage.set("k", "v");
        assertThat(storage.toMap()).isNotEqualTo(Map.of("key1", "value1", "key2", "value2"));
    }
}
