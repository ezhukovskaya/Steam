package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.elements.Button;
import utils.waits.WebElementWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ActionGamesPage {
    private By topSellingLocator = By.xpath("//*[@id=\"tab_select_TopSellers\"]/div");
    private By gamesLocator = By.xpath("//a/div[@class=\"discount_block tab_item_discount\"]");
    private Button topSelling;
    private String topSellingName = "topSellingButton";
    private AgeValidatePage ageValidatePage;
    private TheGameWithDiscountPage theGameWithDiscountPage;
    private String theCheapest;
    ArrayList<WebElement> topSellingGames;

    public ActionGamesPage() {
        ageValidatePage = new AgeValidatePage();
        topSelling = new Button(topSellingName, topSellingLocator);
        theGameWithDiscountPage = new TheGameWithDiscountPage();
    }

    public void topSellingClick() {
        topSelling.click();
    }

    public ArrayList<String> getTopSellingGames() {
        WebElementWait.waiterForWebElement(gamesLocator);
        topSellingGames = (ArrayList<WebElement>) Browser.getDriver().findElements(gamesLocator);
        ArrayList<String> listOfGames = new ArrayList<String>();
        for (WebElement topSellingGame : topSellingGames) {
            listOfGames.add(topSellingGame.getText());
        }
        listOfGames.removeAll(Arrays.asList("", null));
        return listOfGames;
    }

    private String theBiggestDiscount(ArrayList<String> listOfGames){
        ArrayList<String> discounts = new ArrayList<String>();
        for (String listOfGame : listOfGames) {
            discounts.add(listOfGame.substring(0, listOfGame.indexOf("\n")));
        }
        Collections.sort(discounts);
        return discounts.get(discounts.size()-1);
    }

    public void theVeryGameClick(ArrayList<String> listOfGames) {
        String theBiggestSale = theBiggestDiscount(listOfGames);

        for (WebElement topSellingGame : topSellingGames) {
            if (topSellingGame.getText().contains(theBiggestSale)) {
                theCheapest = topSellingGame.getText();
                topSellingGame.click();
                break;
            }
        }
        if(ageValidatePage.getViewPage().isDisplayed()) {
            ageValidatePage.ageValidate();
        }
    }

    public boolean comparePrices(){
        boolean compare = false;
        String fromTheGamePagePrices = theGameWithDiscountPage.getPricesFromPage();
        fromTheGamePagePrices = fromTheGamePagePrices.substring(4);
        if (theCheapest.equals(fromTheGamePagePrices)){
            compare = true;
        }
        return compare;
    }
}
