package pageObjects.forms;

import framework.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TabBar {
    private final String TAB_BAR_CATEGORY = PropertiesRead.readFromDictionary("tabbar");
    private By tabBarLocator = By.xpath("//*[@id='tab_select_TopSellers']");
    static final Logger log = Logger.getLogger(MainMenu.class);
    private Button tabBarButton = new Button(TAB_BAR_CATEGORY, tabBarLocator);

    public ListOfGames getTabBarCategory() {
        tabBarButton.click();
        return new ListOfGames();
    }
}