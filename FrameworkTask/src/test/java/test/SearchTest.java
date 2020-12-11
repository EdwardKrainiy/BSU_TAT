package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.SearchPage;

public class SearchTest extends CommonCondition {
    private Logger log = Logger.getLogger(SearchTest.class);

    @Test
    public void SearchWithEmptyFieldTest(){
        log.info("Test 5 has been started.");
        String searchMessage = new SearchPage(driver)
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.");

    }

    @Test
    public void SearchWithQueryTest() {
        log.info("Test 6 has been started.");
        String searchQuery = "Xiaomi";
        String nameOfTheFirstSearchedPhone = new SearchPage(driver)
                .openPage()
                .searchWithFilledField(searchQuery)
                .getNameOfTheFirstPhone();
        Assert.assertTrue(nameOfTheFirstSearchedPhone.contains(searchQuery));
    }
}
