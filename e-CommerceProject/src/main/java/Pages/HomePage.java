package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

public String string;
    public HomePage(WebDriver driver) {
        super(driver);
    }



    public WebElement signUp(){
        By signUpPath = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
        WebElement signUpEle = driver.findElement(signUpPath);
        return signUpEle;
    }
    public WebElement signIn(){
        By signInLoc = By.xpath("//li[@class=\"authorization-link\"]/a");
        WebElement signInEle = driver.findElement(signInLoc);
        return signInEle;
    }

    public WebElement searchField(){
        By searchFieldLoc = By.xpath("//*[@id=\"placeholder\"]");
        WebElement searchFieldEle = driver.findElement(searchFieldLoc);
        return searchFieldEle;
    }

    public WebElement listBtn(){
        By listBtnLoc = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        WebElement listBtnEle = driver.findElement(listBtnLoc);
        return listBtnEle;
    }
    public WebElement myAccountBtn(){
        By myAccountBtnLoc = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
        WebElement myAccountBtn = driver.findElement(myAccountBtnLoc);
        return myAccountBtn;
    }
    public WebElement logoutBtn(){
        By logoutBtnLoc = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
        WebElement logoutBtn = driver.findElement(logoutBtnLoc);
        return logoutBtn;
    }

    public WebElement logoutMsg(){
        By logoutMsgLoc = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
        WebElement logoutMsgEle = driver.findElement(logoutMsgLoc);
        return logoutMsgEle;
    }


    public void openSignUpPage(){
        signUp().click();
    }

    public void openSignInPage(){
        signIn().click();
    }

    public void logout(){
        listBtn().click();
        logoutBtn().click();
    }

    public void goToMyAccount(){
        listBtn().click();
        myAccountBtn().click();
    }


}
