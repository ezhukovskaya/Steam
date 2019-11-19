package pageObjects.forms;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageObjects.elements.Button;

public class MainMenu {
    private Button goToGameCategory;
    private By gameCategoryLocator = By.xpath("//*[@id=\"genre_tab\"]/span/a[1]");
    private String goToGameCategoryName = "goToGameCategory";
    private Actions actions;
    public ListOfGames goToGamesCategory(){
        goToGameCategory = new Button(goToGameCategoryName, gameCategoryLocator);
        actions = new Actions(Browser.getDriver());
        actions.moveToElement(goToGameCategory.getElementByLocator(gameCategoryLocator)).perform();
        return new ListOfGames();
    }

}
