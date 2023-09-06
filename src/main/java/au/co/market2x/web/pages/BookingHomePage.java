package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.helper.ThreadSleep;
import org.openqa.selenium.By;

public class BookingHomePage extends Page {

    By createBooking = new By.ByCssSelector("button#create-booking");
    By loadingSpinner = new By.ByCssSelector(".LoadingSpinner");
    By accountName = new By.ByCssSelector("span.accountName");




    public BookingHomePage(TestContext context) throws Exception {
        super(context);
    }

    public boolean isBookingWithBookingIdVisible(String bookingId){
        String bookingIdLoc = "//span[contains(text(),'"+bookingId+"')]";
        try {
            ThreadSleep.For(2);
            return find.findWebElement(new By.ByXPath(bookingIdLoc)).isDisplayed();
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public void isLoaded() throws Exception {
        find.waitForInVisibilityOfElement(loadingSpinner);
        find.findWebElement(accountName);
    }
}
