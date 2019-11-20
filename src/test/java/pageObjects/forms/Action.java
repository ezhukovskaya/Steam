package pageObjects.forms;

import framework.base.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Action extends Genres {
    private By actionsLocator = By.xpath(String.format("//*[@id='genre_flyout']//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("action")));
    private Button actionsButton;
    private String actionsName = "actions";
    static final Logger log = Logger.getLogger(Action.class);

    public Action() {
        actionsButton = new Button(actionsName, actionsLocator);
        log.info(actionsName + " clicked");
        actionsButton.click();
    }
}
