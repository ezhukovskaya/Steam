package pageObjects.forms;

import browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageObjects.elements.Button;
import pageObjects.pages.MainPage;

public class MainMenu {
    private Button goToGameCategory;
    private By gameCategoryLocator = By.xpath("//*[@id=\"genre_tab\"]/span/a[1]");
    private String goToGameCategoryName = "goToGameCategory";
    private Actions actions;
    static final Logger log = Logger.getLogger(MainMenu.class);
    public ListOfGames goToGamesCategory(){
        goToGameCategory = new Button(goToGameCategoryName, gameCategoryLocator);
        actions = new Actions(Browser.getDriver());
        actions.moveToElement(goToGameCategory.getElementByLocator(gameCategoryLocator)).perform();
        log.info(goToGameCategoryName + " clicked");
        return new ListOfGames();
    }

}
