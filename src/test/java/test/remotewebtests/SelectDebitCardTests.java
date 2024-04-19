package test.remotewebtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AnketaPage;
import pages.MainPage;
import pages.SelectDesignPage;
import pages.SmsPage;
import utils.RandomUtils;

@Owner("golikovavi")
@Epic("Заполнение анкеты на дебетовую карту")
@Severity(SeverityLevel.BLOCKER)
public class SelectDebitCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    SelectDesignPage selectDesignPage = new SelectDesignPage();
    AnketaPage anketaPage = new AnketaPage();
    SmsPage smsPage = new SmsPage();
    RandomUtils randomUtils = new RandomUtils();
    private final String URL = "/cards/debit-cards/";

    @Test
    @DisplayName("Выбор дизайна карты в слайдере")
    void filterShoppingCard() {
        mainPage.openPage(URL)
                .filterShoppingCards()
                .headerHasText("Дебетовые карты для покупок")
                .filterResultsHasText("Black")
                .clickMoreButton();
        selectDesignPage.titleHasText()
                .clickSlider()
                .imgHasValue("Вулкан Толбачик, Камчатский край")
                .clickSlider()
                .imgHasValue("Остров Ижилхей, Байкал, Иркутская область");
    }

    @Test
    @DisplayName("Перейти к заполнению анкеты после выбора дизайна")
    void openAnketaWithCardDisign() {
        mainPage.openPage(URL)
                .filterShoppingCards()
                .headerHasText("Дебетовые карты для покупок")
                .filterResultsHasText("Black")
                .clickMoreButton();
        selectDesignPage.titleHasText()
                .clickSlider()
                .imgHasValue("Вулкан Толбачик, Камчатский край")
                .clickSelectThisCard();
        anketaPage.checkCardDesign();
    }

    @Test
    @DisplayName("Увеличение значения прогрессбара")
    void checkProgressBarValue() {
        mainPage.openPage(URL)
                .clickGetCardBatton();
        anketaPage.checkProgressbarValue("5%")
                .clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .checkProgressbarValue("25%")
                .inputPhone(randomUtils.getRandomPhoneNumber(10))
                .checkProgressbarValue("45%");
    }

    @Test
    @DisplayName("Заполнение всех обязательных полей в анкете, переход на страницу СМС")
    void fillAllMandatoryFields() {
        mainPage.openPage(URL)
                .clickGetCardBatton();
        anketaPage.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumber(10))
                .clickBirthField()
                .inputBirth(randomUtils.getRandomBirthDateOfAge(14, 100))
                .clickSubmitButton();
        smsPage.checkHeaderText()
                .checkSectionTitle()
                .changePhoneNumberIsVisible();
    }

    @Test
    @DisplayName("Проверка валидации. В поле мобильный телефон введено 9 цифр")
    void mobileFieldValidationIncorrectLength() {
        mainPage.openPage(URL)
                .clickGetCardBatton();
        anketaPage.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumber(9))
                .clickBirthField()
                .mobileMessageAppered("Номер телефона должен состоять из 10 цифр");
    }

    @Test
    @DisplayName("Проверка валидации. В поле мобильный телефон введен неверный код региона")
    void mobileFieldValidationIncorrectRegionCode() {
        mainPage.openPage(URL)
                .clickGetCardBatton();
        anketaPage.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumberWithWrongRegionCode())
                .clickBirthField()
                .mobileMessageAppered(
                        "Проверьте код оператора или региона — он может начинаться на 3, 4, 5, 6, 8, 9");
    }

    @Test
    @DisplayName("Проверка валидации. В поле дата рождения введен невалидный год рождения")
    void birthFieldValidationIncorrectDate() {
        mainPage.openPage(URL)
                .clickGetCardBatton();
        anketaPage.clickBirthField()
                .inputBirth(randomUtils.getRandomBirthDateOfAge(1, 13))
                .clickSubmitButton()
                .birthMessageAppered("Вам должно быть от 14 до 100 лет");
    }
}
