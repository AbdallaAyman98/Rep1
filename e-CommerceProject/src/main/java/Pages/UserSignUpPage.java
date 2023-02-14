package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSignUpPage extends PageBase {
    public UserSignUpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName(){
        By firstNameLoc = By.xpath("//input[@id=\"firstname\"]");
        WebElement firstNameEle = driver.findElement(firstNameLoc);
        return firstNameEle;
    }
    public WebElement lastName(){
        By lastNameLoc = By.xpath("//input[@id=\"lastname\"]");
        WebElement lastNameEle = driver.findElement(lastNameLoc);
        return lastNameEle;
    }

    public WebElement email(){
        By emailLoc = By.xpath("//*[@id=\"email_address\"]");
        WebElement emailEle = driver.findElement(emailLoc);
        return emailEle;
    }
    public WebElement password(){
        By passwordLoc = By.xpath("//*[@id=\"password\"]");
        WebElement passwordEle = driver.findElement(passwordLoc);
        return passwordEle;
    }
    public WebElement confirmPassword(){
        By confirmPasswordLoc = By.xpath("//*[@id=\"password-confirmation\"]");
        WebElement confirmPasswordEle = driver.findElement(confirmPasswordLoc);
        return confirmPasswordEle;
    }

    public WebElement submitButton(){
        By submitButtonLoc = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
        WebElement submitButtonEle = driver.findElement(submitButtonLoc);
        return submitButtonEle;
    }
    public WebElement signUpMsg(){
        By signUpMsgLoc = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
        WebElement signUpMsgEle = driver.findElement(signUpMsgLoc);
        return signUpMsgEle;
    }


    public WebElement signUpEmailAlert(){
        By signUpEmailAlertLoc = By.xpath("//*[@id=\"email_address-error\"]");
        WebElement signUpEmailAlertEle = driver.findElement(signUpEmailAlertLoc);
        return signUpEmailAlertEle;
    }
    public WebElement signUpPassAlert(){
        By signUpPassAlertLoc = By.xpath("//*[@id=\"password-error\"]");
        WebElement signUpPassAlertEle = driver.findElement(signUpPassAlertLoc);
        return signUpPassAlertEle;
    }

    public WebElement signUpcPassAlert(){
        By signUpcPassAlertLoc = By.xpath("//*[@id=\"password-confirmation-error\"]");
        WebElement signUpcPassAlertEle = driver.findElement(signUpcPassAlertLoc);
        return signUpcPassAlertEle;
    }



    public void userSignUp(String firstName, String lastName, String email, String password, String confirmPassword){
        firstName().sendKeys(firstName);
        lastName().sendKeys(lastName);
        email().sendKeys(email);
        password().sendKeys(password);
        confirmPassword().sendKeys(confirmPassword);
        submitButton().click();

    }







}
