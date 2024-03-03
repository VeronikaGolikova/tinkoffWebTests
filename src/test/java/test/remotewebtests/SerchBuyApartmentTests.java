package test.remotewebtests;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainTestbasePage;
import pages.SearchResultPage;

import java.util.Locale;

import static utils.RandomUtils.getRandomInt;

@Owner("golikovavi")
@Epic("Поиск на главной странице")
@Story("Поиск для покупки квартиры")
@Severity(SeverityLevel.BLOCKER)
@Tag("regress")
public class SerchBuyApartmentTests extends TestBase {

    MainTestbasePage mainTestbasePage = new MainTestbasePage();
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
        mainTestbasePage.openPage()
                .clickTheory()
                .clickCourses()
                .clickBook()
                .clickTestIt();
    }

    @Test
    @Disabled
    @DisplayName("Поиск с заданным ценовым диапазоном")
    void searchWithPriceParameter() {

    }

    @Test
    @Disabled
    @DisplayName("Поиск с верхним значением ценового диапазоноа")
    void searchWithMaxPriceParameter() {

    }

    @Test
    @Disabled
    @DisplayName("Поиск в конкретном городе")
    void searchWithCityParameter() {

    }

    @Test
    @Disabled
    @DisplayName("Поиск с заполнением всех параметров")
    void searchWithAllParameters() {

    }
}
