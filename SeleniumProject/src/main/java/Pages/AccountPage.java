package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AccountPage extends BasePage {
    private WebDriver driver;
    private By changePassword = By.xpath("//a[@class=\"action change-password\"]");
    private By signUpSuccessMsg = By.xpath("//div[@data-ui-id=\"message-success\"]");
    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public EditAccountPage clickChangePassword(){
        click(changePassword);
        return new EditAccountPage(driver);
    }

    public String getSignUpMsg(){
        return getText(signUpSuccessMsg);
    }
}
