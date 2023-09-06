package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.helper.ThreadSleep;
import au.co.market2x.web.manager.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

public class BookingLogInPage extends Page {
    By market2xLogo = new By.ByCssSelector(".m2x-logo");
    By signinWithEmail = new By.ByCssSelector("button[data-provider-id=\"password\"]");
    By emailInput = new By.ById("ui-sign-in-email-input");
    By submitButton = new By.ByCssSelector("button[type=submit]");
    By passwordInput = new By.ById("ui-sign-in-password-input");
    By signInButton = new By.ByXPath("//button[contains(text(),'Sign In')]");

    BookingHomePage bookingHomePage;

    public BookingLogInPage(TestContext context) throws Exception {
        super(context);
        bookingHomePage = testContext.getPageObjectManager().getBookingHomePage();
    }

    public BookingHomePage login(String email, String password) {
        find.findWebElement(emailInput).sendKeys(email);
        find.findWebElement(submitButton).click();
        find.findWebElement(passwordInput).sendKeys(password);
        find.findWebElement(signInButton).click();
        return bookingHomePage;
    }

    public BookingLogInPage goToPage() throws Exception {
        testDriverManager.getDriver().navigate().to(Session.BookingPageURL);
        ThreadSleep.For(5);
        testDriverManager.getDriver().navigate().to(Session.BookingPageURL);
        find.findWebElement(signinWithEmail).click();
        isLoaded();
        return this;
    }

    public void isLoaded(){
        find.findWebElement(market2xLogo);
        find.findWebElement(emailInput);
    }
}
