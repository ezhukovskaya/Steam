package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import framework.utils.FileManager;
import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class InstallPage {
    private By installButtonLocator = By.xpath("//*[@class='about_install_steam_link']");
    private By welcomeToSteamLocator = By.xpath("//*[@class='steam_logo']");
    private Button goToInstallPageButton = new Button("goToInstallPageButton", installButtonLocator);
    private Banner welcomeToSteam = new Banner("welcomeBanner", welcomeToSteamLocator);
    private String goToInstallPageButtonName = "goToInstallPageButton";
    private String downloadFilePath = String.format(System.getProperty("user.dir"), PropertiesRead.readFromFrameworkConfig("path"));
    private String downloadFileName = "steam_latest.deb";
    static final Logger log = Logger.getLogger(InstallPage.class);

    public void downloadClient() {
        log.info(goToInstallPageButtonName + " clicked");
        goToInstallPageButton.click();
    }

    public boolean isWelcomeToSteamDisplayed() {
        return welcomeToSteam.isDisplayed();
    }

    public boolean isDownloaded() {
        return FileManager.isFileDownloaded(downloadFilePath, downloadFileName);
    }
}
