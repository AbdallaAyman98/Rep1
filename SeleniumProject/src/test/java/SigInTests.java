import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class SigInTests extends BaseTest {
 /*   @Test
    public void successSignIn(){
        assertTrue(homePage.clickSignIn().sign_in("abdalla.agamy@hotmail.com",
                "SZV5LBy7U57Tf9i").submitSuccess().listButton().isDisplayed());
    }
    @Test
    public void signOut(){
        assertEquals(homePage.clickSignIn().sign_in("abdalla.agamy@hotmail.com",
                "SZV5LBy7U57Tf9i").submitSuccess().logout().logoutMsg(),"You are signed out");
    }*/
    @Test
    public void userSignInIncorrectAcc(){
        assertEquals(homePage.clickSignIn().sign_in("fakeEmail256@domain.com"
                , "password!!!!").submitFail().alertMsg(), "The account sign-in was incorrect" +
                " or your account is disabled temporarily. Please wait and try again later.");
    }
    @Test
    public void signInInvalidEmail(){
        assertEquals(homePage.clickSignIn().sign_in("abdalla.agamy",
                        "SamplePassword").submitFail().emailAlertMsg(),
                "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    @Test
    public void signInEmptyEmailField(){
        assertEquals(homePage.clickSignIn().sign_in("", "Password").submitFail().emailAlertMsg(),
                "This is a required field.");
    }
    @Test
    public void signInEmptyPassField(){
         assertEquals(homePage.clickSignIn().sign_in("example@domain.com", "").submitFail().passAlertMsg(),
                "This is a required field.");
    }
}
