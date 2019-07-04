package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Attachments.screenshot;

public class SearchResultsPage {

    @Step("Open ozon main page")
    public SearchResultsPage open() {
        Selenide.open("https://www.ozon.ru");
        screenshot("open main page");
        return this;
    }
    @Step("Search for product with name {0}")
    public void searchProduct(String productName) {
        $(".search-input").setValue(productName).pressEnter();
        screenshot("search for product with name = " + productName);
    }

    @Step("Add first product from search result to basket")
    public String addProductToBasket() {
        $$(".tile").first().scrollTo().$(withText("В корзину")).click();
        screenshot("Added first item from the search results to the basket");
        return $$(".tile").first().
                $(".total-price").getText().trim();
    }

    @Step("Check that basket counter equals {1}")
    public void checkBasketCounter(String amount) {
        $(".m-cart").scrollTo().
                $(".count").shouldHave(Condition.text(amount));
        screenshot("Basket counter equals " + amount);
    }
}
