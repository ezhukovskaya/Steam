package pageObjects.forms;

import framework.base.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TabBar {
    private final String TAB_BAR_CATEGORY = PropertiesRead.readFromDictionary("tabbar");
    private String tabBarLocator = "//*[@class='tabbar store_horizontal_minislider']";
    static final Logger log = Logger.getLogger(MainMenu.class);

    private Button getTabBarButton(String buttonName, String locator) {
        By elementLocator = By.xpath(String.format(locator + "//a[contains(text(), '%s')]", buttonName));
        return new Button(buttonName, elementLocator);
    }

    public ListOfGames getTabBarCategory() {
        Button tabBarButton = getTabBarButton(TAB_BAR_CATEGORY, tabBarLocator);
        tabBarButton.click();
        return new ListOfGames();
    }
}
