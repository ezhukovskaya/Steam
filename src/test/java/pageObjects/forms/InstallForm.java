package pageObjects.forms;

import framework.base.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class InstallForm {
    private By downloadButtonLocator = By.xpath("//*[@id='global_action_menu']/div[1]/a");
    private Button goToDownloadPageButton;
    private String goToDownloadPageButtonName = "goToDownloadPageButton";
    static final Logger log = Logger.getLogger(InstallForm.class);

    public InstallForm() {
        goToDownloadPageButton = new Button(goToDownloadPageButtonName, downloadButtonLocator);
        log.info(goToDownloadPageButtonName + " clicked");
        goToDownloadPageButton.click();
    }
}
