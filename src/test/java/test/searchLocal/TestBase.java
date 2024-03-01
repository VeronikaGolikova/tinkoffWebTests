package test.searchLocal;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browser_version", "113.0");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        String browserConfig = String.format("Browser: %s, version: %s, window size: %s",
                browser, browserVersion, browserSize);
        System.out.println(browserConfig);
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://www.cian.ru/";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
