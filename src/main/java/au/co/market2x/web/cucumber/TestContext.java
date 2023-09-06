package au.co.market2x.web.cucumber;


import au.co.market2x.web.manager.ExecutionData;
import au.co.market2x.web.manager.TestDriverManager;
import au.co.market2x.web.manager.PageObjectManager;

public class TestContext {
    private TestDriverManager testDriverManager;
    private PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;
    public ExecutionData executionData;

    public TestContext() {
        testDriverManager = new TestDriverManager(this);
        pageObjectManager = new PageObjectManager(this);
        scenarioContext = new ScenarioContext();
        executionData = new ExecutionData();
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public TestDriverManager getTestDriverManager() {
        return testDriverManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public ExecutionData getExecutionData(){return executionData; }

}
