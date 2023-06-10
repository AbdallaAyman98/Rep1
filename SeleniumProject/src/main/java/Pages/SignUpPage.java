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
        super(driver);
        this.driver = driver;
    }
    public String getSignUpMsg(){
        return getText(signUpMsg);
    }
    public String getSignUpEmailAlert(){
        return getText(signUpEmailAlert);
    }
    public String getSignUpPassAlert(){
        return getText(signUpPassAlert);
    }
    public String getSignUpCPassAlert(){
        return getText(signUpCPassAlert);
    }
    public SignUpPage signUp(String firstName, String lastName, String email, String password, String confirmPassword){
        sendKeys(firstName, firstNameField);
        sendKeys(lastName, lastNameField);
        sendKeys(email, email_Field);
        sendKeys(password, password_Field);
        sendKeys(confirmPassword, confirmPasswordField);
        return this;
    }
    public AccountPage submitSuccessfully(){
        click(submitButton);
        return new AccountPage(driver);
    }
    public SignUpPage submitFail(){
        click(submitButton);
        return this;
    }
}
