package framework.utils.propertiesManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesRead {
    private static Properties prop = new Properties();
    private static String path;

    /**
     * конструктор с определением конфиг файла
     */
    public static void propertiesRead(String language) {
        if (language.equals("en")) {
            path = XMLRead.xmlReader("enfile");
        }
        if (language.equals("ru")) {
            path = XMLRead.xmlReader("rufile");
        }
        try {
            InputStream input = new FileInputStream(path);
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
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
