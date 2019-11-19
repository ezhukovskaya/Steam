package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageObjects.elements.Banner;
import pageObjects.elements.Button;
import utils.propertiesManager.PropertiesRead;
import utils.waits.WebElementWait;

public class MainPage {
    //LOCATORS
    private By downloadButtonLocator = By.xpath("//*[@id=\"global_action_menu\"]/div[1]/a");
    private By homePageBannerLocator = By.xpath("//*[@id=\"logo_holder\"]/a/img");
    private By gameCategoryLocator = By.xpath("//*[@id=\"genre_tab\"]/span/a[1]");
    private By actionsLocator = By.xpath(String.format("//*[@id=\"genre_flyout\"]//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("action")));
    private By indieLocator = By.xpath(String.format("//*[@id=\"genre_flyout\"]//a[contains(text(), '%s')]", PropertiesRead.readFromPropertiesFile("indie")));
    //BUTTONS
    private Button goToDownloadPageButton;
    private Button goToGameCategory;
    private Button actionsButton;
    private Button indieButton;
    //BANNERS
    private Banner homePageBanner;
    //NAMES FOR LOGS
    private String goToDownloadPageButtonName = "goToDownloadPageButton";
    private String homePageBannerName = "homePageBanner";
    private String goToGameCategoryName = "goToGameCategory";
    private String actionsName = "actions";
    private String indieName = "indie";
    //OBJECTS
    private Actions actions;

    public MainPage() {
        goToDownloadPageButton = new Button(goToDownloadPageButtonName, downloadButtonLocator);
        homePageBanner = new Banner(homePageBannerName, homePageBannerLocator);
        goToGameCategory = new Button(goToGameCategoryName, gameCategoryLocator);
        actionsButton = new Button(actionsName, actionsLocator);
        indieButton = new Button(indieName, indieLocator);
    }

    public void goToDownloadApp() {
        goToDownloadPageButton.click();
    }


    public boolean isHomePageDisplayed() {
        return homePageBanner.isDisplayed();
    }

    public void gamesCategoryPerform(){
        actions = new Actions(Browser.getDriver());
        actions.moveToElement(goToGameCategory.getElementByLocator(gameCategoryLocator)).perform();
    }

    public void goToActions(){
        actionsButton.click();
    }

    public void goToIndie(){
        indieButton.click();
    }

}
