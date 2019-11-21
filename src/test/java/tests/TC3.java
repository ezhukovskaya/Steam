package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.forms.Indie;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC3 extends BaseTest {
    private final int LOW_DISCOUNT = 0;
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();

    @Test
    public void lowestDiscountCalculationCheck() throws InterruptedException {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        Thread.sleep(5000);
        mainPage.goToMainMenu().goToGamesCategory().goToGenre(new Indie());
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_INDIE), "Indie page is not opened");
        log.info("Find the game with the lowest discount");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        log.info("Open the game with the lowest discount");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), LOW_DISCOUNT);
        log.info("Comparing prices");
        Assert.assertTrue(anyCategoryGamesPage.isPricesTheSame(), "The prices are different");
    }
}
