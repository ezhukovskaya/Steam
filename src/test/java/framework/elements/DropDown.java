package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {

    public DropDown(String name, By locator) {
        super(locator, name);
    }

    public void select(String key) {
        new Select(Browser.getBrowser().findElement(buttonLocator)).selectByVisibleText(key);
    }

}
