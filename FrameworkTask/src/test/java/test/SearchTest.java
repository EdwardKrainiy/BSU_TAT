package test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;

public class SearchTest extends CommonCondition {
    private Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void searchWithEmptyFieldTest(){
        log.info("Test 5 has been started.");
        String searchMessage = new SearchPage(driver)
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.");

    }

    @Test
    public void searchWithQueryTest() {
        log.info("Test 6 has been started.");
        String searchQuery = "Xiaomi";
        String nameOfTheFirstSearchedPhone = new SearchPage(driver)
                .openPage()
                .searchWithFilledField(searchQuery)
                .getNameOfTheFirstPhone();
        Assert.assertTrue(nameOfTheFirstSearchedPhone.contains(searchQuery));
    }
}
