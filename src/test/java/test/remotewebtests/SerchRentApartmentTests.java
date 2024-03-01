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

import static com.codeborne.selenide.Selenide.sleep;
import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Epic("Поиск на главной странице")
@Story("Поиск для покупки квартиры")
@Severity(SeverityLevel.BLOCKER)
@Tag("regress")
public class SerchRentApartmentTests extends TestBase {

    MainCianPage mainCianPage = new MainCianPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    Faker faker = new Faker(new Locale("ru"));
    String city = faker.address().city();
    String minSum = String.valueOf(getRandomInt(10000, 20000));
    String maxSum = String.valueOf(getRandomInt(20000, 100000));
    String rentText = "Аренда";
    String rentText2 = "Снять";

    @Test
    @DisplayName("Поиск с параметрами по умолчанию")
    void searchWithDefaultParameters() {
        mainCianPage.openPage()
                .selectRent()
                .submit();
        sleep(3000);
        searchResultPage.offerExists()
                .healerHasText(rentText);
    }

    @Test
    @DisplayName("Поиск с заданным ценовым диапазоном")
    void searchWithPriceParameter() {
        mainCianPage.openPage()
                .selectRent()
                .clickFilterPrice()
                .setMinSum(minSum)
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(rentText2);
    }

    @Test
    @DisplayName("Поиск с верхним значением ценового диапазоноа")
    void searchWithMaxPriceParameter() {
        mainCianPage.openPage()
                .selectRent()
                .clickFilterPrice()
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(rentText2);
    }

    @Test
    @DisplayName("Поиск в конкретном городе")
    void searchWithCityParameter() {
        mainCianPage.openPage()
                .selectRent()
                .setCity(city)
                .selectCity()
                .submit();
        searchResultPage.offerExists()
                .offerHasText(city)
                .healerHasText(rentText);
    }

    @Test
    @DisplayName("Поиск с заполнением всех параметров")
    void searchWithAllParameters() {
        mainCianPage.openPage()
                .selectRent()
                .clickFilterPrice()
                .setMinSum(minSum)
                .setMaxSum(maxSum)
                .setCity(city)
                .selectCity()
                .submit();
        searchResultPage.offerExists()
                .offerHasText(city)
                .healerHasText(rentText2);
    }
}
