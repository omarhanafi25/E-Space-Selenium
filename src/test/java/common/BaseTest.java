package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ExtentReportManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static utilities.ExtentReportManager.*;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }

    public String remote = System.getProperty("remote");

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void startDriverSession(@Optional("chrome") String browser) {
        try {
            initializeDriver(browser);
            startReporting();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start WebDriver session", e);
        }
    }

    private void initializeDriver(String browser) {
        WebDriver localDriver;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Objects.equals(remote, "true")) {
                    chromeOptions.addArguments("--headless=new");
                    localDriver = new ChromeDriver(chromeOptions);
                    Map<String, Object> coordinates = new HashMap<>();
                    coordinates.put("latitude", 31.2156);
                    coordinates.put("longitude", 29.9553);
                    coordinates.put("accuracy", 100);
                    ((ChromeDriver) localDriver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
                } else {
                    localDriver = new ChromeDriver();
                }
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (Objects.equals(remote, "true")) {
                    edgeOptions.addArguments("--headless=new");
                    localDriver = new EdgeDriver(edgeOptions);
                } else {
                    localDriver = new EdgeDriver();
                }
                break;
            case "firefox":
                localDriver = new FirefoxDriver();
                break;
            case "safari":
                localDriver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.set(localDriver);
        configureDriver();
    }

    private void configureDriver() {
        getDriver().manage().window().maximize();
        getDriver().get(PropertiesLoader.readEnvFile("URL"));
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) throws IOException {
        ExtentReportManager.beforeMethod(method);
    }

    @AfterMethod(alwaysRun = true)
    public void A_takeScreenShot(ITestResult result) throws IOException, InterruptedException {
        takeScreenshot(result, getDriver());
        System.out.println("screenshot captured");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
        flushReport();
        System.out.println("Report path is here:  " + reportName);
    }
}
