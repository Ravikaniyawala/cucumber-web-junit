package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class SamplePointPage extends Page {
    By loadingSpinner = new By.ByCssSelector(".LoadingSpinner");
    By refreshButton = new By.ByCssSelector("button#refreshbutton");

    By tableRow = new By.ByCssSelector("tbody > tr");

    By tableCell = new By.ByCssSelector("td");

    By chartCardHeader = new By.ByCssSelector(".ChartCard-header");

    public SamplePointPage(TestContext context) throws Exception {
        super(context);
    }

    public void refreshPage() {
        find.findWebElement(refreshButton).click();
        find.waitForElementVisibility(refreshButton);
    }

    public void isLoaded(String expectedValue) {
        find.waitForElementText(pageTitle,expectedValue);
    }

    public void goToDetailsView(int row) throws Exception {
        this.getTableRows().get(row).click();
        find.waitForElementVisibility(chartCardHeader);
    }

    protected List<WebElement> getTableRows() throws Exception {
        return testContext.getTestDriverManager().getDriver().findElements(tableRow);
    }
}
