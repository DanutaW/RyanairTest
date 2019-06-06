package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends Page {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void setPassengerDetails(String title, String name, String surname) {
        waitUntilNotEmpty(By.cssSelector(".form-field.payment-passenger-title select"));
        WebElement titleDropDown = driver.findElement(By.cssSelector(".form-field.payment-passenger-title select"));
        Select select = new Select(titleDropDown);
        select.selectByVisibleText(title);

        WebElement nameField = driver.findElement(By.cssSelector(".form-field.payment-passenger-first-name input[data-hj-suppress]"));
        nameField.sendKeys(name);

        WebElement surnameField = driver.findElement(By.cssSelector(".form-field.payment-passenger-last-name input[data-hj-suppress]"));
        surnameField.sendKeys(surname);
    }

    public void setContactDetails(String country, String phoneNumber) {

        WebElement selectCountryDropDown = driver.findElement(By.cssSelector(".phone-number-country select"));
        Select select1 = new Select(selectCountryDropDown);
        select1.selectByVisibleText(country);

        WebElement phoneNumberField = driver.findElement(By.cssSelector(".phone-number input[data-hj-suppress]"));
        phoneNumberField.sendKeys(phoneNumber);

    }

    public void setPaymentMethod(String cardNumber, String month, String year, String securityCode, String cardholdersName) {
        WebElement cardNumberField = driver.findElement(By.cssSelector(".form-field.half-width-form.card-seats-flow input[data-hj-suppress]"));
        cardNumberField.sendKeys(cardNumber);

        waitUntilNotEmpty(By.cssSelector(":not(.plane-spinner)"));

        WebElement selectMonthDropDown = driver.findElement(By.cssSelector(".date-expiry.date-expiry-left select"));
        Select select2 = new Select(selectMonthDropDown);
        select2.selectByVisibleText(month);

        WebElement selectYearDropDown = driver.findElement(By.cssSelector(".expiry-year-select.ng-pristine.ng-touched.ng-empty.placeholder-selected"));
        Select select3 = new Select(selectYearDropDown);
        select3.selectByVisibleText(year);

        WebElement securityCodeField = driver.findElement(By.cssSelector(".card-security-code input[data-hj-suppress]"));
        securityCodeField.sendKeys(securityCode);

        WebElement selectCardholdersNameDropDown = driver.findElement(By.cssSelector(".form-field.half-width-form.payment-input.cardholders-name input[data-hj-suppress]"));
        selectCardholdersNameDropDown.sendKeys(cardholdersName);
    }

    public void setBillingAddress(String addressLine1, String city, String postcode, String country) {
        WebElement addressField = driver.findElement(By.cssSelector(".form-field.address-line.address-line-1 input[data-hj-suppress]"));
        addressField.sendKeys(addressLine1);

        WebElement cityField = driver.findElement(By.cssSelector(".form-field.city input[data-hj-suppress]"));
        cityField.sendKeys(city);

        WebElement postcodeField = driver.findElement(By.cssSelector(".form-field.postcode input[data-hj-suppress]"));
        postcodeField.sendKeys(postcode);

        WebElement selectCountry2DropDown = driver.findElement(By.cssSelector(".form-field.country select"));
        Select select4 = new Select(selectCountry2DropDown);
        select4.selectByVisibleText(country);
    }

    public void acceptTerms() {
        WebElement confirmTermsCheckBox = driver.findElement(By.cssSelector(".terms .core-checkbox-label--icon .tick-icon"));
        confirmTermsCheckBox.click();
    }

    public void confirmPayment() {
        WebElement payNowButton = driver.findElement(By.cssSelector(".core-btn-primary.core-btn-medium"));
        payNowButton.click();
    }

    public String getErrorMessage() {
        waitUntilNotEmpty(By.cssSelector(".error.prompt-text .info-text"));
        WebElement error = driver.findElement(By.cssSelector(".error.prompt-text .info-text"));
        return error.getText();
    }

}
