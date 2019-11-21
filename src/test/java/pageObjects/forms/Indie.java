package pageObjects.forms;

import framework.base.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Indie extends Genres {
    private By indieLocator = By.xpath(String.format("//*[@id='genre_flyout']//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("indie")));
    private Button indieButton;

    private String indieName = "indie";
    static final Logger log = Logger.getLogger(Indie.class);

    public Indie() {
        indieButton = new Button(indieName, indieLocator);
        log.info(indieName + " clicked");
        indieButton.click();
    }
}
