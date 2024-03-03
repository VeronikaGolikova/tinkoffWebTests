package test.remotewebtests;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import pages.MainPage;
import pages.SearchResultPage;

import java.util.Locale;

import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Epic("Поиск на главной странице")
@Story("Поиск для покупки квартиры")
@Severity(SeverityLevel.BLOCKER)
@Tag("regress")
public class SerchDebitCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    Faker faker = new Faker(new Locale("ru"));
    String food = faker.food().ingredient();
    String minSum = String.valueOf(getRandomInt(10000, 20000));
    String maxSum = String.valueOf(getRandomInt(20000, 100000));
    String rentText = "Аренда";
    String rentText2 = "Снять";

    @Test
    @DisplayName("Переход в раздел сайта дебетовая детская карта")
    void clickMenuPages() {
        mainPage.openPage()
                .openFizicClientMenu()
                .openChildCardsPage();
        searchResultPage.healerHasText("Бесплатная дебетовая детская карта");
    }

    @Test
    @DisplayName("Поиск с заданным ценовым диапазоном")
    void searchWithPriceParameter() {
        mainPage.openPage();
    }

    @Test
    @DisplayName("Поиск с верхним значением ценового диапазоноа")
    void searchWithMaxPriceParameter() {
        mainPage.openPage();

    }

    @Test
    @DisplayName("Поиск в конкретном городе")
    void searchWithCityParameter() {
        mainPage.openPage();
    }

    @Test
    @DisplayName("Поиск с заполнением всех параметров")
    void searchWithAllParameters() {
        mainPage.openPage();
    }
}
