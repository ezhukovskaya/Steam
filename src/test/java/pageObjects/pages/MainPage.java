package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import utils.WebElementWait;

public class MainPage {
    private By downloadButtonLocator = By.xpath("//*[@id=\"global_action_menu\"]/div[1]/a");
    private By installButtonLocator = By.xpath("//*[@id=\"about_greeting\"]/div[4]/div[1]");

    public void goToDownloadApp() {
        Browser.click(downloadButtonLocator);
    }

    public void downloadClient() {
        Browser.click(installButtonLocator);
    }
}
