package framework.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesRead {
    private static Properties prop = new Properties();
    private static String path;
    static final Logger log = Logger.getLogger(PropertiesRead.class);


    /**
     * чтение параметров из config
     *
     * @param key передаваемое название параметра
     * @return prop.getProperty(key)
     */
    public static String readFromDictionary(String key) {
        String language = XMLRead.xmlReader("language");
        log.info("Data of " + key + " is read from property");
        if (language.equals("en")) {
            path = "src/test/java/resources/enConfig.properties";
        }
        if (language.equals("ru")) {
            path = "src/test/java/resources/ruConfig.properties";
        }
        try {
            InputStream input = new FileInputStream(path);
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return prop.getProperty(key);
    }

    public static String readFromFrameworkConfig(String key) {
        path = "src/test/java/resources/config.properties";
        try {
            InputStream input = new FileInputStream(path);
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return prop.getProperty(key);
    }
}
