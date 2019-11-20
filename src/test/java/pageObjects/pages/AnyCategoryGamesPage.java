package pageObjects.pages;

import framework.browser.Browser;
import framework.utils.propertiesManager.PropertiesRead;
import framework.utils.regex.RegEx;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.elements.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnyCategoryGamesPage {
    private final int LOW_DISCOUNT = 0;
    private final int HIGH_DISCOUNT = 1;
    private By topSellingLocator = By.xpath("//*[@id=\"tab_select_TopSellers\"]");
    private By gamesLocator = By.xpath("//a/div[@class=\"discount_block tab_item_discount\"]");
    private By topSellingActiveLocator = By.xpath("//*[contains(@class,'active')]");
    private Button topSellingActive;
    private Button topSelling;
    private String topSellingName = "topSellingButton";
    private AgeValidatePage ageValidatePage;
    private TheGameWithDiscountPage theGameWithDiscountPage;
    private String theChosenGame;
    private String genreBannerClassname = "pageheader";
    ArrayList<WebElement> topSellingGames;
    static final Logger log = Logger.getLogger(AnyCategoryGamesPage.class);

    public AnyCategoryGamesPage() {
        ageValidatePage = new AgeValidatePage();
        topSelling = new Button(topSellingName, topSellingLocator);
        topSellingActive = new Button(topSellingName, topSellingActiveLocator);
        theGameWithDiscountPage = new TheGameWithDiscountPage();
    }

    public boolean genrePageIsDisplayed(String genre) {
        String gameGenre = PropertiesRead.readFromPropertiesFile(genre);
        boolean display = false;
        if (Browser.getDriver().findElement(By.className(genreBannerClassname)).getText().equals(gameGenre))
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
        topSelling.click();
        log.info(topSellingName + " clicked");
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
        if (DISCOUNT_VALUE == LOW_DISCOUNT) {
            discountOfTheGame = discounts.get(0);
        }
        if (DISCOUNT_VALUE == HIGH_DISCOUNT) {
            discountOfTheGame = discounts.get(discounts.size() - 1);
        }
        return discountOfTheGame;
    }

    public void theGameClick(ArrayList<String> listOfGames, int DISCOUNT_VALUE) {
        String sale = getDiscountValue(listOfGames, DISCOUNT_VALUE);
        for (WebElement topSellingGame : topSellingGames) {
            if (topSellingGame.getText().contains(sale)) {
                theChosenGame = RegEx.onlyPrices(topSellingGame.getText());
                topSellingGame.click();
                log.info("Game is clicked");
                break;
            }
        }
        boolean check = ageValidatePage.pageIsExisted();
        if (check == true) {
            ageValidatePage.ageValidate();
        } else {
            System.out.println("Go to the page");
        }
    }

    public boolean comparePrices() {
        boolean compare = false;
        String fromTheGamePagePrices = theGameWithDiscountPage.getPricesFromPage();
        fromTheGamePagePrices = RegEx.onlyPrices(fromTheGamePagePrices);
        if (fromTheGamePagePrices.length() > theChosenGame.length()) {
            fromTheGamePagePrices = fromTheGamePagePrices.substring(4);
        }
        if (theChosenGame.equals(fromTheGamePagePrices)) {
            compare = true;
        }
        return compare;
    }
}
