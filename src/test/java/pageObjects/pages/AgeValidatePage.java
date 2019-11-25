package pageObjects.pages;

import framework.elements.Button;
import framework.elements.DropDown;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class AgeValidatePage {
    private By ageValideLocator = By.xpath("//*[@id='ageYear']");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Button viewPage = new Button("viewPage", viewPageLocator);
    private String ageName = "ageButton";
    private String bornYear = "2000";
    private DropDown ageList = new DropDown(ageName, ageValideLocator);


    public boolean isPageExists() {
        return viewPage.isDisplayed();
    }

    public void ageValidate() {
        ageList.click();
        ageList.select(bornYear);
        viewPage.click();
        Waiter.waitUntilInvisible(ageValideLocator);
    }
}
