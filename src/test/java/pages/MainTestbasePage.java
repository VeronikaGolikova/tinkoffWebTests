package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainTestbasePage {
    private final SelenideElement skills = $(byText("Навыки")),
            howSearchBugs = $(byText("Как искать баги")),
            theory = $(byText("Теория в картинках")),
            testIt = $(byText("Test it")),
            book = $(byText("Книга")),
            courses = $(byText("Курсы")),




            filterPrice = $x("//div[@data-mark='FilterPrice']/button"),
            minPrice = $x("//input[@placeholder='от']"),

            city = $("#geo-suggest-input"),
            selectCity = $x("//div[@data-group='cities']//strong"),
            rent = $(byText("Снять")),
            submitButton = $x("//button[@type='submit']");

    @Step("Открыть главную страницу")
    public MainTestbasePage openPage() {
        open("");
        return this;
    }
    @Step("Нажать на Навыки")
    public MainTestbasePage clickSkills() {
        skills.click();
        return this;
    }
    @Step("Нажать на Как искать баги")
    public MainTestbasePage clickHowSearchBugs() {
        howSearchBugs.click();
        return this;
    }

    @Step("Нажать на Теория в картинках")
    public MainTestbasePage clickTheory() {
        theory.click();
        return this;
    }

    @Step("Нажать на Test it")
    public MainTestbasePage clickTestIt() {
        testIt.click();
        return this;
    }

    @Step("Нажать Книга")
    public MainTestbasePage clickBook() {
        book.click();
        return this;
    }

    @Step("Нажать Курсы")
    public MainTestbasePage clickCourses() {
        courses.click();
        return this;
    }

    @Step("Нажать Найти")
    public MainTestbasePage submit() {
        submitButton.click();
        return this;
    }
}
