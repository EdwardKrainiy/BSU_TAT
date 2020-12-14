package test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ComparingPage;


public class AddTwoPhonesToComparingAndDeleteOnePhoneFromComparingTest extends CommonCondition {
    Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void comparingTwoPhonesAndDeletingOnePhoneTest() {
        log.info("Test1 has been started.");
        ComparingPage comparingPage = new ComparingPage(driver);
        int amountOfPhonesBeforeDeleting = comparingPage
                .openPage()
                .compareTwoPhones()
                .moveToComparingPage()
                .getAmountOfPhonesOnComparingPage();
        int amountOfPhonesAfterDeleting = comparingPage
                .removeOnePhoneFromComparing()
                .getAmountOfPhonesOnComparingPage();
        Assert.assertEquals(amountOfPhonesAfterDeleting, amountOfPhonesBeforeDeleting - 1);
    }
}

