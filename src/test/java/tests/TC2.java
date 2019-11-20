package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.forms.Action;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC2 extends BaseTest {
    private final int HIGH_DISCOUNT = 1;
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();

    @Test
    public void highestDiscountCalculationCheck() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        mainPage.goToMainMenu().goToGamesCategory().goToGenre(new Action());
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_ACTION), "Action page is not opened");
        log.info("Find the game with the biggest discount");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        log.info("Open the game with the biggest discount");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), HIGH_DISCOUNT);
        log.info("Comparing prices");
        Assert.assertTrue(anyCategoryGamesPage.isPricesTheSame(), "The prices are different");
    }
}
