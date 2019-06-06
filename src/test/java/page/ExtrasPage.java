package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtrasPage extends Page {

    public ExtrasPage(WebDriver driver) {
        super(driver);
    }

    public void checkOut() {

        waitUntilNotEmpty(By.cssSelector(".trips-basket.trips-cnt .core-btn-primary.core-btn-block.core-btn-medium"));

        waitUntilNotEmpty(By.cssSelector(".extras-panel__header"));

        forceWait();
        WebElement checkOutButton = driver.findElement(By.cssSelector(".trips-basket.trips-cnt .core-btn-primary.core-btn-block.core-btn-medium"));
        checkOutButton.click();
        waitUntilNotEmpty(By.cssSelector(".popup-msg__button.popup-msg__button--cancel"));
    }

}
