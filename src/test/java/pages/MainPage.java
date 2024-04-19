package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            shoppingDebetCard = $x("//a[@href='/cards/debit-cards/shopping/']"),
            headerText = $x("//h1[@data-schema-path='title']"),
            filterCards = $x("//div[@role='banner']"),
            getCardButton = $x("//div[@data-schema-path='button']"),
            moreInfoButton = $x("//div[@data-schema-path='buttonMore']");

    @Step("Открыть страницу")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Нажать на кнопку 'Подробнее' для просмотра информации по карте")
    public MainPage clickMoreButton() {
        moreInfoButton.click();
        return this;
    }
    @Step("Нажать на кнопку 'Оформить карту'")
    public MainPage clickGetCardBatton() {
        getCardButton.click();
        return this;
    }

    @Step("Перейти на вкладку карт для покупок")
    public MainPage filterShoppingCards() {
        shoppingDebetCard.click();
        return this;
    }

    @Step("Загаловок содержит текст")
    public MainPage headerHasText(String someText) {
        headerText.shouldHave(text(someText));
        return this;
    }

    @Step("Результаты поиска отображаются на странице")
    public MainPage filterResultsHasText(String text) {
        filterCards.shouldHave(text(text));
        return this;
    }
}
