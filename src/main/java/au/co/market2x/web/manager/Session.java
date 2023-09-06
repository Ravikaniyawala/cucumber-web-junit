package au.co.market2x.web.manager;


public class Session {

    public static boolean isHeadless = BrowserIsHeadless();
    public static boolean isChrome = BrowserIsChrome();

    public static String BookingPageURL = getBookingPageURL();
    public static String CarrierPageURL = getCarrierPageURL();

    private static boolean BrowserIsHeadless() {
        return ConfigurationManager.headless.toLowerCase().trim().equals("true");
    }

    private static boolean BrowserIsChrome() {
        return ConfigurationManager.browser.toLowerCase().trim().equals("chrome");
    }

    private static String getBookingPageURL() {
        return ConfigurationManager.market2xbookingsurl;
    }

    private static String getCarrierPageURL() {
        return ConfigurationManager.market2xcarrierssurl;
    }
}
