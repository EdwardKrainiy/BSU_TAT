package test;

import driver.DriverSingleton;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;
import provider.SearchTestDataProvider;

public class SearchTest extends CommonCondition {
    private Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void searchWithEmptyFieldTest(){
        log.info("Test 5 has been started.");
        String searchMessage = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.");
    }

    @Test(dataProvider = "searchTestProvider", dataProviderClass = SearchTestDataProvider.class)
    public void searchWithQueryTest(String query) {
        log.info("Test 6 has been started.");
        String nameOfTheFirstSearchedByQueryPhone = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .searchWithFilledField(query)
                .getNameOfTheFirstFoundedPhone();
        boolean isNameContainsQuery = nameOfTheFirstSearchedByQueryPhone.contains(query);
        Assert.assertTrue(isNameContainsQuery);
    }
}
