package framework.base;

import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {

    protected By buttonLocator;
    protected String elementName;
    static final Logger log = Logger.getLogger(BaseElement.class);
    private Actions actions = new Actions(Browser.getBrowser());

    public BaseElement(String name, By locator) {
        this.buttonLocator = locator;
        this.elementName = name;
    }

    public void click() {
        log.info(this.elementName + " clicked");
        Browser.getBrowser().findElement(buttonLocator).click();
    }

    public void hover() {
        log.info(this.elementName + "hovered");
        actions.moveToElement(Browser.getBrowser().findElement(this.buttonLocator)).perform();
    }

    public String getText() {
        return Browser.getBrowser().findElement(this.buttonLocator).getText();
    }

    public boolean isDisplayed() {
        log.info(this.elementName + " is checking if displayed");
        return Browser.getBrowser().findElements(this.buttonLocator).size() > 0;
    }

}
