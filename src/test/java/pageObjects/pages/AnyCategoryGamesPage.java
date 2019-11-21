package pageObjects.pages;

import framework.base.elements.Banner;
import framework.browser.Browser;
import framework.utils.propertiesManager.PropertiesRead;
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
    private Button topSellingActive;
    private Button topSelling;
    private String topSellingName = "topSellingButton";
    private AgeValidatePage ageValidatePage;
    private TheGameWithDiscountPage theGameWithDiscountPage;
    private String theChosenGame;
    private String genreBannerClassname = "pageheader";
    private Banner genreBanner;
    ArrayList<WebElement> topSellingGames;
    static final Logger log = Logger.getLogger(AnyCategoryGamesPage.class);

    public AnyCategoryGamesPage() {
        genreBanner = new Banner(genreBannerClassname, genreBannerLocator);
        ageValidatePage = new AgeValidatePage();
        topSelling = new Button(topSellingName, topSellingLocator);
        topSellingActive = new Button(topSellingName, topSellingActiveLocator);
        theGameWithDiscountPage = new TheGameWithDiscountPage();
    }

    public boolean genrePageIsDisplayed(String genre) {
        String gameGenre = PropertiesRead.readFromPropertiesFile(genre);
        boolean display = false;
        if (genreBanner.getText().equals(gameGenre))
            display = true;
        return display;
    }

    public boolean isTopSellingActive() {
        boolean active = false;
        if (topSellingActive.isDisplayed()) {
            active = true;
        }
        return active;
    }

    public void topSellingClick() {
        log.info(topSellingName + " clicked");
        topSelling.click();
    }

    public ArrayList<String> getTopSellingGames() {
        topSellingGames = (ArrayList<WebElement>) Browser.getDriver().findElements(gamesLocator);
        ArrayList<String> listOfGames = new ArrayList<String>();
        for (WebElement topSellingGame : topSellingGames) {
            listOfGames.add(topSellingGame.getText());
        }
        listOfGames.removeAll(Arrays.asList("", null));
        return listOfGames;
    }

    private String getDiscountValue(ArrayList<String> listOfGames, int DISCOUNT_VALUE) {
        String discountOfTheGame = null;
        ArrayList<String> discounts = new ArrayList<String>();
        for (String listOfGame : listOfGames) {
            discounts.add(listOfGame.substring(0, listOfGame.indexOf("\n")));
        }
        Collections.sort(discounts);
        if (DISCOUNT_VALUE == 0) {
            discountOfTheGame = discounts.get(0);
        }
        if (DISCOUNT_VALUE == 1) {
            discountOfTheGame = discounts.get(discounts.size() - 1);
        }
        return discountOfTheGame;
    }

    public void theGameClick(ArrayList<String> listOfGames, int DISCOUNT_VALUE) {
        String sale = getDiscountValue(listOfGames, DISCOUNT_VALUE);
        for (WebElement topSellingGame : topSellingGames) {
            if (topSellingGame.getText().contains(sale)) {
                theChosenGame = RegEx.getOnlyValuesOfPrices(topSellingGame.getText());
                log.info("Game is clicked");
                topSellingGame.click();
                break;
            }
        }
        boolean check = ageValidatePage.isPageExists();
        if (check == true) {
            ageValidatePage.ageValidate();
        } else {
        }
    }

    public boolean isPricesTheSame() {
        boolean compare = false;
        String fromTheGamePagePrices = theGameWithDiscountPage.getPricesFromPage();
        fromTheGamePagePrices = RegEx.getOnlyValuesOfPrices(fromTheGamePagePrices);
        if (fromTheGamePagePrices.length() > theChosenGame.length()) {
            fromTheGamePagePrices = fromTheGamePagePrices.substring(4);
        }
        if (theChosenGame.equals(fromTheGamePagePrices)) {
            compare = true;
        }
        return compare;
    }
}
