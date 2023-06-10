import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    private AndroidDriver driver;
    private By emailField = By.xpath("//android.widget.EditText[@resource-id='email']");
    private By passField = By.xpath("//android.widget.EditText[@resource-id='password']");
    private By loginButton = By.xpath("//android.widget.TextView[@text='Sign In']");
    private By errorEmailMsg = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
    private By errorBlankPassMsg = By.xpath("//android.widget.TextView[@text='Hold up, this field is required.']");
    private By errorInvalidPassMsg = By.xpath("//android.widget.TextView[@text='Hold up, this field is required.']");
    private By alertMsg = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
    private By errorMinimumPassMsg = By.xpath("//android.widget.TextView[@text='Hold up, this field requires at least 8 characters.']");
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }



    public String getErrorMinimumPassMsg(){
        return getText(errorMinimumPassMsg, driver);
    }

    public String getBlankPassErrorMsg(){
        return getText(errorBlankPassMsg, driver);
    }

    public String getInvalidPassMsg(){
        return getText(errorInvalidPassMsg,driver);
    }
    public String getEmailErrorMsg(){
        return getText(errorEmailMsg,driver);
    }

    public LoginPage setEmail(String email){
        sendKeys(email,emailField,driver);
        return this;
    }
    public LoginPage setPass(String pass){
        sendKeys(pass,passField,driver);
        return this;
    }

    public MyAccountPage clickLogin(){
        click(loginButton,driver);
        return new MyAccountPage(driver);
    }
}
