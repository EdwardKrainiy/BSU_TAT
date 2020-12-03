import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsForSearchAndAddToBasket {
    private WebDriver webDriver;

    public ElementsForSearchAndAddToBasket(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getCloseAdButton(){
        try {
            return new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("popmechanic-close"))).get(0);
        } catch (Exception e){
            System.out.println("Ad not found.");
            return null;
        }
    }

    public WebElement getCloseChatButton(){
        try {
            return new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("support-close"))).get(0);
        } catch (Exception e){
            System.out.println("Support chat not found.");
            return null;
        }
    }

    public WebElement getSearchInputField(){
        return this.webDriver.findElement(By.xpath("//*[@id=\"title-search-input\"]"));
    }

    public WebElement getSearchButton(){
        return this.webDriver.findElement(By.xpath("//*[@id=\"title-search\"]/form/button"));
    }

    public WebElement getFirstPhoneLinkFromPhoneLinks(){
        return this.webDriver.findElements(By.className("search__page_item-name")).get(0);
    }

    public WebElement getAddToBasketButton(){
        return this.webDriver.findElement(By.xpath("//*[@id=\"bx_2369550383_10342_buy_link\"]"));
    }

    public String getAmountOfItemsInBasket(){
        return this.webDriver.findElement(By.xpath("//*[@id=\"basket_items_list\"]/div[1]/span")).getText();
    }
}
