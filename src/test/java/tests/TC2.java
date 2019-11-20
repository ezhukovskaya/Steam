package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.forms.Action;
import pageObjects.forms.Genres;
import pageObjects.forms.Indie;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC2 extends BaseTest {
    private final int HIGH_DISCOUNT = 1;
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private final int LOW_DISCOUNT = 0;
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{new Action(), BROWSING_ACTION, HIGH_DISCOUNT}, {new Indie(), BROWSING_INDIE, LOW_DISCOUNT}};
    }

    @Test(dataProvider = "getData")
    public void highestDiscountCalculationCheck(Genres genres,String genre, int discount) {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        mainPage.goToMainMenu().goToGamesCategory().goToGenre(genres);
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
