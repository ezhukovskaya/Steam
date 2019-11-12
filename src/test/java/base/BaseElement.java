package base;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    public WebElement getElementByLocator(By by) {
        return Browser.getDriver().findElement(by);
    }
}
