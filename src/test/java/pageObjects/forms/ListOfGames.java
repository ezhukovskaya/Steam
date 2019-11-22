package pageObjects.forms;

import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.pages.AgeValidatePage;
import regex.RegEx;

import java.util.ArrayList;

public class ListOfGames {
    private By listOfGamesLocator = By.xpath("//a/div[@class='discount_block tab_item_discount']");
    static final Logger log = Logger.getLogger(MainMenu.class);
    ArrayList<WebElement> games;
    private AgeValidatePage ageValidatePage = new AgeValidatePage();

    private ArrayList<String> getGames() {
        games = (ArrayList<WebElement>) Browser.getBrowser().findElements(listOfGamesLocator);
        ArrayList<String> listOfGames = new ArrayList<>();
        for (int i = 0; i < games.size(); ) {
            if (games.get(i).getText().isEmpty()) {
                games.remove(i);
            } else {
                listOfGames.add(RegEx.getOnlyValuesOfPrices(games.get(i).getText()));
                i++;
            }
        }
        return listOfGames;
    }

    private int getMaxIndex(ArrayList<Integer> sales) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < sales.size(); i++) {
            if (max <= sales.get(i)) {
                max = sales.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int getMinIndex(ArrayList<Integer> sales) {
        int min = 100;
        int minIndex = 0;
        for (int i = 0; i < sales.size(); i++) {
            if (min >= sales.get(i)) {
                min = sales.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getIndexOfTheGame(ArrayList<String> listOfGames, int discountRange) {
        int discountOfTheGame = 0;
        ArrayList<Integer> discounts = new ArrayList<Integer>();
        for (String listOfGame : listOfGames) {
            discounts.add(Integer.parseInt(listOfGame.substring(0, listOfGame.indexOf("%"))));
        }
        if (discountRange == 0) {
            discountOfTheGame = getMaxIndex(discounts);
        }
        if (discountRange == 1) {
            discountOfTheGame = getMinIndex(discounts);
        }
        return discountOfTheGame;
    }

    public String getGameText(int discountRange){
        ArrayList<String> listOfGames = getGames();
        int discountValue = getIndexOfTheGame(listOfGames, discountRange);
        return RegEx.getOnlyValuesOfPrices(games.get(discountValue).getText());
    }

    public void theGameClick(int discountRange) {
        log.info("Get list of games");
        ArrayList<String> listOfGames = getGames();
        int discountValue = getIndexOfTheGame(listOfGames, discountRange);
        games.get(discountValue).click();
        if (ageValidatePage.isPageExists()) {
            log.info("Go to validation form");
            ageValidatePage.ageValidate();
        }
    }


}
