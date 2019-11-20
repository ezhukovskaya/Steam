package framework.utils.propertiesManager;

import framework.browser.Browser;
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
    public static String readFromPropertiesFile(String key) {
        String language = Browser.getLanguage();
        log.info("Data of " + key + " is read from property");
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
            log.info(e.getMessage());
        }
        return prop.getProperty(key);
    }
}
