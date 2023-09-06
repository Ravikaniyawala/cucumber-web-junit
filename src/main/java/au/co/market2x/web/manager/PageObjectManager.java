package au.co.market2x.web.manager;


import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.pages.*;
import au.co.market2x.web.webelement.FindWebElement;

public class PageObjectManager {

    private TestContext testContext;
    private BookingHomePage bookingHomePage;
    private FindWebElement findWebElement;
    private BookingLogInPage bookingLogInPage;
    private CarrierHomePage carrierHomePage;
    private CarrierLogInPage carrierLogInPage;



    public PageObjectManager(TestContext context) {
        testContext = context;
    }

    public FindWebElement getFindWebElement() throws Exception {

        return (findWebElement == null) ? findWebElement = new FindWebElement(testContext) : findWebElement;

    }

    public BookingHomePage getBookingHomePage() throws Exception {
        return (bookingHomePage == null) ? bookingHomePage = new BookingHomePage(testContext) : bookingHomePage;
    }

    public BookingLogInPage getBookingLogInPage() throws Exception {
        return (bookingLogInPage == null) ? bookingLogInPage = new BookingLogInPage(testContext) : bookingLogInPage;
    }

    public CarrierHomePage getCarrierHomePage() throws Exception {
        return (carrierHomePage == null) ? carrierHomePage = new CarrierHomePage(testContext) : carrierHomePage;
    }

    public CarrierLogInPage getCarrierLogInPage() throws Exception {
        return (carrierLogInPage == null) ? carrierLogInPage = new CarrierLogInPage(testContext) : carrierLogInPage;
    }
}
