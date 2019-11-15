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
    private By gamesLocator = By.cssSelector(".discount_pct");
    private By triplePriceLocator = By.xpath("//*[@id=\"TopSellersRows\"]/a[13]/div[2]");
    private Button topSelling;
    private String topSellingName = "topSellingButton";
    private AgeValidatePage ageValidatePage;
    ArrayList<WebElement> topSellingGames;

    public ActionGamesPage(){
        ageValidatePage = new AgeValidatePage();
        topSelling = new Button(topSellingName, topSellingLocator);
    }

    public void topSellingClick(){
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

    public void theVeryGameClick(ArrayList<String> listOfGames){
        for (String listOfGame : listOfGames) {
            Integer.parseInt(listOfGame.replaceAll("[\\D]", ""));
        }
        Collections.sort(listOfGames);
        String theBiggestSale = listOfGames.get(listOfGames.size()-1);
        for (WebElement topSellingGame : topSellingGames) {
            if (topSellingGame.getText().equals(theBiggestSale)) {
                topSellingGame.click();
                break;
            }
        }
        ageValidatePage.ageValidate();
    }

    public ArrayList<String> getPrices(int index){
        ArrayList<WebElement> gamePrices = (ArrayList<WebElement>)Browser.getDriver().findElements(triplePriceLocator);
        System.out.println();
    }



}
