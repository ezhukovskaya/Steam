package tests;

import framework.utils.propertiesManager.PropertiesRead;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC2 extends BaseTest {
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private final String ACTIONS = PropertiesRead.readFromDictionary("action");
    private final String INDIE = PropertiesRead.readFromDictionary("indie");
    private final int LOW_DISCOUNT = 0;
    private final int HIGH_DISCOUNT = 1;
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();


   /* @Test(dataProvider = "getData")
    public void highestDiscountCalculationCheck(String genreDiscount) {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        mainPage.goToMainMenu().gameGenreClick().goToGenre(genreDiscount);
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(genreDiscount), "Action page is not opened");
        log.info("Find the game with the biggest discount");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        log.info("Open the game with the biggest discount");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), genreDiscount);
        log.info("Comparing prices");
        Assert.assertTrue(anyCategoryGamesPage.isPricesTheSame(), "The prices are different");
    }*/

    @Test(dataProvider = "getData")
    public void newHighestDiscountCalculationCheck(String genre, int discount) {
        mainPage.getMainMenu().gameGenreClick(genre);
        anyCategoryGamesPage.getTabBar().getTabBarCategory().getGames();
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{ACTIONS, HIGH_DISCOUNT}, {INDIE, LOW_DISCOUNT}};
    }
}
