package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSignInPage extends PageBase {
    public UserSignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement email(){
        By emailLoc = By.xpath("//*[@id=\"email\"]");
        WebElement emailEle = driver.findElement(emailLoc);
        return emailEle;
    }
    public WebElement password(){
        By passwordLoc = By.xpath("//*[@id=\"pass\"]");
        WebElement passwordEle = driver.findElement(passwordLoc);
        return passwordEle;
    }
    public WebElement signInButton(){
        By signInButtonLoc = By.xpath("//button[@id=\"send2\"]");
        WebElement signInButtonEle = driver.findElement(signInButtonLoc);
        return signInButtonEle;
    }
    public WebElement invalidEmailMsg(){
        By invalidEmailMsgLoc = By.xpath("//*[@id=\"email-error\"]");
        WebElement invalidEmailMsgEle = driver.findElement(invalidEmailMsgLoc);
        return invalidEmailMsgEle;
    }

    public WebElement incorrectAccMsg() {
        By incorrectAccMsgLoc = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div");
        WebElement incorrectAccMsgEle = driver.findElement(incorrectAccMsgLoc);
        return incorrectAccMsgEle;
    }

    public WebElement emailAlert(){
        By emailAlertLoc = By.xpath("//*[@id=\"email-error\"]");
        WebElement emailAlertEle = driver.findElement(emailAlertLoc);
        return emailAlertEle;
    }

    public WebElement passAlert(){
        By passAlertLoc = By.xpath("//*[@id=\"pass-error\"]");
        WebElement passAlertEle = driver.findElement(passAlertLoc);
        return passAlertEle;
    }

    public void userSignIn(String email, String password){
        email().sendKeys(email);
        password().sendKeys(password);
        signInButton().click();
    }
    public void clearAllFields(){
        email().clear();
        password().clear();
    }




}
