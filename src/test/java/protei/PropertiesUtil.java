package protei;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties loadProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Error in loading config.properties");
        }
    }
}
