package pageObjects.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.elements.Button;
import utils.waits.WebElementWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ActionGamesPage {
    private By topSellingLocator = By.xpath("//*[@id=\"tab_select_TopSellers\"]/div");
    private By games = By.cssSelector(".discount_pct");
    private Button topSelling;
    private String topSellingName = "topSellingButton";
    ArrayList<WebElement> topSellingGames;

    public ActionGamesPage(){
        topSelling = new Button(topSellingName, topSellingLocator);
    }

    public void topSellingClick(){
        topSelling.click();
    }

    public ArrayList<String> getTopSellingGames() {
        WebElementWait.waiterForWebElement(games);
        topSellingGames = (ArrayList<WebElement>) Browser.getDriver().findElements(games);
        ArrayList<String> listOfGames = new ArrayList<String>();
        for (WebElement topSellingGame : topSellingGames) {
            listOfGames.add(topSellingGame.getText());
        }
        listOfGames.removeAll(Arrays.asList("", null));
        return listOfGames;
    }

    public WebElement theVeryGameClick(ArrayList<String> listOfGames){
        WebElement theCheapest = null;
        for(int i=0;i<listOfGames.size();i++){
            Integer.parseInt(listOfGames.get(i).replaceAll("[\\D]", ""));
        }
        Collections.sort(listOfGames);
        String theBiggestSale = listOfGames.get(listOfGames.size()-1);
        for(int i=0; i<topSellingGames.size();i++){
            if(topSellingGames.get(i).getText().equals(theBiggestSale)){
                theCheapest = topSellingGames.get(i);
                break;
            }
        }
        return theCheapest;
    }



}
