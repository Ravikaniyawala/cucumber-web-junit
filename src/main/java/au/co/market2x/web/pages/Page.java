package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.manager.ExecutionData;
import au.co.market2x.web.manager.TestDriverManager;
import au.co.market2x.web.webelement.FindWebElement;
import org.openqa.selenium.By;

public abstract class Page {
    By pageTitle = new By.ByCssSelector("div.DefaultPageHeader-title");

    TestContext testContext;
    TestDriverManager testDriverManager;
    protected FindWebElement find;
    ExecutionData executionData;

    public Page(TestContext context) throws Exception {
        testContext = context;
        this.find = testContext.getPageObjectManager().getFindWebElement();
        testDriverManager = testContext.getTestDriverManager();
        executionData = testContext.getExecutionData();
    }
}
