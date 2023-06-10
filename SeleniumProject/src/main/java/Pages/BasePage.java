package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {
    private WebDriverWait driverWait;
    private WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage waitForElementToDisappear(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return this;
    }
    protected BasePage waitForElementToBeClickable(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        return this;
    }

    protected BasePage waitForTexToBe(By by, String string){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(by, string));
        return this;

    }
    protected BasePage waitForElementToAppear(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }
    protected BasePage click(By by){
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
        return this;
    }
    protected BasePage sendKeys(String string, By by){
        waitForElementToAppear(by);
        driver.findElement(by).sendKeys(string);
        return this;
    }
    protected BasePage sendKey(By by){
        waitForElementToAppear(by);
        driver.findElement(by).sendKeys(Keys.ENTER);
        return this;
    }
    protected String getText(By by){
        waitForElementToAppear(by);
        return driver.findElement(by).getText();
    }

    protected BasePage hoverOver(By by){
        waitForElementToAppear(by);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
        return this;
    }

    protected BasePage clearField(By by){
        waitForElementToAppear(by);
        driver.findElement(by).clear();
        return this;
    }

}
