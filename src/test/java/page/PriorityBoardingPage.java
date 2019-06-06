package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriorityBoardingPage extends Page {

    public PriorityBoardingPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        waitUntilNotEmpty(By.cssSelector(".footer-message-content"));
        waitUntilNotEmpty(By.cssSelector(":not(.plane-spinner)"));
        waitUntilNotEmpty(By.cssSelector(".pb-cb-card-wrapper"));
    }

    public void chooseFlyOutSmallBag() {
        waitUntilNotEmpty(By.xpath("/html/body/div[2]/main/div[1]/priority-boarding-view/div[2]/div/div[2]/div[2]/div/priority-cabin-bag-card[1]/div"));

        WebElement flyOutSmallBagRadioButton = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/priority-boarding-view/div[2]/div/div[2]/div[2]/div/priority-cabin-bag-card[1]/div"));
        flyOutSmallBagRadioButton.click();

    }

    public void chooseFlyBackSmallBag() {
        waitUntilNotEmpty(By.cssSelector(".pb-cb-standalone-card__warning-text"));
        waitUntilNotEmpty(By.cssSelector(".added-mark__text"));
        waitUntilNotEmpty(By.cssSelector(".baggage-info__text"));
        forceWait();

        WebElement flyBackSmallBagRadioButton = driver.findElements(By.cssSelector(".pb-cb-standalone-card")).get(3);
        flyBackSmallBagRadioButton.click();
    }

    public void continueBooking() {
        forceWait();
        WebElement continueButton2 = driver.findElement(By.cssSelector(".priority-boarding-view__footer .core-btn-primary"));
        continueButton2.click();
    }

}
