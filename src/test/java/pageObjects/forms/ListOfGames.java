package pageObjects.forms;

import framework.base.elements.Button;
import framework.browser.Browser;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import regex.RegEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListOfGames {
    private By listOfGamesLocator = By.xpath("//a/div[@class='discount_block tab_item_discount']");
    static final Logger log = Logger.getLogger(MainMenu.class);
    ArrayList<WebElement> games;

    public ArrayList<String> getGames() {
        games = (ArrayList<WebElement>) Browser.getBrowser().findElements(listOfGamesLocator);
        ArrayList<String> listOfGames = new ArrayList<String>();
        for (WebElement game : games) {
            listOfGames.add(game.getText());
        }
        listOfGames.removeAll(Arrays.asList("", null));
        return listOfGames;
    }

    public int max(ArrayList<Integer> sales) {
        int max = 0;
        for (Integer sale : sales) {
            if (max <= sale) {
                max = sale;
            }
        }
        return max;
    }

    private int getDiscountValue(ArrayList<String> listOfGames, int discountValue) {
        String discountOfTheGame = null;
        ArrayList<Integer> discounts = new ArrayList<Integer>();
        for (String listOfGame : listOfGames) {
            discounts.add(Integer.parseInt(listOfGame.substring(0, listOfGame.indexOf("\n"))));
        }
        Collections.sort(discounts);
        if (discountValue == 0) {
            discountOfTheGame = discounts.get(0);
        }
        if (discountValue == 1) {
            discountOfTheGame = discounts.get(discounts.size() - 1);
        }
        return discountOfTheGame;
    }

    public void theGameClick(ArrayList<String> listOfGames, int discountValue) {
        String sale = getDiscountValue(listOfGames, discountValue);
        for (WebElement topSellingGame : topSellingGames) {
            if (topSellingGame.getText().contains(sale)) {
                theChosenGame = RegEx.getOnlyValuesOfPrices(topSellingGame.getText());
                log.info("Game is clicked");
                topSellingGame.click();
                break;
            }
        }
        if (ageValidatePage.isPageExists()) {
            ageValidatePage.ageValidate();
        }
    }


}
