package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SmsComponent {

    private final SelenideElement
            header = $x("//h5"),
            sectionTitle = $x("//div[@data-qa-type='uikit/sectionTitle']/p/span"),
            changePhone = $x("//div[@data-qa-type='uikit/formRow']//span[@data-qa-type='uikit/button.content']");

    @Step("Заголовок содержит текст 'Подтвердите мобильный телефон'")
    public SmsComponent checkHeaderText() {
        header.shouldHave(text("Подтвердите мобильный телефон"));
        return this;
    }

    @Step("Подзаголовок содержит текст 'Код подтверждения отправлен вам на номер:'")
    public SmsComponent checkSectionTitle() {
        sectionTitle.shouldHave(text("Код подтверждения отправлен вам на номер:"));
        return this;
    }

    @Step("Проверить наличие кнопки 'Изменить номер телефона'")
    public SmsComponent changePhoneNumberIsVisible() {
        changePhone.shouldBe(visible);
        return this;
    }
}
