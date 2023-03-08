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
        this.driver = driver;
    }
    public EditAccountPage changePassword(String current, String new_, String confirm){
        sendKeys(current, currentPassword,driver);
        sendKeys(new_, newPassword,driver);
        sendKeys(confirm, confirmNewPassword,driver);
        return this;
    }
    public SignInPage saveSuccessful(){
        click(saveButton,driver);
        return new SignInPage(driver);
    }

    public EditAccountPage saveFail(){
        click(saveButton,driver);
        return this;
    }

    public String getCurrentPasswordErrorMsg(){
        return getText(currentPasswordError, driver);
    }

    public String getNewPasswordErrorMsg(){
        return getText(newPasswordError, driver);
    }
    public String getConfirmNewPasswordErrorMsg(){
        return getText(confirmNewPasswordError, driver);
    }
}
