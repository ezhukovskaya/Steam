package pageObjects.pages;

import framework.base.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pageObjects.forms.Indie;

public class AgeValidatePage {
    private By ageValideLocator = By.xpath("//*[@id='ageYear']");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Button age;
    private Button viewPage;
    private String ageName = "ageButton";
    private String viewPageName = "viewPage";
    private String bornYear = "2000";
    private String ageListId = "ageYear";
    private By ageLocator = By.id(ageListId);

    public AgeValidatePage() {
        age = new Button(ageName, ageValideLocator);
        viewPage = new Button(viewPageName, viewPageLocator);
    }

    public boolean isPageExists () {
        return viewPage.isDisplayed();
    }

    public void ageValidate() {
        age.click();
        age.select(ageLocator,bornYear);
        viewPage.click();
    }
}
