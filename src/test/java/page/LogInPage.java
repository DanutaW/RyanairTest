package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends Page {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String email, String password) {
        WebElement loginField = driver.findElement(By.cssSelector("[name='$ctrl.loginForm'] .ng-valid-email"));
        loginField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("[name='$ctrl.loginForm'] [name=password]"));
        passwordField.sendKeys(password);
        WebElement loginButton2 = driver.findElement(By.cssSelector("[translate='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']"));
        loginButton2.click();
        waitUntilEmpty(By.cssSelector("[name='$ctrl.loginForm'] .ng-valid-email"));
    }

}
