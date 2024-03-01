package test.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase{
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 87;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("golikovavi")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https//testing.gitab.com")
    @DisplayName("Поиск Issue в репозитории с реализацией через лябда-шаги")
    void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(byText("Search or jump to...")).click();
            $("#query-builder-test").setValue(REPOSITORY);
            $("#query-builder-test").submit();
                });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("golikovavi")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https//testing.gitab.com")
    @DisplayName("Поиск Issue в репозитории с реализацией через степики")
    void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssureTab();
        steps.shouldSeeIssueWithNamber(ISSUE);
    }
}
