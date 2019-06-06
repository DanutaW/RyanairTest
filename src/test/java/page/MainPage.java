package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void closeCookiePopup() {
        WebElement cookiePopupClosebutton = driver.findElement(By.cssSelector(".cookie-popup__close"));
        cookiePopupClosebutton.click();
    }

    public void goToLoginPage() {
        WebElement logInButton = driver.findElement(By.id("myryanair-auth-login"));
        logInButton.click();
        waitUntilNotEmpty(By.cssSelector("[name='$ctrl.loginForm'] .ng-valid-email"));
    }

    public void chooseFirstAvailableDestination() {
        WebElement destinationAirportField = driver.findElement(By.cssSelector("[name=destinationAirportName]"));
        destinationAirportField.click();
        WebElement countryListElement = driver.findElements(By.cssSelector(".core-list-item:not(.unavailable):not(.ng-hide)")).get(0);
        countryListElement.click();
        WebElement airportListElement = driver.findElements(By.cssSelector(".pane.right .core-list-item:not(.unavailable):not(.ng-hide)")).get(0);
        airportListElement.click();
    }

    public void chooseFirstAvailableStartDate() {
        waitUntilNotEmpty(By.cssSelector(".calendar-view .days li:not(.unavailable)"));
        WebElement startDate = driver.findElements(By.cssSelector(".calendar-view .days li:not(.unavailable)")).get(0);
        startDate.click();
        waitUntilNotEmpty(By.cssSelector(".starting-month"));
    }

    public void chooseFirstAvailableEndDate() {
        WebElement endDate = driver.findElements(By.cssSelector(".calendar-view.highlight-on:not(.starting-month) .days li:not(.unavailable)")).get(0);
        endDate.click();
    }

    public void confirm() {
        WebElement letsGoButton = driver.findElement(By.cssSelector(".col-flight-search-right .core-btn-primary:not(.ng-hide)"));
        letsGoButton.click();
    }

}
