package test.github;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest extends TestBase{

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("golikovavi")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https//testing.gitab.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    void testStaticLabels(){

    }

    @Test
    void testDynamicLabels(){

    }
}
