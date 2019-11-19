package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC3 extends BaseTest{
    private final int LOW_DISCOUNT = 0;
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();
    @Test
    public void lowestDiscountCalculationCheck(){
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToMainMenu().goToGamesCategory().goToIndie();
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_INDIE),"Indie page is not opened");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(),"Top Selling is not opened");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(),LOW_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(), "The prices are different");
        Browser.close();
    }
}
