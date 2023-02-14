
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;


    @BeforeMethod
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Abdal\\IdeaProjects\\e-CommerceProject\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

    public void goBack(){
        driver.navigate().back();
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
    public void hold(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }




}

