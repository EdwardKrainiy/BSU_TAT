package test;

import driver.DriverSingleton;
import org.testng.annotations.*;


public class CommonCondition {
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
