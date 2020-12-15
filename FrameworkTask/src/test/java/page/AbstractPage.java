package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected String URL = "https://xistore.by/";

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
