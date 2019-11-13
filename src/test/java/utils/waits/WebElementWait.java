package utils.waits;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.propertiesManager.PropertiesRead;

public class WebElementWait {
    private static WebElementWait webElementWait;
    private static String timeout = "timeout";
    private static int timeoutValue = Integer.parseInt(PropertiesRead.readFromPropertiesFile(timeout));
    /**
     * метод для определения ожидания появления элемента
     *
     * @param by локатор для веб-элемента
     */
    public static void waiterForWebElement(By by) {
        WebElement dynamicElement = (new WebDriverWait(Browser.getDriver(), timeoutValue)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * возвращение значения веб-элемента
     *
     * @param by локатор
     * @return
     */
    public static WebElement getWebElement(By by) {
        return Browser.getDriver().findElement(by);
    }
}
