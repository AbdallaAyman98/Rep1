import org.testng.Assert;
import org.testng.annotations.Test;
public class EditAccountTests extends BaseTest {
    @Test
    public void changePassword(){
       String actual = homePage.clickSignIn()
               .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
               .submitSuccess().goToMyAccount().clickChangePassword()
               .changePassword("SZV5LBy7U57Tf9i", "SZV5LBy7U57Tf9i","SZV5LBy7U57Tf9i")
               .saveSuccessful().getSuccessMsg();
        Assert.assertEquals(actual,"You saved the account information.");
    }

    @Test
    public void blankNewPasswordField(){
        String actual = homePage.clickSignIn()
                .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
                .submitSuccess().goToMyAccount().clickChangePassword()
                .changePassword("SZV5LBy7U57Tf9i","","SZV5LBy7U57Tf9i")
                .saveFail().getNewPasswordErrorMsg();
        Assert.assertEquals(actual,"This is a required field.");
    }

    @Test
    public void blankCurrentPasswordField(){
        String actual = homePage.clickSignIn()
                .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
                .submitSuccess().goToMyAccount().clickChangePassword()
                .changePassword("","SZV5LBy7U57Tf9i","SZV5LBy7U57Tf9i")
                .saveFail().getCurrentPasswordErrorMsg();
        Assert.assertEquals(actual,"This is a required field.");
    }
    @Test
    public void blankConfirmNewPasswordField(){
        String actual = homePage.clickSignIn()
                .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
                .submitSuccess().goToMyAccount().clickChangePassword()
                .changePassword("SZV5LBy7U57Tf9i","SZV5LBy7U57Tf9i","")
                .saveFail().getConfirmNewPasswordErrorMsg();
        Assert.assertEquals(actual,"This is a required field.");
    }

    @Test
    public void invalidConfirmNewPasswordField(){
        String actual = homePage.clickSignIn()
                .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
                .submitSuccess().goToMyAccount().clickChangePassword()
                .changePassword("SZV5LBy7U57Tf9i","SZV5LBy7U57Tf9i","123")
                .saveFail().getConfirmNewPasswordErrorMsg();
        Assert.assertEquals(actual,"Please enter the same value again.");
    }

    @Test
    public void weakNewPassword(){
        String actual = homePage.clickSignIn()
                .sign_in("abdalla.agamy@hotmail.com","SZV5LBy7U57Tf9i")
                .submitSuccess().goToMyAccount().clickChangePassword()
                .changePassword("SZV5LBy7U57Tf9i","123","123")
                .saveFail().getNewPasswordErrorMsg();
        Assert.assertEquals(actual,"Minimum length of this field must be equal or greater than 8 symbols. " +
                "Leading and trailing spaces will be ignored.");

    }
}

