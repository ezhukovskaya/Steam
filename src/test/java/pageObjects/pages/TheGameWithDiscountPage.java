package pageObjects.pages;

import framework.browser.Browser;
import org.openqa.selenium.By;

public class TheGameWithDiscountPage {
    private By gamePricesLocator = By.xpath("//div/div[contains(@class,\"discount_block game_purchase_discount\")]");

    public String getPricesFromPage() {
        return Browser.getDriver().findElement(gamePricesLocator).getText();
    }
}
