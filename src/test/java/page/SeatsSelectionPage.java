package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeatsSelectionPage extends Page {

    public SeatsSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void chooseRandomAllocation() {
        WebElement chooseRandomAllocationButton = driver.findElement(By.cssSelector(".footer-message-content__button.footer-message-content__button--link"));
        chooseRandomAllocationButton.click();
    }

}
