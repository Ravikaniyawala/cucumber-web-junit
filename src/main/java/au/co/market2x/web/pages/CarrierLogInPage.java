package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.helper.ThreadSleep;
import au.co.market2x.web.manager.Session;
import org.openqa.selenium.By;

public class CarrierLogInPage extends Page {
    By market2xLogo = new By.ByCssSelector(".m2x-logo");
    By signInWithEmail = new By.ByCssSelector("button[data-provider-id=\"password\"]");
    By emailInput = new By.ById("ui-sign-in-email-input");
    By submitButton = new By.ByCssSelector("button[type=submit]");
    By passwordInput = new By.ById("ui-sign-in-password-input");
    By signInButton = new By.ByXPath("//button[contains(text(),'Sign In')]");

    CarrierHomePage carrierHomePage;

    public CarrierLogInPage(TestContext context) throws Exception {
        super(context);
        carrierHomePage = testContext.getPageObjectManager().getCarrierHomePage();
    }

    public void login(String email, String password) {
        find.findWebElement(emailInput).sendKeys(email);
        find.findWebElement(submitButton).click();
        find.findWebElement(passwordInput).sendKeys(password);
        find.findWebElement(signInButton).click();
    }

    public CarrierLogInPage goToPage() throws Exception {
        testDriverManager.getDriver().navigate().to(Session.CarrierPageURL);
        ThreadSleep.For(5);
        testDriverManager.getDriver().navigate().to(Session.CarrierPageURL);
        find.findWebElement(signInWithEmail).click();
        isLoaded();
        return this;
    }

    public void isLoaded(){
        find.findWebElement(market2xLogo);
        find.findWebElement(emailInput);
    }
}
