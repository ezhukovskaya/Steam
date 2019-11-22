package pageObjects.pages;

import framework.base.elements.Banner;
import framework.browser.Browser;
import framework.utils.propertiesManager.PropertiesRead;
import pageObjects.forms.TabBar;
import regex.RegEx;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.base.elements.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnyCategoryGamesPage {
    private By topSellingLocator = By.xpath("//*[@id='tab_select_TopSellers']");
    private By gamesLocator = By.xpath("//a/div[@class='discount_block tab_item_discount']");
    private By topSellingActiveLocator = By.xpath("//*[contains(@class,'active')]");
    private By genreBannerLocator = By.className("pageheader");
    private String topSellingName = "topSellingButton";
    private AgeValidatePage ageValidatePage = new AgeValidatePage();
    private TheGameWithDiscountPage theGameWithDiscountPage = new TheGameWithDiscountPage();
    private String theChosenGame;
    private Banner genreBanner = new Banner("pageheader", genreBannerLocator);
    private Button topSellingActive = new Button(topSellingName, topSellingActiveLocator);
    private Button topSelling = new Button(topSellingName, topSellingLocator);
    private ArrayList<WebElement> topSellingGames;
    private static final Logger log = Logger.getLogger(AnyCategoryGamesPage.class);

    public TabBar getTabBar() {
        return new TabBar();
    }

    public boolean genrePageIsDisplayed(String genre) {
        String gameGenre = PropertiesRead.readFromDictionary(genre);
        return genreBanner.getText().equals(gameGenre);
    }

    public boolean isTopSellingActive() {
        return topSellingActive.isDisplayed();
    }

    public void topSellingClick() {
        log.info(topSellingName + " clicked");
        topSelling.click();
    }

    public ArrayList<String> getTopSellingGames() {
        topSellingGames = (ArrayList<WebElement>) Browser.getBrowser().findElements(gamesLocator);
        ArrayList<String> listOfGames = new ArrayList<String>();
        for (WebElement topSellingGame : topSellingGames) {
            listOfGames.add(topSellingGame.getText());
        }
        listOfGames.removeAll(Arrays.asList("", null));
        return listOfGames;
    }

    private String getDiscountValue(ArrayList<String> listOfGames, int discountValue) {
        String discountOfTheGame = null;
        ArrayList<String> discounts = new ArrayList<String>();
        for (String listOfGame : listOfGames) {
            discounts.add(listOfGame.substring(0, listOfGame.indexOf("\n")));
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

    public boolean isPricesTheSame() {
        String fromTheGamePagePrices = theGameWithDiscountPage.getPricesFromPage();
        fromTheGamePagePrices = RegEx.getOnlyValuesOfPrices(fromTheGamePagePrices);
        if (fromTheGamePagePrices.length() > theChosenGame.length()) {
            fromTheGamePagePrices = fromTheGamePagePrices.substring(4);
        }
        return theChosenGame.equals(fromTheGamePagePrices);
    }
}
