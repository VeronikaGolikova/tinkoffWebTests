package test.remotewebtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    void setUpConfig() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);
        Configuration.baseUrl = "https://www.tinkoff.ru/";
        Configuration.pageLoadStrategy = driverConfig.pageLoadStrategy();
        Configuration.browser = driverConfig.browserName();
        Configuration.browserVersion = driverConfig.browserVersion();
        Configuration.browserSize = driverConfig.browserSize();
        Configuration.remote = driverConfig.remoteUrl();
        Configuration.pageLoadStrategy = driverConfig.pageLoadStrategy();
        if (driverConfig.remoteUrl() != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
