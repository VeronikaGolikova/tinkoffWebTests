package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class AnketaComponent {

    private final SelenideElement
            cardDesign = $x("//div[@data-qa-type='uikit/individualDesign.container']//img"),
            secondCardDesign = $x("//div[@data-qa-type='uikit/individualDesign.preview']"),
            submitButton = $x("//button[@name='submit']"),
            clickFioField = $x("//div[@data-qa-type='uikit/inputFio.inputBox uikit/inputFio.inputBox_required']"),
            inputFioField = $x("//input[@data-qa-type='uikit/inputFio.value.input']"),
            inputMobilePhoneField = $x("//input[@data-qa-type='uikit/inputPhone.value.input']"),
            mobilePhoneMessage = $x(
                    "//div[@data-field-name='phone_mobile']//div[@data-qa-type='uikit/formRow.errorBlock']"),
            clickBirthField = $x("//div[@data-qa-type='uikit/input.inputBox uikit/input.inputBox_required']"),
            inputBirthField = $x("//input[@data-qa-type='uikit/input.value.input']"),
            birthMessage = $x("//div[@data-field-name='birthdate']//div[@data-qa-type='uikit/formRow.errorBlock']"),
            progressbar = $x("//div[@data-qa-type='uikit/sidebar.subtitle']");

    @Step("Проверить, что в анкете отображается выбранный дизайн карты")
    public AnketaComponent checkCardDesign(String design) {
        cardDesign.shouldHave(
                Condition.attribute(
                        "src",
                        design));
        return this;
    }

    @Step("Изменить дизайн карты")
    public AnketaComponent changeCardDesign() {
        secondCardDesign.click();
        return this;
    }

    @Step("Нажать на кнопку 'Продолжить'")
    public AnketaComponent clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверить значение прогрессбара")
    public AnketaComponent checkProgressbarValue(String value) {
        progressbar.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на поле ФИО")
    public AnketaComponent clickFioField() {
        clickFioField.click();
        return this;
    }

    @Step("Ввести ФИО")
    public AnketaComponent inputFio(String value) {
        clickFioField.click();
        inputFioField.setValue(value).pressEnter();
        return this;
    }

    @Step("Ввести телефон")
    public AnketaComponent inputPhone(String value) {
        inputMobilePhoneField.setValue(value);
        return this;
    }

    @Step("Появилась ошибка валидации телефона")
    public AnketaComponent mobileMessageAppeared(String value) {
        mobilePhoneMessage.shouldHave(text(value));
        return this;
    }

    @Step("Перейти в поле дата рождения")
    public AnketaComponent clickBirthField() {
        clickBirthField.click();
        return this;
    }

    @Step("Ввести дату рождения")
    public AnketaComponent inputBirth(String value) {
        inputBirthField.setValue(value);
        return this;
    }

    @Step("Появилась ошибка валидации даты рождения")
    public AnketaComponent birthMessageAppeared(String value) {
        birthMessage.shouldHave(text(value));
        return this;
    }
}
