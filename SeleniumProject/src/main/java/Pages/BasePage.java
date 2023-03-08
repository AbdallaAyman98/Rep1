package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {
    private WebDriverWait driverWait;


    protected BasePage waitForElementToDisappear(By by, WebDriver driver){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return this;
    }
    protected BasePage waitForElementToBeClickable(By by,WebDriver driver){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        return this;
    }

    protected BasePage waitForTexToBe(By by, WebDriver driver, String string){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(by, string));
        return this;

    }
    protected BasePage waitForElementToAppear(By by, WebDriver driver){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }
    protected BasePage click(By by, WebDriver driver){
        waitForElementToBeClickable(by,driver);
        driver.findElement(by).click();
        return this;
    }
    protected BasePage sendKeys(String string, By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        driver.findElement(by).sendKeys(string);
        return this;
    }
    protected String getText(By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        return driver.findElement(by).getText();
    }

    protected BasePage hoverOver(By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
        return this;
    }

    protected BasePage clearField(By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        driver.findElement(by).clear();
        return this;
    }
}
