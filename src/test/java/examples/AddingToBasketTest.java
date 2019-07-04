package examples;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.SearchResultsPage;

import java.io.IOException;

public class AddingToBasketTest {

    private final String PRODUCT_NAME = "Преступление и наказание";

    private SearchResultsPage search = new SearchResultsPage();
    private BasketPage basket = new BasketPage();

    @BeforeEach
    public void setUp() throws Exception {
//        Uncomment next line for Allure to use ALL Selenide actions from this test as sub-steps in report
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.reportsFolder = "target/selenide-results";
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Add a product to the basket")
    @Description("Test for adding a product to the basket")
    public void mainScenario() throws IOException {
        search.open();
        search.searchProduct(PRODUCT_NAME);
        String chosenProductPrice = search.addProductToBasket();
        search.checkBasketCounter("1");
        basket.openBasket();
        basket.hasProduct(PRODUCT_NAME, chosenProductPrice);
    }

}
