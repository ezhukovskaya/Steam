package pageObjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pageObjects.elements.Banner;
import pageObjects.elements.Button;
import pageObjects.forms.MainMenu;

public class MainPage {
    //LOCATORS
    private By downloadButtonLocator = By.xpath("//*[@id=\"global_action_menu\"]/div[1]/a");
    private By homePageBannerLocator = By.xpath("//*[@id=\"logo_holder\"]/a/img");
    //BUTTONS
    private Button goToDownloadPageButton;
    //BANNERS
    private Banner homePageBanner;
    //NAMES FOR LOGS
    private String goToDownloadPageButtonName = "goToDownloadPageButton";
    private String homePageBannerName = "homePageBanner";
    static final Logger log = Logger.getLogger(MainPage.class);


    public MainPage() {
        goToDownloadPageButton = new Button(goToDownloadPageButtonName, downloadButtonLocator);
        homePageBanner = new Banner(homePageBannerName, homePageBannerLocator);
    }

    public void goToDownloadApp() {
        goToDownloadPageButton.click();
        log.info(goToDownloadPageButtonName + " clicked");
    }


    public boolean isHomePageDisplayed() {
        return homePageBanner.isDisplayed();
    }

    public MainMenu goToMainMenu() {
        return new MainMenu();
    }
}
