package au.co.market2x.web.webelement;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.helper.ThreadSleep;
import au.co.market2x.web.manager.TestDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FindWebElement {

    private WebDriver driver;
    private Wait<WebDriver> wait;
    private WebDriverWait webDriverWait;
    private TestContext testContext;
    private TestDriverManager testDriverManager;

    public FindWebElement(TestContext context) throws Exception {
        this.testContext = context;
        this.testDriverManager = testContext.getTestDriverManager();
        this.driver = testDriverManager.getDriver();

        wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(NoSuchElementException.class);

        webDriverWait = new WebDriverWait(driver, 60 * 5);
    }



    private static final Logger logger = LoggerFactory.getLogger(FindWebElement.class);



    public void clickDisplayedElement(By byLocator){
        for (WebElement element : webElement(byLocator)) {
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }

    public WebElement findWebElement(By byLocator) {
        logger.info("Finding element " + byLocator);

        WebElement element = wait.until(d -> (WebElement) d.findElement(byLocator));

        logger.info("Found  Element " + byLocator);

        return element;
    }

    public void waitForInVisibilityOfElement(By byLocator) {
        logger.info("Finding element " + byLocator);
        ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(byLocator));
        logger.info("Found  Element " + byLocator);
    }

    public void waitForElementText(By byLocator,String text) {
        logger.info("Finding element " + byLocator);
        WebElement element = wait.until(d -> (WebElement) d.findElement(byLocator));
        wait.until(d -> element.getText().equals(text));
        logger.info("Found  Element " + byLocator);
    }

    public void waitForElementVisibility(By byLocator) {
        logger.info("Finding element " + byLocator);
        wait.until(d -> (WebElement) d.findElement(byLocator));
        logger.info("Found  Element " + byLocator);
    }

    public List<WebElement> webElement(By byLocator) {
        return wait.until(d -> (List<WebElement>) d.findElements(byLocator));
    }
    public List<String> webElementOptions(By byLocator) {
        List<String> a = new ArrayList<>();
        List<WebElement> text = webElement(byLocator);
        for (int i = 0; i < text.size(); i++) {
            a.add(text.get(i).getText());
            System.out.println(text.get(i).getText());
        }
        return a;
    }


    public void webElementRendering(By byLocator, int numTries) {

        logger.info("Trying to find element " + byLocator + " # of tries: " + numTries);

        int tries =0;
        while (!(wait.until(d -> (List<WebElement>) d.findElements(byLocator)).size()>0)) {
            tries += 1;
            ThreadSleep.For(5);
            if (numTries == tries) {
                break;
            }
        }
    }
}