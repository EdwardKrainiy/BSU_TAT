import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloWebDriver {

   @Test
   public void testSearchAndAddToBasket() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://xistore.by/");

        ElementsForSearchAndAddToBasket elements = new ElementsForSearchAndAddToBasket(chromeDriver);

        WebElement closeAdButton = elements.getCloseAdButton();
        if(closeAdButton != null){
             closeAdButton.click();
        }

        WebElement closeChatButton = elements.getCloseChatButton();
        if(closeChatButton != null){
             closeChatButton.click();
        }

        WebElement searchInput = elements.getSearchInputField();
        searchInput.sendKeys("Xiaomi");

        WebElement searchButton = elements.getSearchButton();
        searchButton.click();

        WebElement phoneLink = elements.getFirstPhoneLinkFromPhoneLinks();
        phoneLink.click();

        WebElement addToBasketButton = elements.getAddToBasketButton();
        addToBasketButton.click();
        chromeDriver.quit();
   }
}