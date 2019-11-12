package pageObjects.elements;

import base.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {
    private By downloadButtonLocator = By.xpath("//*[@id=\"global_action_menu\"]/div[1]/a");
    private By installButtonLocator = By.xpath("//*[@id=\"about_greeting\"]/div[4]/div[1]");
}
