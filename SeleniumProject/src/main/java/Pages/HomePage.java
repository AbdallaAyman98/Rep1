package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage extends BasePage {
private WebDriver driver;
private By signInLink = By.className("authorization-link");
private By signUpLink = By.linkText("Create an Account");
private By listButton = By.xpath("//button[@tabindex=\"-1\"]");
private By logoutButton = By.partialLinkText("Sign Out");
private By logoutMsg = By.className("page-title");
private By searchButton = By.xpath("//button[@title=\"Search\"]");
private By searchField = By.id("search");
private By myAccount = By.linkText("My Account");
private By menSection = By.id("ui-id-5");
private By topsSection = By.id("ui-id-17");
private By jacketsSection = By.id("ui-id-19");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public SignInPage clickSignIn(){
        click(signInLink, driver);
        return new SignInPage(driver);
    }
    public SignUpPage clickSignUp(){
        click(signUpLink, driver);
        return new SignUpPage(driver);
    }
    public HomePage logout(){
        click(listButton, driver);
        click(logoutButton,driver);
        return this;
    }
    public String logoutMsg(){
        return getText(logoutMsg, driver);
    }
    public SearchResultPage searchItem(String item){
        sendKeys(item, searchField, driver);
        click(searchButton, driver);
        return new SearchResultPage(driver);
    }
    public AccountPage goToMyAccount(){
        click(listButton, driver).click(myAccount,driver);

        return new AccountPage(driver);
    }
    public WebElement listButton(){
        return driver.findElement(listButton);
    }

    public SearchResultPage goToJacketsMenSection(){
        hoverOver(menSection, driver).hoverOver(topsSection, driver).click(jacketsSection, driver);
        return new SearchResultPage(driver);
    }










}
