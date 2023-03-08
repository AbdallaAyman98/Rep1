package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignUpPage extends BasePage {
    private WebDriver driver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By email_Field = By.id("email_address");
    private By password_Field = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By submitButton = By.xpath("(//*[@type=\"submit\"])[2]");
    private By signUpEmailAlert = By.id("email_address-error");
    private By signUpPassAlert = By.id("password-error");
    private By signUpCPassAlert = By.id("password-confirmation-error");
    private By signUpMsg = By.xpath("//div[@data-ui-id=\"message-error\"]");
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSignUpMsg(){
        return getText(signUpMsg, driver);
    }
    public String getSignUpEmailAlert(){
        return getText(signUpEmailAlert, driver);
    }
    public String getSignUpPassAlert(){
        return getText(signUpPassAlert, driver);
    }
    public String getSignUpCPassAlert(){
        return getText(signUpCPassAlert, driver);
    }
    public SignUpPage signUp(String firstName, String lastName, String email, String password, String confirmPassword){
        sendKeys(firstName, firstNameField, driver);
        sendKeys(lastName, lastNameField, driver);
        sendKeys(email, email_Field, driver);
        sendKeys(password, password_Field, driver);
        sendKeys(confirmPassword, confirmPasswordField, driver);
        return this;
    }
    public AccountPage submitSuccessfully(){
        click(submitButton, driver);
        return new AccountPage(driver);
    }
    public SignUpPage submitFail(){
        click(submitButton, driver);
        return this;
    }
}
