package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.InstallForm;
import pageObjects.forms.MainMenu;

public class MainPage {
    private By homePageBannerLocator = By.xpath("//*[@class='home_page_content']");
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

    public MainMenu getMainMenu() {
        return new MainMenu();
    }
}
