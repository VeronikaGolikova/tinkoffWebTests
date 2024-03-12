package test.remotewebtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultPage;

@Owner("golikovavi")
@Epic("Фильтрация по категориям карт")
@Severity(SeverityLevel.BLOCKER)
@Tag("regress")
@Tag("owner")
public class SerchDebitCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    @DisplayName("Переход в раздел 'Дебетовая карта'")
    void clickMenuPages() {
        mainPage.openPage("")
                .openFizicClientMenu();
        searchResultPage.healerHasText("Дебетовые карты");
    }

    @Test
    @DisplayName("Фильтрация Премиальных карт")
    void filterPremiumCard() {
        mainPage.openPage("/cards/debit-cards/")
                .filterPremiumCards();
        searchResultPage.healerHasText("Премиальные дебетовые карты")
                .filterResults("Premium");
    }

    @Test
    @DisplayName("Фильтрация карт Путешественнику")
    void filterTravelerCard() {
        mainPage.openPage("")
                .openFizicClientMenu()
                .filterTravelerCards();
        searchResultPage.healerHasText("Дебетовые карты для путешествий")
                .filterResults("ALL Airlines");
    }

    @Test
    @DisplayName("Фильтрация карт для автомобилиста")
    void filterDriveCard() {
        mainPage.openPage("/cards/debit-cards/")
                .filterDriverCards();
        searchResultPage.healerHasText("Дебетовые карты для водителей")
                .filterResults("Tinkoff Drive");
    }

    @Test
    @DisplayName("Фильтрация карт для геймера")
    void filterGameCard() {
        mainPage.openPage("/cards/debit-cards/")
                .filterGamesCards();
        searchResultPage.healerHasText("Дебетовые карты для геймеров")
                .filterResults("ALL Games");
    }

    @Test
    @DisplayName("Фильтрация карт для покупок")
    void filterShoppingCard() {
        mainPage.openPage("/cards/debit-cards/")
                .filterShoppingCards();
        searchResultPage.healerHasText("Дебетовые карты для покупок")
                .filterResults("Black");
    }
}
