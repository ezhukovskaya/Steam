package pageObjects.pages;

import org.openqa.selenium.By;
import pageObjects.elements.Banner;
import pageObjects.elements.Button;

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

    public MainPage() {
        goToDownloadPageButton = new Button(goToDownloadPageButtonName, downloadButtonLocator);
        homePageBanner = new Banner(homePageBannerName, homePageBannerLocator);
    }

    public void goToDownloadApp() {
        goToDownloadPageButton.click();
    }


    public boolean isHomePageDisplayed() {
        return homePageBanner.isDisplayed();
    }


}
