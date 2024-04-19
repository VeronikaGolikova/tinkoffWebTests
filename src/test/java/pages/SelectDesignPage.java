package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SelectDesignPage {
    static final String TEXT = "Дебетовая карта Tinkoff Black c кэшбэком рублями на всё";

    private final SelenideElement
            title = $x("//h2[@data-test='htmlTag title']"),
            slider = $x("//div[@data-qa-type='uikit/carousel.slider.controlNext']"),
            imgText = $(".ibT2CUJzc"),
            selectThisCardButton = $x("//span[@data-schema-path='button']");

    @Step("Перейти на вкладку премиальных карт")
    public SelectDesignPage titleHasText() {
        title.shouldHave(text(TEXT));
        return this;
    }

    @Step("Нажать на слайдер для выбора дизайна карты")
    public SelectDesignPage clickSlider() {
        slider.click();
        return this;
    }

    @Step("Изображение выбранной карты")
    public SelectDesignPage imgHasValue(String value) {
        imgText.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на кнопку 'Выбрать эту карту'")
    public SelectDesignPage clickSelectThisCard() {
        selectThisCardButton.click();
        return this;
    }
}
