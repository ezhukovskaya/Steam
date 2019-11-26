package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class InstallPage {
    private By installButtonLocator = By.xpath("//*[@class='about_install_steam_link']");
    private By welcomeToSteamLocator = By.xpath("//*[@class='steam_logo']");
    private Button goToInstallPageButton = new Button("goToInstallPageButton", installButtonLocator);
    private Banner welcomeToSteam = new Banner("welcomeBanner", welcomeToSteamLocator);

    public void downloadClient() {
        goToInstallPageButton.click();
    }

    public boolean isWelcomeToSteamDisplayed() {
        return welcomeToSteam.isDisplayed();
    }

}
