package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignInPage extends BasePage {
    private WebDriver driver;
    private By emailField = By.xpath("//input[@title=\"Email\"]");
    private By passwordField = By.id("pass");
    private By sigInBtn = By.id("send2");
    private By alertMsg = By.xpath("//div[@data-ui-id=\"message-error\"]");
    private By sucessMsg = By.xpath("//div[@data-ui-id=\"message-success\"]");
    private By emailAlertMsg = By.id("email-error");
    private By passAlertMsg = By.id("pass-error");
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    public SignInPage sign_in(String email, String password){
        sendKeys(email,emailField,driver).sendKeys(password,passwordField,driver);
        return this;
    }
    public HomePage submitSuccess(){
        click(sigInBtn, driver);
        return new HomePage(driver);
    }
    public SignInPage submitFail(){
        click(sigInBtn, driver);
        return this;
    }
    public String alertMsg(){
        return getText(alertMsg, driver);
    }
    public String getSuccessMsg(){
        return getText(sucessMsg, driver);
    }
    public String emailAlertMsg(){
        return getText(emailAlertMsg, driver);
    }
    public String passAlertMsg() {
        return getText(passAlertMsg, driver);
    }
}
