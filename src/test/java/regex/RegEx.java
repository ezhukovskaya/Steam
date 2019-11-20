package regex;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private static Pattern pattern;
    private static final String REG_EX = " USD";
    private static final String EMPTY = "";
    static final Logger log = Logger.getLogger(RegEx.class);

    public static String getOnlyValuesOfPrices(String prices) {
        log.info(REG_EX + " has been taken away from the prices values");
        pattern = Pattern.compile(REG_EX);
        Matcher matcher = pattern.matcher(prices);
        return matcher.replaceAll(EMPTY);
    }
}
