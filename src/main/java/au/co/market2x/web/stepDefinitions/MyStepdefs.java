package au.co.market2x.web.stepDefinitions;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.manager.ConfigurationManager;
import au.co.market2x.web.manager.ExecutionData;
import au.co.market2x.web.manager.TestDriverManager;
import au.co.market2x.web.pages.*;
import au.co.market2x.web.webelement.FindWebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;


public class MyStepdefs {

    private BookingHomePage bookingHomePage;
    private BookingLogInPage bookingLogInPage;
    private CarrierHomePage carrierHomePage;
    private CarrierLogInPage carrierLogInPage;


    TestContext testContext;
    TestDriverManager testDriverManager;
    ExecutionData executionData;
    FindWebElement find;

    private static final Logger logger = LoggerFactory.getLogger(FindWebElement.class);

    public MyStepdefs(TestContext context) throws Exception {

        testContext = context;
        this.bookingHomePage = testContext.getPageObjectManager().getBookingHomePage();
        this.bookingLogInPage = testContext.getPageObjectManager().getBookingLogInPage();
        this.carrierLogInPage = testContext.getPageObjectManager().getCarrierLogInPage();
        this.carrierHomePage = testContext.getPageObjectManager().getCarrierHomePage();
        this.find = testContext.getPageObjectManager().getFindWebElement();
        executionData = testContext.getExecutionData();
        testDriverManager = testContext.getTestDriverManager();
    }


    @And("I validate the joining page elements")
    public void iValidateTheJoiningPageElements() {
    }

    @Given("I go to Login Page")
    public void iGoToLoginPage() throws Exception {
        bookingLogInPage.goToPage();
    }

    @And("^User logs in to my (.*) account")
    public void userLogsInToMyFarmBotAccount(String market2xPage) throws Exception {
        switch (market2xPage.toLowerCase()){
            case "booking":
                bookingLogInPage.login(ConfigurationManager.testEmail1,ConfigurationManager.testPass1);
                break;
            case "carrier":
                carrierLogInPage.login(ConfigurationManager.testEmail1,ConfigurationManager.testPass1);
                break;
            default:
        }
    }

    @Then("^User should see the (.*) home page loaded")
    public void isFarmBotHomePageLoaded(String market2xPage) throws Exception {
        switch (market2xPage.toLowerCase()){
            case "booking":
                bookingHomePage.isLoaded();
                break;
            case "carrier":
                carrierHomePage.isLoaded();
                break;
            default:
        }
    }


    @Given("^User goes to (.*) Login Page")
    public void userGoesToMarketXLoginPage(String market2xPage) throws Exception {
        switch (market2xPage.toLowerCase()){
            case "booking":
                bookingLogInPage.goToPage().isLoaded();
                break;
            case "carrier":
                carrierLogInPage.goToPage().isLoaded();
                break;
            default:
        }
    }

    @And("User navigates to a particular week on booking site")
    public void userNavigatesToAParticularWeekOnBookingSite() throws Exception {
        testDriverManager.getDriver().navigate().to("https://staging.m2x.app/bookings/accounts/offers?start=1624104000&mode=week");
    }


    @And("User navigates to a particular week on carrier site")
    public void userNavigatesToAParticularWeekOnCarrierSite() throws Exception {
        testDriverManager.getDriver().navigate().to("https://staging.m2x.app/carrier/dispatch/jobs?date=2021-06-21");
    }

    @Then("^User should see the booking Id (.*) on booking site")
    public void userShouldSeeTheBookingId(String bookingId) {
        assertTrue(bookingHomePage.isBookingWithBookingIdVisible(bookingId));
    }

    @Then("^User should see the booking Id (.*) on carrier site")
    public void userShouldSeeTheBookingIdCarrierSite(String bookingId) {
        assertTrue(carrierHomePage.isBookingWithBookingIdVisible(bookingId));
    }


    @When("User creates a new booking {string} to {string} - {float} {word}")
    public void userCreatesANewBookingWithBookingDetails(String supplier, String buyer, Float quantity, String products ) {

        // TODO: 27/07/21  
        throw new io.cucumber.java.PendingException();
        
    }

    @Then("User should see the booking details on booking site")
    public void userShouldSeeTheBookingBookingDetailsOnBookingSite() {

        // TODO: 28/07/21  
        throw new io.cucumber.java.PendingException();
    }


    @When("User creates large contract job for booking")
    public void userCreatesLargeContractJobWithJobDetails(String jobDetails) {

        // TODO: 28/07/21  
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should see large contract")
    public void userShouldSeeLargeContract() {
        throw new io.cucumber.java.PendingException();
    }
}
