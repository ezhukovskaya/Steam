package tests;

import framework.utils.PropertiesRead;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.pages.AnyCategoryGamesPage;
import pageObjects.pages.MainPage;
import pageObjects.pages.TheGameWithDiscountPage;

public class TC2 extends BaseTest {
    private final String ACTIONS = PropertiesRead.readFromDictionary("action");
    private final String INDIE = PropertiesRead.readFromDictionary("indie");
    private final int LOW_DISCOUNT = 0;
    private final int HIGH_DISCOUNT = 1;
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();
    private TheGameWithDiscountPage theGameWithDiscountPage = new TheGameWithDiscountPage();
    private MainPage mainPage = new MainPage();

    @Test(dataProvider = "getData")
    public void newHighestDiscountCalculationCheck(String genre, int discount) throws InterruptedException {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Action page");
        mainPage.getMainMenu().gameGenreClick(genre);
        log.info("Choose Top Selling");
        anyCategoryGamesPage.getTabBar().getTabBarCategory();
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(genre), "Action page is not opened");
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        log.info("Get Prices of the game from the list");
        String priceFromTheList = anyCategoryGamesPage.getGamePricesFromTheList(discount);
        log.info("Find the game with the biggest discount");
        anyCategoryGamesPage.gameClick(discount);
        log.info("Get Prices of the game from its page");
        String priceFromTheGamePage = theGameWithDiscountPage.getPricesFromGamePage();
        Assert.assertEquals(priceFromTheGamePage, priceFromTheList, "The prices are different");
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{ACTIONS, HIGH_DISCOUNT}, {INDIE, LOW_DISCOUNT}};
    }
}
