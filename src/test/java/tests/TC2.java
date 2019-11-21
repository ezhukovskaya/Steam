package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC2 extends BaseTest {
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();


    @Test(dataProvider = "getData")
    public void highestDiscountCalculationCheck(String genreDiscount) {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        mainPage.goToMainMenu().goToGamesCategory().goToGenre(genreDiscount);
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(genreDiscount), "Action page is not opened");
        log.info("Find the game with the biggest discount");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        log.info("Open the game with the biggest discount");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), genreDiscount);
        log.info("Comparing prices");
        Assert.assertTrue(anyCategoryGamesPage.isPricesTheSame(), "The prices are different");
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{BROWSING_ACTION},{BROWSING_INDIE}};
    }
}
