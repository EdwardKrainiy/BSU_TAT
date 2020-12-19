package test;

import driver.DriverSingleton;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;
import provider.SearchTestDataProvider;

public class SearchTest extends CommonCondition {
    private Logger log = Logger.getLogger(SearchTest.class);
    private static final String ERROR_MESSAGE = "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.";

    @Test
    public void searchWithEmptyFieldTest(){
        log.info("searchWithEmptyFieldTest has been started.");
        String searchMessage = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, ERROR_MESSAGE);
    }

    @Test(dataProvider = "correctQuerySearchTestProvider", dataProviderClass = SearchTestDataProvider.class)
    public void searchWithQueryTest(String query) {
        log.info("searchWithQueryTest has been started.");
        String nameOfTheFirstSearchedByQueryPhone = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .searchWithFilledField(query)
                .getNameOfTheFirstFoundedPhone();
        boolean isNameContainsQuery = nameOfTheFirstSearchedByQueryPhone.contains(query);
        Assert.assertTrue(isNameContainsQuery);
    }

    @Test(dataProvider = "incorrectQuerySearchTestProvider", dataProviderClass = SearchTestDataProvider.class)
    public void searchWithIncorrectQueryTest(String query) {
        log.info("searchWithIncorrectQueryTest has been started.");
        String searchMessage = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .searchWithFilledField(query)
                .getSearchMessage();
        Assert.assertEquals(searchMessage, ERROR_MESSAGE);
    }
}
