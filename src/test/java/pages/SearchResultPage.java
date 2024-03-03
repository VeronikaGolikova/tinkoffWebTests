package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    private final SelenideElement
            headerText = $x("//h1[@data-schema-path='title']"),
            filterCards = $x("//div[@role='banner']");;

    @Step("Загаловок содержит текст")
    public SearchResultPage healerHasText(String someText) {
        headerText.shouldHave(text(someText));
        return this;
    }

    @Step("Результаты поиска отображаются на странице")
    public SearchResultPage filterResults(String text) {
        filterCards.shouldHave(text(text));
        return this;
    }

    @Step("Результат поиска содержит текст {value}")
    public SearchResultPage offerHasText(String value) {
//        offerCard.shouldHave(text(value));
        return this;
    }
}
