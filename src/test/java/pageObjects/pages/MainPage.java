package pageObjects.pages;

import framework.base.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.InstallForm;
import pageObjects.forms.MainMenu;

public class MainPage {
    private By homePageBannerLocator = By.xpath("//*[@id='logo_holder']/a/img");
    private Banner homePageBanner;
    private String homePageBannerName = "homePageBanner";


    public MainPage() {
        homePageBanner = new Banner(homePageBannerName, homePageBannerLocator);
    }

    public InstallForm goToDownloadApp() {
        return new InstallForm();
    }


    public boolean isHomePageDisplayed() {
        return homePageBanner.isDisplayed();
    }

    public MainMenu goToMainMenu() {
        return new MainMenu();
    }
}
