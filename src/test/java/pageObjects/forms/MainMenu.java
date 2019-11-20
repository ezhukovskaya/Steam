package pageObjects.forms;

import framework.base.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MainMenu {
    private By gameCategoryLocator = By.xpath("//*[@id='genre_tab']/span/a[1]");
    private String goToGameCategoryName = "goToGameCategory";
    private Button goToGameCategory = new Button(goToGameCategoryName, gameCategoryLocator);
    static final Logger log = Logger.getLogger(MainMenu.class);


    public Genres goToGamesCategory() {
        log.info(goToGameCategoryName + " clicked");
        goToGameCategory.hover();
        return new Genres();
    }

}
