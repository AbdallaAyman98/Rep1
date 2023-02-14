import Pages.HomePage;
import Pages.UserAccountPage;
import Pages.UserSignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class UserSignUpTests extends TestBase{

    HomePage homePageObject;
    UserSignUpPage userSignUpPageObject;
    UserAccountPage userAccountPageObject;

    @Test
    public void userSignUpSuccessfully(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("Alaex","Smitsh","alex.ssmhit@gmail.com",
               "gNxTt&2$sMRqT","gNxTt&2$sMRqT");
        //SoftAssert softAssert= new SoftAssert();
        assertEquals(userAccountPageObject.listBtn().isDisplayed(),true);
        assertEquals(getUrl(),"https://magento.softwaretestingboard.com/customer/account/");
        hold();
        assertEquals(userSignUpPageObject.signUpMsg().getText(),
                "Thank you for registering with Fake Online Clothing Store.");
    }
    @Test
    public void userAlreadyExists(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("Alex","Smith","Alex.smith@gmail.com",
                "gNxTt&2$sMRqT","gNxTt&2$sMRqT");
        hold();
        assertEquals(userSignUpPageObject.signUpMsg().getText(),
                "There is already an account with this email address." +
                        " If you are sure that it is your email address, click here to get your password and access your account.");
    }

    @Test
    public void userRegInvalidFname(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("!#  $!@","lastName","dummy.email@gmail.com",
                "password123!","password123!");
        hold();
        assertEquals(userSignUpPageObject.signUpMsg().getText(), "First Name is not valid!");
    }

    @Test
    public void userRegInvalidLname(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("firstName","!#  $!@","dummy.email@gmail.com",
                "password123!","password123!");
        hold();
        assertEquals(userSignUpPageObject.signUpMsg().getText(), "Last Name is not valid!");
        assertEquals(getUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
    }
    @Test
    public void userRegInvalidPass(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("firstName","lastName","dummy.email@gmail.com",
                "pa","password123!");
      hold();
        assertEquals(userSignUpPageObject.signUpPassAlert().getText(),
                "Minimum length of this field must be equal or greater than 8 symbols." +
                        " Leading and trailing spaces will be ignored.");
        assertEquals(getUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
    }
    @Test
    public void userRegWeakPass(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("firstName","lastName","dummy.email@gmail.com",
                "password","password");
        hold();
        assertEquals(userSignUpPageObject.signUpPassAlert().getText(),
                "Minimum of different classes of characters in password is 3." +
                        " Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
        assertEquals(getUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
    }
    @Test
    public void userRegConfirmPass(){
        homePageObject = new HomePage(driver);
        userSignUpPageObject = new UserSignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);
        homePageObject.openSignUpPage();
        userSignUpPageObject.userSignUp("firstName","lastName","dummy.email@gmail.com",
                "password123!","password123");
       hold();
        assertEquals(userSignUpPageObject.signUpcPassAlert().getText(), "Please enter the same value again.");
        assertEquals(getUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
    }







}
