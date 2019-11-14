package pageObjects.elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {
    public Button(String name, By locator) {
        super(name, locator);
    }
}
