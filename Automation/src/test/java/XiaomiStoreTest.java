import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LandingPage;
import page.SearchPage;

public class XiaomiStoreTest {
     WebDriver driver;
     SearchPage searchPage;
     LandingPage landingPage;

     @BeforeClass
     public void prepareAll(){
          System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

          driver = new ChromeDriver();
          searchPage = new SearchPage(driver);
          landingPage = new LandingPage(driver);

          driver.manage().window().maximize();
     }

     @Test
     public void searchAllItemsWithXiaomiStringTest() throws InterruptedException {
          driver.navigate().to("https://xistore.by/");

          landingPage.clickCloseAdButton();

          landingPage.inputStringToSearchField("Xiaomi");

          landingPage.clickSearchButton();

          Assert.assertTrue(landingPage.getNameOfTheFirstPhoneOnPage().contains("Xiaomi"));
     }

     @Test(dependsOnMethods = "searchAllItemsWithXiaomiStringTest")
     public void addOnePhoneToBasketTest(){
          driver.navigate().to("https://xistore.by/search/?q=Xiaomi");

          searchPage.clickOnTheFirstPhoneLink();

          searchPage.clickAddToBasketButton();

          Assert.assertEquals("1", searchPage.getAmountOfItemsInBasket());
     }

     @AfterClass(alwaysRun = true)
     public void closeBrowser(){
          driver.quit();
     }
}
