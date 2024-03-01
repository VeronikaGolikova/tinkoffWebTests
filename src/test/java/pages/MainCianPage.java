package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainCianPage {
    private final SelenideElement filterPrice = $x("//div[@data-mark='FilterPrice']/button"),
            minPrice = $x("//input[@placeholder='от']"),
            maxPrice = $x("//input[@placeholder='до']"),
            city = $("#geo-suggest-input"),
            selectCity = $x("//div[@data-group='cities']//strong"),
            rent = $(byText("Снять")),
            submitButton = $(byText("Найти"));

    @Step("Открыть главную страницу")
    public MainCianPage openPage() {
        open("");
        return this;
    }
    @Step("Нажать на фильтр для выбора стоимости")
    public MainCianPage clickFilterPrice() {
        filterPrice.click();
        return this;
    }
    @Step("Ввести минимальную сумму")
    public MainCianPage setMinSum(String value) {
        minPrice.setValue(value);
        return this;
    }

    @Step("Ввести максимальную сумму")
    public MainCianPage setMaxSum(String value) {
        maxPrice.setValue(value);
        return this;
    }

    @Step("Ввести город")
    public MainCianPage setCity(String value) {
        city.setValue(value).click();
        return this;
    }

    @Step("Выбрать город")
    public MainCianPage selectCity() {
        selectCity.click();
        return this;
    }

    @Step("Выбрать вкладку \"Снять\"")
    public MainCianPage selectRent() {
        rent.click();
        return this;
    }

    @Step("Нажать Найти")
    public MainCianPage submit() {
        submitButton.click();
        return this;
    }
}
