import Pages.HomePage;
import Pages.UserSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UserSignInTests extends TestBase
{
    HomePage homePageObject;
    UserSignInPage userSignInPageObject;

    @Test(priority = 1)
    public void userSigninSuccessfully(){
        homePageObject = new HomePage(driver);
        userSignInPageObject = new UserSignInPage(driver);
        homePageObject.openSignInPage();
        userSignInPageObject.userSignIn("abdalla.agamy@hotmail.com", "SZV5LBy7U57Tf9i");
        //SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(getUrl(),
                "https://magento.softwaretestingboard.com/");
        Assert.assertTrue(homePageObject.listBtn().isDisplayed());

        //Logout
       /* homePageObject.listBtn();
        homePageObject.logout();
        Assert.assertEquals(homePageObject.logoutMsg().getText(), "You are signed out"); */
    }

    @Test(priority = 2)
    public void userSiginIncorrectAcc(){
        homePageObject = new HomePage(driver);
        userSignInPageObject = new UserSignInPage(driver);
        homePageObject.openSignInPage();
        userSignInPageObject.userSignIn("fake.emailasd@fakedoasdaxcvsghmain.com"
                , "faasdkascxvdsaefghpassword!");
        hold();
        Assert.assertEquals(userSignInPageObject.incorrectAccMsg().getText(),"The account sign-in was incorrect" +
                " or your account is disabled temporarily. Please wait and try again later.");


    }
    @Test(priority = 3)
    public void signinInvalidEmail(){
        homePageObject = new HomePage(driver);
        userSignInPageObject = new UserSignInPage(driver);
        homePageObject.openSignInPage();
        driver.manage().deleteAllCookies();
        userSignInPageObject.userSignIn("abdalla.agamy", "SamplePassword");
        Assert.assertEquals(userSignInPageObject.invalidEmailMsg().getText(),
                "Please enter a valid email address (Ex: johndoe@domain.com).");

    }


    @Test(priority = 4)
    public void signinEmptyFields(){
        homePageObject = new HomePage(driver);
        userSignInPageObject = new UserSignInPage(driver);
        homePageObject.openSignInPage();
        userSignInPageObject.userSignIn("", "");
        Assert.assertEquals(userSignInPageObject.emailAlert().getText(),
                "This is a required field.");
        Assert.assertEquals(userSignInPageObject.passAlert().getText(),
                "This is a required field.");


    }


    }




