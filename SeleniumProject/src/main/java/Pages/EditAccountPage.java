package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class EditAccountPage extends BasePage {
    private WebDriver driver;
    private By currentPassword = By.id("current-password");
    private By newPassword = By.id("password");
    private By confirmNewPassword = By.id("password-confirmation");
    private By saveButton = By.xpath("//button[@title=\"Save\"]");
    private By currentPasswordError = By.id("current-password-error");
    private By newPasswordError= By.id("password-error");
    private By confirmNewPasswordError = By.id("password-confirmation-error");
    public EditAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public EditAccountPage changePassword(String current, String new_, String confirm){
        sendKeys(current, currentPassword);
        sendKeys(new_, newPassword);
        sendKeys(confirm, confirmNewPassword);
        return this;
    }
    public SignInPage saveSuccessful(){
        click(saveButton);
        return new SignInPage(driver);
    }

    public EditAccountPage saveFail(){
        click(saveButton);
        return this;
    }

    public String getCurrentPasswordErrorMsg(){
        return getText(currentPasswordError);
    }

    public String getNewPasswordErrorMsg(){
        return getText(newPasswordError);
    }
    public String getConfirmNewPasswordErrorMsg(){
        return getText(confirmNewPasswordError);
    }
}
