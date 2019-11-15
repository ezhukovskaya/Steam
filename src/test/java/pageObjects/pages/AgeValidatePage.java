package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.elements.Button;
import org.openqa.selenium.support.ui.Select;

public class AgeValidatePage{
    private By ageValideLocator = By.xpath("//*[@id=\"ageYear\"]");
    private Button age;
    private String ageName = "ageButton";

    public AgeValidatePage(){
        age = new Button(ageName,ageValideLocator);
    }

    public void ageValidate(WebElement theCheapest){
        theCheapest.click();
        age.click();
        new Select(Browser.findElement(By.id("ageYear"))).selectByValue("2000");
    }
}
