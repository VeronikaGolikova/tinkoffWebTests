package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SearchResultPage {
    private final SelenideElement
            headerText = $x("//h1"),
            offerCard = $x("//div[@data-testid='offer-card']");

    @Step("Загаловок содержит текст")
    public SearchResultPage healerHasText(String someText) {
        headerText.shouldHave(text(someText));
        return this;
    }

    @Step("Результаты поиска отображаются на странице")
    public SearchResultPage offerExists() {
        offerCard.exists();
        return this;
    }

    @Step("Результат поиска содержит текст {value}")
    public SearchResultPage offerHasText(String value) {
        offerCard.shouldHave(text(value));
        return this;
    }
}
