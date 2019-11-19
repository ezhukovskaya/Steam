package utils.propertiesManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private static Properties prop = new Properties();
    private static String path;

    /**
     * конструктор с определением конфиг файла
     */
    public static void propertiesRead(String language) {
        if(language.equals("en")){
            path = XMLRead.xmlReader("enfile");
        }
        if(language.equals("ru")){
            path = XMLRead.xmlReader("rufile");
        }
        try {
            InputStream input = new FileInputStream(path);
            prop.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void localDictionary() throws FileNotFoundException {
        String language = readFromPropertiesFile("language");
        if(language.equals("en")){
            InputStream enInput = new FileInputStream(readFromPropertiesFile("enPath"));
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
