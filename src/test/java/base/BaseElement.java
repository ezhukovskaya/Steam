package base;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    private By buttonLocator;
    private String elementName;

    public BaseElement(String name, By locator){
        this.buttonLocator = locator;
        this.elementName = name;
    }

    public void click(){
        Browser.getDriver().findElement(buttonLocator).click();
    }

    public WebElement getElementByLocator(By by) {
        return Browser.getDriver().findElement(by);
    }

    public boolean isDisplayed(){
        return Browser.getDriver().findElement(buttonLocator).isDisplayed();
    }

}
