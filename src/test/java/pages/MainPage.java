package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement skills = $(byText("Навыки")),
            howSearchBugs = $(byText("Как искать баги")),
            theory = $(byText("Теория в картинках")),
            testIt = $(byText("Test it")),
            book = $(byText("Книга")),
            courses = $(byText("Курсы")),




            fizicClient = $x("//span[@data-test='menu-item-0-title']"),
            debetCard = $x("//span[@data-test='text-item-0-1-text']"),
            childCard = $x("//span[@data-test='text-item-0-3-text']"),

            minPrice = $x("//input[@placeholder='от']"),

            city = $("#geo-suggest-input"),
            selectCity = $x("//div[@data-group='cities']//strong"),
            rent = $(byText("Снять")),
            submitButton = $x("//button[@type='submit']");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Открыть меню для частных лиц")
    public MainPage openFizicClientMenu() {
        fizicClient.hover();
        return this;
    }

    @Step("Перейти на страницу дебетовых карт")
    public MainPage openDebetCardsPage() {
        debetCard.click();
        return this;
    }

    @Step("Перейти на страницу детских  карт")
    public MainPage openChildCardsPage() {
        childCard.click();
        return this;
    }


    @Step("Нажать на Навыки")
    public MainPage clickSkills() {
        skills.click();
        return this;
    }
    @Step("Нажать на Как искать баги")
    public MainPage clickHowSearchBugs() {
        howSearchBugs.click();
        return this;
    }

    @Step("Нажать на Теория в картинках")
    public MainPage clickTheory() {
        theory.click();
        return this;
    }

    @Step("Нажать на Test it")
    public MainPage clickTestIt() {
        testIt.click();
        return this;
    }

    @Step("Нажать Книга")
    public MainPage clickBook() {
        book.click();
        return this;
    }

    @Step("Нажать Курсы")
    public MainPage clickCourses() {
        courses.click();
        return this;
    }

    @Step("Нажать Найти")
    public MainPage submit() {
        submitButton.click();
        return this;
    }
}
