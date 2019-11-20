package framework.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private static Pattern pattern;
    private static final String REG_EX = " USD";
    private static final String EMPTY = "";

    public static String onlyPrices(String prices) {
        pattern = Pattern.compile(REG_EX);
        Matcher matcher = pattern.matcher(prices);
        return matcher.replaceAll(EMPTY);
    }
}
