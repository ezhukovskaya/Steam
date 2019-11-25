package pageObjects.forms;

import framework.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class InstallForm {
    private By downloadButtonLocator = By.xpath("//*[@id='global_action_menu']/div[1]/a");
    private String goToDownloadPageButtonName = "goToDownloadPageButton";
    private Button goToDownloadPageButton = new Button(goToDownloadPageButtonName, downloadButtonLocator);
    static final Logger log = Logger.getLogger(InstallForm.class);

    public InstallForm() {
        log.info(goToDownloadPageButtonName + " clicked");
        goToDownloadPageButton.click();
    }
}
