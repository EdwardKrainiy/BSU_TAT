package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.BuyingPage;


public class ChooseConfigurationAndAddToBasketTest extends CommonCondition {
    Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void ChooseConfigurationAndAddToBasketTest(){
        log.info("Test2 has been started.");
        int amountOfPhonesOnBasket = new BuyingPage(driver)
                .openPage()
                .buyPhone()
                .addToBasket()
                .getAmountOfPhones();
        Assert.assertEquals(amountOfPhonesOnBasket, 1);
    }
}
