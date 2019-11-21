package framework.base;

import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseElement {

    private By buttonLocator;
    private String elementName;
    static final Logger log = Logger.getLogger(BaseElement.class);
    private Actions actions;

    public BaseElement(String name, By locator) {
        this.buttonLocator = locator;
        this.elementName = name;
    }

    public void click() {
        log.info(this.elementName + " clicked");
        Browser.getDriver().findElement(buttonLocator).click();
    }

    public void hover() {
        actions = new Actions(Browser.getDriver());
        actions.moveToElement(Browser.getDriver().findElement(this.buttonLocator)).perform();
    }

    public void select(By by, String key) {
        new Select(Browser.getDriver().findElement(by)).selectByVisibleText(key);
    }

    public String getText() {
        return Browser.getDriver().findElement(this.buttonLocator).getText();
    }

    public boolean isDisplayed() {
        boolean existence = false;
        if (Browser.getDriver().findElements(this.buttonLocator).size() > 0)
            existence = true;
        return existence;
    }

}
