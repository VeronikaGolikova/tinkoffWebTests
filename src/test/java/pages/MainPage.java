package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            fizClient = $(byText("Частным лицам")),
            debetCard = $x("//a[@href='/cards/debit-cards/']"),
            premiumDebetCard = $x("//a[@href='/cards/debit-cards/premium/']"),
            travelerDebetCard = $x("//a[@href='/cards/debit-cards/travel/']"),
            driverDebetCard = $x("//a[@href='/cards/debit-cards/driver/']"),
            gamesDebetCard = $x("//a[@href='/cards/debit-cards/games/']"),
            shoppingDebetCard = $x("//a[@href='/cards/debit-cards/shopping/']");
;

    @Step("Открыть страницу")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Открыть меню для частных лиц и перейти в раздел дебетовых карт")
    public MainPage openFizicClientMenu() {
        fizClient.hover();
        debetCard.click();
        return this;
    }

    @Step("Перейти на страницу дебетовых карт")
    public MainPage openDebetCardsPage() {
        debetCard.click();
        return this;
    }

    @Step("Перейти на вкладку премиальных карт")
    public MainPage filterPremiumCards() {
        premiumDebetCard.click();
        return this;
    }
    @Step("Перейти на вкладку карт для путешественника")
    public MainPage filterTravelerCards() {
        travelerDebetCard.click();
        return this;
    }
    @Step("Перейти на вкладку карт для автомобилиста")
    public MainPage filterDriverCards() {
        driverDebetCard.click();
        return this;
    }
    @Step("Перейти на вкладку карт для геймера")
    public MainPage filterGamesCards() {
        gamesDebetCard.click();
        return this;
    }
    @Step("Перейти на вкладку карт для покупок")
    public MainPage filterShoppingCards() {
        shoppingDebetCard.click();
        return this;
    }





}
