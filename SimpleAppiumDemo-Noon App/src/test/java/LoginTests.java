import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginInvalidEmail (){
        Assert.assertEquals(homePage.skipIntro().goToMyAccount().goToLoginPage().setEmail("fgdfgdfg").
                setPass("dfgdfgdfg").getEmailErrorMsg(), "Oh no! Please enter a valid email.");
    }

    @Test
    public void loginInvalidPasswprd(){
        Assert.assertEquals(homePage.skipIntro().goToMyAccount().goToLoginPage().setEmail("example@domain.com").
                setPass("123").getErrorMinimumPassMsg(),"Hold up, this field requires at least 8 characters.");
    }

    @Test
    public void loginBlankPassword(){
        Assert.assertEquals(homePage.skipIntro().goToMyAccount().goToLoginPage().setEmail("example@hotmail.com").
                setPass("").getBlankPassErrorMsg(),"Hold up, this field is required.");
    }
    @Test
    public void loginBlankEmail (){
        Assert.assertEquals(homePage.skipIntro().goToMyAccount().goToLoginPage().setEmail("").
                setPass("password").getEmailErrorMsg(), "Hold up, this field is required.");
    }

}

