package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.elements.Button;
import org.openqa.selenium.support.ui.Select;

public class AgeValidatePage{
    private By ageValideLocator = By.xpath("//*[@id=\"ageYear\"]");
    private By viewPageLocator = By.xpath("//*[@id=\"app_agegate\"]/div[1]/div[3]/a[1]");
    private Button age;
    private Button viewPage;
    private String ageName = "ageButton";
    private String viewPageName = "viewPage";

    public AgeValidatePage(){
        age = new Button(ageName,ageValideLocator);
        viewPage = new Button(viewPageName, viewPageLocator);
    }

    public Button getViewPage(){
        return viewPage;
    }

    public void ageValidate(){
        age.click();
        new Select(Browser.getDriver().findElement(By.id("ageYear"))).selectByVisibleText("2000");
        viewPage.click();
    }
}
