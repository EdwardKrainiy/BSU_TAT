package test;

import driver.DriverSingleton;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BuyingPage;

public class ChooseConfigurationAndAddToBasketTest extends CommonCondition {
    Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void chooseConfigurationAndAddToBasketTest(){
        log.info("chooseConfigurationAndAddToBasketTest has been started.");
        int amountOfPhonesOnBasket = new BuyingPage(DriverSingleton.getDriver())
                .openPage()
                .buyPhone()
                .addToBasket()
                .getAmountOfPhones();
        Assert.assertEquals(amountOfPhonesOnBasket, 1);
    }
}
