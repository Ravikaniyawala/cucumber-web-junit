package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import au.co.market2x.web.manager.ConfigurationManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = "au.co.market2x.web.stepDefinitions",
    plugin = {"pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber/cucumberIos.json"
    }
    , tags = "@smoketest"
)

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @BeforeClass
    public static void setUp() {
        try {
            loadConfiguration();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void loadConfiguration() throws IOException {
        logger.info("Logs Initiated for test");
        ConfigurationManager.loadTestConfig();
    }
}
