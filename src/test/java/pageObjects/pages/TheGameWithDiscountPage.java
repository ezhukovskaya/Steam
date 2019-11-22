package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import regex.RegEx;

public class TheGameWithDiscountPage {
    private By gamePricesLocator = By.xpath("//div/div[contains(@class,'discount_block game_purchase_discount')]");
    private String gamePricesName = "Game Prices";
    private Banner prices = new Banner(gamePricesName, gamePricesLocator);

    public String getPricesFromGamePage() {
        return RegEx.getOnlyValuesOfPrices(prices.getText());
    }
}
