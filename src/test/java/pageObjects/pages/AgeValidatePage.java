package pageObjects.pages;

import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import pageObjects.elements.Button;

public class AgeValidatePage {
    private By ageValideLocator = By.xpath("//*[@id=\"ageYear\"]");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Button age;
    private Button viewPage;
    private String ageName = "ageButton";
    private String viewPageName = "viewPage";
    private String bornYear = "2000";
    private String ageListId = "ageYear";

    public AgeValidatePage() {
        age = new Button(ageName, ageValideLocator);
        viewPage = new Button(viewPageName, viewPageLocator);
    }

    public boolean pageIsExisted() {
        boolean existence = false;
        try {
            if (viewPage.isDisplayed()) {
                existence = true;
            }
        } catch (NoSuchElementException e) {
            existence = false;
        }
        return existence;
    }

    public void ageValidate() {
        age.click();
        new Select(Browser.getDriver().findElement(By.id(ageListId))).selectByVisibleText(bornYear);
        viewPage.click();
    }
}
