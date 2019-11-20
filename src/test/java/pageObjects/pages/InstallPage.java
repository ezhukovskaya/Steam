package pageObjects.pages;

import framework.utils.fileManager.FileManager;
import framework.utils.propertiesManager.XMLRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pageObjects.elements.Banner;
import pageObjects.elements.Button;

public class InstallPage {
    private By installButtonLocator = By.xpath("//*[@id=\"about_greeting\"]/div[4]/div[1]");
    private By welcomeToSteamLocator = By.xpath("//*[@id=\"about_greeting\"]/div[1]/img");
    private Button goToInstallPageButton;
    private Banner welcomeToSteam;
    private String goToInstallPageButtonName = "goToInstallPageButton";
    private String welcomeToSteamName = "welcomeBanner";
    private String downloadFilePath;
    private String downloadFileName = "steam_latest.deb";
    private final String PATH = "path";
    static final Logger log = Logger.getLogger(InstallPage.class);

    public InstallPage() {
        goToInstallPageButton = new Button(goToInstallPageButtonName, installButtonLocator);
        welcomeToSteam = new Banner(welcomeToSteamName, welcomeToSteamLocator);
        downloadFilePath = String.format(System.getProperty("user.dir"), XMLRead.xmlReader(PATH));
    }

    public void downloadClient() {
        goToInstallPageButton.click();
        log.info(goToInstallPageButtonName + " clicked");
    }

    public boolean isWelcomeToSteamDisplayed() {
        return welcomeToSteam.isDisplayed();
    }

    public boolean isDownloaded() {
        return FileManager.isFileDownloaded(downloadFilePath, downloadFileName);
    }
}
