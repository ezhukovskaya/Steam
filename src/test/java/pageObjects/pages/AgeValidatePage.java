package pageObjects.pages;

import framework.elements.Button;
import framework.elements.DropDown;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class AgeValidatePage {
    private By ageValideLocator = By.xpath("//*[@id='ageYear']");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Button viewPage = new Button("viewPage", viewPageLocator);
    private DropDown ageList = new DropDown("ageButton", ageValideLocator);


    public boolean isPageExists() {
        return viewPage.isDisplayed();
    }

    public void ageValidate(String bornYear) {
        ageList.click();
        ageList.select(bornYear);
        viewPage.click();
        Waiter.waitUntilInvisible(ageValideLocator);
    }
}
