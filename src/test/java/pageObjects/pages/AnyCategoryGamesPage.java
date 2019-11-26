package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import framework.utils.PropertiesRead;
import org.openqa.selenium.By;
import pageObjects.forms.ListOfGames;
import pageObjects.forms.TabBar;

public class AnyCategoryGamesPage {
    private By topSellingActiveLocator = By.xpath("//*[contains(@class,'active')]");
    private By genreBannerLocator = By.xpath("//*[@class='contenthub_subtitle']");
    private Banner genreBanner = new Banner("pageheader", genreBannerLocator);
    private Button topSellingActive = new Button("topSellingButton", topSellingActiveLocator);

    public TabBar getTabBar() {
        return new TabBar();
    }

    public boolean genrePageIsDisplayed(String genre) {
        String gameGenre = PropertiesRead.readFromDictionary(genre);
        return genreBanner.getText().contains(gameGenre);
    }

    public void gameClick(int discount) {
        new ListOfGames().theGameClick(discount);
    }

    public String getGamePricesFromTheList(int discount) {
        return new ListOfGames().getGameText(discount);
    }

    public boolean isTopSellingActive() {
        return topSellingActive.isDisplayed();
    }

}
