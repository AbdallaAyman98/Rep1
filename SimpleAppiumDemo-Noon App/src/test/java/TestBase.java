import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.swing.text.html.Option;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.*;


public class TestBase {

    private AndroidDriver driver;
    protected HomePage homePage;
    @BeforeMethod
    public void setDriver() throws MalformedURLException{
        DesiredCapabilities dc = new DesiredCapabilities();
    /*    File appDir = new File("src");
        File app = new File(appDir,"noon.apk");
        dc.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());*/
        dc.setCapability("appPackage","com.noon.buyerapp");
        dc.setCapability("appActivity","com.noon.buyerapp.MainActivity");
        dc.setCapability("noReset",true);
        dc.setCapability("fullReset",false);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel XL API 33");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver =new AndroidDriver (url,dc);
      /*  skipNotification().chooseCountry().skipLocationPerm().skipLocation();*/
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

  /*  public TestBase skipNotification(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"))));
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
        return this;
    }
    public TestBase chooseCountry() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//android.view.ViewGroup)[6]"))));
        driver.findElement(By.xpath("(//android.view.ViewGroup)[6]")).click();
        return this;

    }
    public TestBase skipLocationPerm(){

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"))));
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
        return this;
    }

    public TestBase skipLocation() throws InterruptedException {

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.widget.TextView[@text=\"skip\"]"))));
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"skip\"]")).click();
        return this;
    }*/

    }


