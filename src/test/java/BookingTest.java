
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BookingPage;
import page.ExtrasPage;
import page.LogInPage;
import page.MainPage;
import page.PaymentPage;
import page.PriorityBoardingPage;
import page.SeatsSelectionPage;
import page.SeatsSelectionReminderPage;

public class BookingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.ryanair.com/ie/en/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePopup();
        mainPage.goToLoginPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn("y386799@nwytg.net", "Office4958@");

        mainPage.chooseFirstAvailableDestination();
        mainPage.chooseFirstAvailableStartDate();
        mainPage.chooseFirstAvailableEndDate();
        mainPage.confirm();

        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.chooseFlyOutStandardfare();
        bookingPage.chooseFlyBackStandardFare();
        bookingPage.continueBooking();

        SeatsSelectionPage seatsSelectionPage = new SeatsSelectionPage(driver);
        seatsSelectionPage.chooseRandomAllocation();

        PriorityBoardingPage priorityBoardingPage = new PriorityBoardingPage(driver);
        priorityBoardingPage.load();
        priorityBoardingPage.chooseFlyOutSmallBag();
        priorityBoardingPage.chooseFlyBackSmallBag();
        priorityBoardingPage.continueBooking();

        ExtrasPage extrasPage = new ExtrasPage(driver);
        extrasPage.checkOut();

        SeatsSelectionReminderPage seatsSelectionReminderPage = new SeatsSelectionReminderPage(driver);
        seatsSelectionReminderPage.chooseRandomAllocation();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setPassengerDetails("Mrs", "Test", "Test");
        paymentPage.setContactDetails("Poland", "111111111");
        paymentPage.setPaymentMethod("5555555555555557", "10", "2019", "265", "Test Test");
        paymentPage.setBillingAddress("Street 1/1", "City", "11-111", "Poland");
        paymentPage.acceptTerms();
        paymentPage.confirmPayment();

        assertEquals("As your payment was not authorised we could not complete your reservation. "
                + "Please ensure that the information was correct or use a new payment to try again",
                paymentPage.getErrorMessage());
    }

}
