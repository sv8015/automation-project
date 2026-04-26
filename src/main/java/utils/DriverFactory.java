package utils;

import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = System.getProperty("browser",
                ConfigReader.get("browser"));
        String headless = System.getProperty("headless",
                ConfigReader.get("headless"));

        browser = (browser == null) ? "chrome" : browser.trim().toLowerCase();
        headless = (headless == null) ? "true" : headless.trim().toLowerCase();

        boolean isHeadless = "true".equalsIgnoreCase(headless);

        System.out.println("Launching browser: " + browser + " | headless=" + headless);

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (isHeadless) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            driver.set(new ChromeDriver(options));

        } else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (isHeadless) {
                options.addArguments("--headless");
            }

            driver.set(new FirefoxDriver(options));

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
