import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class HomePage extends PageBase {
    private AndroidDriver driver;
    private By myAccount = By.xpath("//android.widget.TextView[@text='My Account']");
    private By skipIntro = By.xpath("//android.widget.TextView[@text='Skip Intro']");
    public HomePage(AndroidDriver driver){
        this.driver = driver;
    }
    public MyAccountPage goToMyAccount(){
        click(myAccount,driver);
        return new MyAccountPage(driver);
    }
    public HomePage skipIntro(){
        click(skipIntro,driver);
        return this;
    }
}
