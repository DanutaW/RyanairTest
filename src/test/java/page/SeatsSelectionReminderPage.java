package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeatsSelectionReminderPage extends Page {

    public SeatsSelectionReminderPage(WebDriver driver) {
        super(driver);
    }

    public void chooseRandomAllocation() {
        WebElement chooseRandomAllocationButton2 = driver.findElement(By.cssSelector(".popup-msg__button.popup-msg__button--cancel"));
        chooseRandomAllocationButton2.click();
    }

}
