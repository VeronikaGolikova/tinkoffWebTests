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
import pages.MainCianPage;
import pages.SearchResultPage;
import test.searchLocal.TestBase;

import java.util.Locale;

import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Epic("Поиск на главной странице")
@Story("Поиск для покупки квартиры")
@Severity(SeverityLevel.BLOCKER)
@Tag("regress")
public class SerchBuyApartmentTests extends TestBase {

    MainCianPage mainCianPage = new MainCianPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    Faker faker = new Faker(new Locale("ru"));
    String city = faker.address().city();
    String minSum = String.valueOf(getRandomInt(1000000, 2000000));
    String maxSum = String.valueOf(getRandomInt(4000000, 8000000));
    String buyText = "Продажа";
    String buyText2 = "Купить";

    @Test
    @DisplayName("Поиск с параметрами по умолчанию")
    void searchWithDefaultParameters() {
        mainCianPage.openPage()
                .submit();
        searchResultPage.offerExists()
                .healerHasText(buyText);
    }

    @Test
    @DisplayName("Поиск с заданным ценовым диапазоном")
    void searchWithPriceParameter() {
        mainCianPage.openPage()
                .clickFilterPrice()
                .setMinSum(minSum)
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(buyText2);
    }

    @Test
    @DisplayName("Поиск с верхним значением ценового диапазоноа")
    void searchWithMaxPriceParameter() {
        mainCianPage.openPage()
                .clickFilterPrice()
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(buyText2);
    }

    @Test
    @DisplayName("Поиск в конкретном городе")
    void searchWithCityParameter() {
        mainCianPage.openPage()
                .setCity(city)
                .selectCity()
                .submit();
        searchResultPage.offerExists()
                .offerHasText(city)
                .healerHasText(buyText);
    }

    @Test
    @DisplayName("Поиск с заполнением всех параметров")
    void searchWithAllParameters() {
        mainCianPage.openPage()
                .clickFilterPrice()
                .setMinSum(minSum)
                .setMaxSum(maxSum)
                .setCity(city)
                .selectCity()
                .submit();
        searchResultPage.offerExists()
                .offerHasText(city)
                .healerHasText(buyText2);
    }
}
