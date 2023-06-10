import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {
    private AndroidDriver driver;
    private By loginLink = By.xpath("//android.widget.TextView[@text='Sign In']");
    private By signOutLink = By.xpath("//android.widget.TextView[@text='Sign Out']");
    public MyAccountPage(AndroidDriver driver){
        this.driver = driver;
    }
    public String getSigOutText(){
        return getText(signOutLink, driver);
    }


    public LoginPage goToLoginPage(){
        click(loginLink,driver);
        return new LoginPage(driver);
    }

    }

