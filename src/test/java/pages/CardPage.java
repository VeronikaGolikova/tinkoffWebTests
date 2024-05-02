package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CardPage {
    private final SelenideElement getCardButton = $x("//div[@data-schema-path='button']");

    @Step("Открыть страницу")
    public CardPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Нажать на кнопку 'Оформить карту'")
    public CardPage clickGetCardButton() {
        getCardButton.click();
        return this;
    }
}
