package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected String URL = "https://xistore.by/";

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public List<WebElement> waitForAllWebElements(By selectorOfElement){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectorOfElement));
    }
}
