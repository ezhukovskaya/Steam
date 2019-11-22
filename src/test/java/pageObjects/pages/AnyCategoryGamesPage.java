package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.forms.TabBar;
import regex.RegEx;

import java.util.ArrayList;

public class AnyCategoryGamesPage {
    private By topSellingActiveLocator = By.xpath("//*[contains(@class,'active')]");
    private By genreBannerLocator = By.className("pageheader");
    private String topSellingName = "topSellingButton";
    private TheGameWithDiscountPage theGameWithDiscountPage = new TheGameWithDiscountPage();
    private String theChosenGame;
    private Banner genreBanner = new Banner("pageheader", genreBannerLocator);
    private Button topSellingActive = new Button(topSellingName, topSellingActiveLocator);
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


    public boolean isPricesTheSame() {
        String fromTheGamePagePrices = theGameWithDiscountPage.getPricesFromPage();
        fromTheGamePagePrices = RegEx.getOnlyValuesOfPrices(fromTheGamePagePrices);
        if (fromTheGamePagePrices.length() > theChosenGame.length()) {
            fromTheGamePagePrices = fromTheGamePagePrices.substring(4);
        }
        return theChosenGame.equals(fromTheGamePagePrices);
    }
}
