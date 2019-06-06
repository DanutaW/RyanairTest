package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    private static final long TIME_OUT_IN_SECONDS = 30;
    private static final long FORCE_TIME_OUT_IN_SECONDS = 5;

    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitUntilEmpty(By by) {
        waitUntil(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElements(by).isEmpty();
            }
        });
    }

    protected void waitUntilNotEmpty(By by) {
        waitUntil(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return !d.findElements(by).isEmpty();
            }
        });
    }

    protected void waitUntilDisplayed(By by) {
        waitUntil(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(by).isDisplayed();
            }
        });
    }

    protected void waitUntil(ExpectedCondition<Boolean> condition) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(condition);
    }

    protected void forceWait() {
        try {
            Thread.sleep(FORCE_TIME_OUT_IN_SECONDS * 1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
