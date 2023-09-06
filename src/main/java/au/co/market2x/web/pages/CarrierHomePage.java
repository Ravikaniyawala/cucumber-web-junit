package au.co.market2x.web.pages;

import au.co.market2x.web.cucumber.TestContext;
import au.co.market2x.web.helper.ThreadSleep;
import org.openqa.selenium.By;

public class CarrierHomePage extends Page {

    By createJob = new By.ByCssSelector("button#createjob");
    By loadingSpinner = new By.ByCssSelector(".LoadingSpinner");


    public CarrierHomePage(TestContext context) throws Exception {
        super(context);

    }

    public boolean isBookingWithBookingIdVisible(String bookingId){
        String bookingIdLoc = "//div[contains(text(),'"+bookingId+"')]";
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
        find.findWebElement(createJob);
    }
}
