package utils.propertiesManager;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class LocaleMsgReader {

    private static ResourceBundle resource = null;
    private static Locale locale = null;

    public static  String getString(String code){
        resource = PropertyResourceBundle.getBundle("config", locale);
        String message = resource.getString(code).trim();
        return message;
    }
}
