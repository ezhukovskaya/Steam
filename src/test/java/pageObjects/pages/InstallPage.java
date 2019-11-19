package pageObjects.pages;

import org.openqa.selenium.By;
import pageObjects.elements.Banner;
import pageObjects.elements.Button;
import utils.fileManager.FileManager;
import utils.propertiesManager.XMLRead;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class InstallPage {
    private By installButtonLocator = By.xpath("//*[@id=\"about_greeting\"]/div[4]/div[1]");
    private By welcomeToSteamLocator = By.xpath("//*[@id=\"about_greeting\"]/div[1]/img");
    private Button goToInstallPageButton;
    private Banner welcomeToSteam;
    private String goToInstallPageButtonName = "goToInstallPageButton";
    private String welcomeToSteamName = "welcomeBanner";
    private String downloadFilePath;
    private String downloadFileName = "steam_latest.deb";

    public InstallPage() {
        goToInstallPageButton = new Button(goToInstallPageButtonName, installButtonLocator);
        welcomeToSteam = new Banner(welcomeToSteamName, welcomeToSteamLocator);
        downloadFilePath = XMLRead.xmlReader("path");
    }

    public void downloadClient() throws InterruptedException {
        goToInstallPageButton.click();
    }

    public boolean isWelcomeToSteamDisplayed() {
        return welcomeToSteam.isDisplayed();
    }

    public boolean isDownloaded(){
        return FileManager.isFileDownloaded(downloadFilePath, downloadFileName);
    }
}
