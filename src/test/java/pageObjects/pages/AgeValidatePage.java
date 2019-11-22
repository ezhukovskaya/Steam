package pageObjects.pages;

import framework.elements.Button;
import framework.elements.DropDown;
import org.openqa.selenium.By;

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
    private DropDown ageList = new DropDown(ageName,ageValideLocator);

    public AgeValidatePage() {
        age = new Button(ageName, ageValideLocator);
        viewPage = new Button(viewPageName, viewPageLocator);
    }

    public boolean isPageExists () {
        return viewPage.isDisplayed();
    }

    public void ageValidate() {
        ageList.click();
        ageList.select();
        viewPage.click();
    }
}
