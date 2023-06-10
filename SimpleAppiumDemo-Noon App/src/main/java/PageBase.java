import com.google.common.collect.ImmutableMap;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    public void waitFor(By by,AndroidDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void click(By by,AndroidDriver driver){
        waitFor(by, driver);
        driver.findElement(by).click();
    }
    public void sendKeys(String string,By by,AndroidDriver driver){
        waitFor(by, driver);
        driver.findElement(by).sendKeys(string);
        driver.findElement(by).click();
        driver.executeScript("mobile: performEditorAction",ImmutableMap.of("action","Go"));
    }
    public String getText(By by, AndroidDriver driver){
        waitFor(by, driver);
        return driver.findElement(by).getText();
    }

    }

