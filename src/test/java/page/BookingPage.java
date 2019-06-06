package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage extends Page {

    private static final By FIRST_PRICE_LOCATOR = By.cssSelector("flight-list:nth-of-type(1) flights-table-price:not(.show-mobile)");
    private static final By STANDARD_FARE_SELECT = By.cssSelector(".fare-select.standard");
    private static final By SECOND_PRICE_LOCATOR = By.cssSelector("flight-list:nth-of-type(2) flights-table-price:not(.show-mobile)");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void chooseFlyOutStandardfare() {
        waitUntilNotEmpty(FIRST_PRICE_LOCATOR);
        WebElement flyOutPriceButton = driver.findElement(FIRST_PRICE_LOCATOR);
        flyOutPriceButton.click();

        waitUntilDisplayed(STANDARD_FARE_SELECT);
        driver.findElement(STANDARD_FARE_SELECT).click();
    }

    public void chooseFlyBackStandardFare() {
        waitUntilNotEmpty(SECOND_PRICE_LOCATOR);
        WebElement flyBackPriceButton = driver.findElement(SECOND_PRICE_LOCATOR);
        flyBackPriceButton.click();

        waitUntilDisplayed(STANDARD_FARE_SELECT);
        driver.findElement(STANDARD_FARE_SELECT).click();
    }

    public void continueBooking() {
        waitUntilNotEmpty(By.cssSelector(".fare-upgrade__benefit-list"));
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        waitUntilNotEmpty(By.cssSelector(".footer-message-content__button.footer-message-content__button--link"));
    }
}
