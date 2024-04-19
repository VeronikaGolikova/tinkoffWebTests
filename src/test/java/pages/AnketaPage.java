package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class AnketaPage {

    private final SelenideElement
            cardDesign = $x("//div[@data-qa-type='uikit/individualDesign.container']//img"),
            submitButton = $x("//button[@name='submit']"),
            clickFioField = $x("//div[@data-qa-type='uikit/inputFio.inputBox uikit/inputFio.inputBox_required']"),
            inputFioField = $x("//input[@data-qa-type='uikit/inputFio.value.input']"),
            inputMobilePhoneField = $x("//input[@data-qa-type='uikit/inputPhone.value.input']"),
            mobilePhoneMessage = $x("//div[@data-field-name='phone_mobile']//div[@data-qa-type='uikit/formRow.errorBlock']"),
            clickBirthField = $x("//div[@data-qa-type='uikit/input.inputBox uikit/input.inputBox_required']"),
            inputBirthField = $x("//input[@data-qa-type='uikit/input.value.input']"),
            birthMessage = $x("//div[@data-field-name='birthdate']//div[@data-qa-type='uikit/formRow.errorBlock']"),
            progressbar = $x("//div[@data-qa-type='uikit/sidebar.subtitle']");

    @Step("Проверить, что в анкете отображается выбранный дизайн карты")
    public AnketaPage checkCardDesign() {
        cardDesign.shouldHave(
                Condition.attribute(
                        "src",
                        "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzLzVhMGRjZDc5LTVjZGYtNGQ0Mi1iMTc3LWJmOWMzMDcyZDhhNi5wbmc="));
        return this;
    }

    @Step("Нажать на кнопку 'Продолжить'")
    public AnketaPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверить значение прогрессбара")
    public AnketaPage checkProgressbarValue(String value) {
        progressbar.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на поле ФИО")
    public AnketaPage clickFioField () {
        clickFioField.click();
        return this;
    }

    @Step("Ввести ФИО")
    public AnketaPage inputFio (String value) {
        clickFioField.click();
        inputFioField.setValue(value).pressEnter();
        return this;
    }

    @Step("Ввести телефон")
    public AnketaPage inputPhone (String value) {
        inputMobilePhoneField.setValue(value);
        return this;
    }

    @Step("Появилась ошибка валидации телефона")
    public AnketaPage mobileMessageAppered (String value) {
        mobilePhoneMessage.shouldHave(text(value));
        return this;
    }

    @Step("Перейти в поле дата рождения")
    public AnketaPage clickBirthField () {
        clickBirthField.click();
        return this;
    }

    @Step("Ввести дату рождения")
    public AnketaPage inputBirth (String value) {
        inputBirthField.setValue(value);
        return this;
    }

    @Step("Появилась ошибка валидации даты рождения")
    public AnketaPage birthMessageAppered (String value) {
        birthMessage.shouldHave(text(value));
        return this;
    }
}
