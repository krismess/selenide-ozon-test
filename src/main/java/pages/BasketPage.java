package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Attachments.screenshot;

public class BasketPage {

    @Step("User opens basket")
    public void openBasket() {
        $(".m-cart").$(withText("Корзина")).click();
        screenshot("Basket is opened");
    }

    @Step("Checking if basket contains product with name {0} which price is {1}")
    public void hasProduct(String productName, String chosenProductPrice) {
        $$(".split-item").first()
                .shouldHave(Condition.text(productName))
                .shouldHave(Condition.text(chosenProductPrice));
    }
}
