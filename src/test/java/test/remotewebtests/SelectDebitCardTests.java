package test.remotewebtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import components.AnketaComponent;
import pages.CardPage;
import components.SmsComponent;
import utils.RandomUtils;

@Owner("golikovavi")
@Epic("Заполнение анкеты на дебетовую карту")
@Severity(SeverityLevel.BLOCKER)
public class SelectDebitCardTests extends TestBase {

    CardPage cardPage = new CardPage();
    AnketaComponent anketaComponent = new AnketaComponent();
    SmsComponent smsComponent = new SmsComponent();
    RandomUtils randomUtils = new RandomUtils();
    private final static String URL = "/cards/debit-cards/";

    private final static String DESIGN_COMMON_URL = "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/";
    private final static String FIRST_DESIGN = DESIGN_COMMON_URL +
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzLzkxOTRhMzIyLWIxMzMtNGJkNy1iMDI4LWY" +
            "3OTg4ODcyYzRkMS5wbmc=";
    private final static String SECOND_DESIGN = DESIGN_COMMON_URL +
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzLzVhMGRjZDc5LTVjZGYtNGQ0Mi1iMTc3LWJ" +
            "mOWMzMDcyZDhhNi5wbmc=";

    @Test
    @DisplayName("Проверить отображение предвыбранного дизайна карты")
    void cardHasDesignValue() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.checkCardDesign(FIRST_DESIGN);
    }

    @Test
    @DisplayName("Возможность изменить предвыбранный дизайн карты")
    void changeCardDesign() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.checkCardDesign(FIRST_DESIGN)
                .changeCardDesign()
                .checkCardDesign(SECOND_DESIGN);
    }

    @Test
    @DisplayName("Увеличение значения прогрессбара")
    void checkProgressBarValue() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.checkProgressbarValue("5%")
                .clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .checkProgressbarValue("25%")
                .inputPhone(randomUtils.getRandomPhoneNumber(10))
                .checkProgressbarValue("45%");
    }

    @Test
    @DisplayName("Заполнение всех обязательных полей в анкете, переход на страницу СМС")
    void fillAllMandatoryFields() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumber(10))
                .clickBirthField()
                .inputBirth(randomUtils.getRandomBirthDateOfAge(14, 100))
                .clickSubmitButton();
        smsComponent.checkHeaderText()
                .checkSectionTitle()
                .changePhoneNumberIsVisible();
    }

    @Test
    @DisplayName("Проверка валидации. В поле мобильный телефон введено 9 цифр")
    void mobileFieldValidationIncorrectLength() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumber(9))
                .clickBirthField()
                .mobileMessageAppeared("Номер телефона должен состоять из 10 цифр");
    }

    @Test
    @DisplayName("Проверка валидации. В поле мобильный телефон введен неверный код региона")
    void mobileFieldValidationIncorrectRegionCode() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumberWithWrongRegionCode())
                .clickBirthField()
                .mobileMessageAppeared(
                        "Проверьте код оператора или региона — он может начинаться на 3, 4, 5, 6, 8, 9");
    }

    @Test
    @DisplayName("Проверка валидации. В поле дата рождения введен невалидный год рождения")
    void birthFieldValidationIncorrectDate() {
        cardPage.openPage(URL)
                .clickGetCardButton();
        anketaComponent.clickFioField()
                .inputFio(randomUtils.getRandomFullName())
                .inputPhone(randomUtils.getRandomPhoneNumber(10))
                .clickBirthField()
                .inputBirth(randomUtils.getRandomBirthDateOfAge(1, 13))
                .clickSubmitButton()
                .birthMessageAppeared("Вам должно быть от 14 до 100 лет");
    }
}
