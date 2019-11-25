package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import regex.RegEx;

public class TheGameWithDiscountPage {
    private By gamePricesLocator = By.xpath("//div/div[contains(@class,'discount_block game_purchase_discount')]");
    private String gamePricesName = "Game Prices";
    private Banner prices = new Banner(gamePricesName, gamePricesLocator);
    private By goToMainMenu = By.xpath("//*[@id='logo_holder']");
    private Button mainMenu = new Button("Main Menu Button", goToMainMenu);

    public String getPricesFromGamePage() {
        return RegEx.getOnlyValuesOfPrices(prices.getText());
    }

    public void goToMainMenuClick() {
        mainMenu.click();
    }
}
