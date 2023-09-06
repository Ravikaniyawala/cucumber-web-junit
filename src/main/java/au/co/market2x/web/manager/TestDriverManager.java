package au.co.market2x.web.manager;

import au.co.market2x.web.cucumber.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestDriverManager {

    private WebDriver driver;
    private TestContext testContext;

    private static final String WINDOW_WIDTH = System.getenv("window_width");
    private static final String WINDOW_HEIGHT = System.getenv("window_height");
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";
    private static final String EDGE = "edge";
    private static final String SAFARI = "safari";
    private static final String WINDOW_SIZE = "--window-size="+WINDOW_WIDTH+"x"+WINDOW_HEIGHT;

    public TestDriverManager(TestContext context) {
        this.testContext = context;
    }

    public WebDriver getDriver() throws Exception {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() throws Exception {
        switch (ConfigurationManager.browser.toLowerCase())
        {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if(Session.isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=2048,1536");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--ignore-certificate-errors");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                if(Session.isHeadless) {
                    firefoxBinary.addCommandLineOptions("--headless");
                }
                firefoxBinary.addCommandLineOptions(WINDOW_SIZE);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case SAFARI:
                driver = new SafariDriver();
                return new SafariDriver();
            default:
                throw new Exception("Invalid Browser");
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}

