package utils.propertiesManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private static Properties prop = new Properties();
    private static String path = "src/test/java/resources/config.properties";

    /**
     * конструктор с определением конфиг файла
     */
    public static void propertiesRead() {
        try {
            InputStream input = new FileInputStream(path);
            prop.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    /**
     * чтение параметров из config
     *
     * @param key передаваемое название параметра
     * @return prop.getProperty(key)
     */
    public static String readFromPropertiesFile(String key) {
        return prop.getProperty(key);
    }
}
