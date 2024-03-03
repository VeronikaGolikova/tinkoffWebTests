package test.searchLocal;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainTestbasePage;
import pages.SearchResultPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.sleep;
import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Epic("Поиск на главной странице")
@Story("Поиск для покупки квартиры")
@Severity(SeverityLevel.BLOCKER)
@Tag("local")
public class SerchBuyApartmentTests extends TestBase {

    MainTestbasePage mainTestbasePage = new MainTestbasePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    Faker faker = new Faker(new Locale("ru"));
    String food = faker.food().ingredient();
    String minSum = String.valueOf(getRandomInt(1000000, 2000000));
    String maxSum = String.valueOf(getRandomInt(4000000, 8000000));
    String buyText = "Продажа";
    String buyText2 = "Купить";

    @Test
    @DisplayName("Поиск с параметрами по умолчанию")
    void searchWithDefaultParameters() {
        mainTestbasePage.openPage()
                .inputSearchGoods(food)
                .submit();
        sleep(3000);
    }

    @Test
    @DisplayName("Поиск с заданным ценовым диапазоном")
    void searchWithPriceParameter() {
        mainTestbasePage.openPage()
                .setMinSum(minSum)
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(buyText2);
    }

    @Test
    @DisplayName("Поиск с верхним значением ценового диапазоноа")
    void searchWithMaxPriceParameter() {
        mainTestbasePage.openPage()
                .setMaxSum(maxSum)
                .submit();
        searchResultPage.offerExists()
                .healerHasText(buyText2);
    }

    @Test
    @DisplayName("Поиск в конкретном городе")
    void searchWithCityParameter() {
        mainTestbasePage.openPage()

                .selectCity()
                .submit();
        searchResultPage.offerExists()

                .healerHasText(buyText);
    }

    @Test
    @DisplayName("Поиск с заполнением всех параметров")
    void searchWithAllParameters() {
        mainTestbasePage.openPage()
                .setMinSum(minSum)
                .setMaxSum(maxSum)

                .selectCity()
                .submit();
    }
}
