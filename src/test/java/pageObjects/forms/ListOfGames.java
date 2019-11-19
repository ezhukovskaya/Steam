package pageObjects.forms;

import org.openqa.selenium.By;
import pageObjects.elements.Button;
import utils.propertiesManager.PropertiesRead;

public class ListOfGames {;
    private By actionsLocator = By.xpath(String.format("//*[@id=\"genre_flyout\"]//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("action")));
    private By indieLocator = By.xpath(String.format("//*[@id=\"genre_flyout\"]//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("indie")));

    private Button actionsButton;
    private Button indieButton;

    private String actionsName = "actions";
    private String indieName = "indie";


    public void goToActions(){
        actionsButton = new Button(actionsName, actionsLocator);
        actionsButton.click();
    }

    public void goToIndie(){
        indieButton = new Button(indieName, indieLocator);
        indieButton.click();
    }
}
