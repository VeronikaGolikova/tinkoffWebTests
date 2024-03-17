package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${environment}.properties",
        "classpath:local.properties"
})
public interface DriverConfig extends Config {
    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    @DefaultValue("113.0")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remote.url")
    @DefaultValue("http://localhost:4444")
    String remoteUrl();
}