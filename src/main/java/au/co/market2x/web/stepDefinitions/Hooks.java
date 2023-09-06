package au.co.market2x.web.stepDefinitions;

//import com.saucelabs.saucerest.SauceREST;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.manager.ConfigurationManager;
import au.co.market2x.web.manager.TestDriverManager;
import org.openqa.selenium.WebDriver;


public class Hooks {

    WebDriver driver;
    TestContext testContext;
    TestDriverManager testDriverManager;

    public Hooks(TestContext context) {
        testContext = context;
        testDriverManager = testContext.getTestDriverManager();
    }

    @Before
    public void beforeScenario() throws Exception {
        ConfigurationManager.loadTestConfig();
        driver = testDriverManager.getDriver();
//        driver.navigate().to(ConfigurationManager.farmBotStagingurl);
    }


    @After
    public void afterScenario(Scenario scenario) {

        testDriverManager.closeDriver();
    }

    private static void failedScenario(Scenario scenario) {

//        if (TestDriver.getProperties().getProperty("execution.type").equals("local")) {
//
//            byte[] imageBytes = TestDriver.browser().saveScreenshot();
//            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
//
//            try {
//                BufferedImage bImage = ImageIO.read(bis);
//                ImageIO.write(bImage, "png", new File("C:/screenshots/" + scenario.getName() + ".png"));
//            } catch (Exception e) {
//
//                LogUtil.log("Folder Not found");
//            }
//
//        }
    }
}
