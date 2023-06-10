import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class SignUpTests extends BaseTest {
    @Test
    public void userSignUpSuccessfully(){
        assertEquals(homePage.clickSignUp().signUp("Alex","Smith","example.68@gmail.com",
                "gNxTt&2$sMRqT","gNxTt&2$sMRqT").submitSuccessfully().getSignUpMsg(),
                "Thank you for registering with Fake Online Clothing Store.");
    }
   @Test
    public void userAlreadyExists(){
       assertEquals(homePage.clickSignUp().signUp("Alex","Smith","Alex.smith@gmail.com",
               "gNxTt&2$sMRqT","gNxTt&2$sMRqT").submitFail().getSignUpMsg(),
               "There is already an account with this email address." +
               " If you are sure that it is your email address, click here to get your password and access your account.");
    }
    @Test
    public void userRegInvalidFname(){
        assertEquals(homePage.clickSignUp().signUp("!#  $!@","lastName","dummy.email@gmail.com",
                "password123!","password123!").submitFail().getSignUpMsg(),
                "First Name is not valid!");
    }
    @Test
    public void userRegInvalidLname(){
        assertEquals(homePage.clickSignUp().signUp("firstName","!#  $!@","dummy.email@gmail.com",
                "password123!","password123!").submitFail().getSignUpMsg(),
                "Last Name is not valid!");
    }
    @Test
    public void userRegInvalidPass(){
        assertEquals(homePage.clickSignUp().signUp("firstName","lastName","dummy.email@gmail.com",
                "pa","password123!").submitFail().getSignUpPassAlert(),
                "Minimum length of this field must be equal or greater than 8 symbols." +
                " Leading and trailing spaces will be ignored.");
    }
    @Test
    public void userRegWeakPass(){
        assertEquals(homePage.clickSignUp().signUp("firstName","lastName","dummy.email@gmail.com",
                "password","password").submitFail().getSignUpPassAlert(),
                "Minimum of different classes of characters in password is 3." +
                " Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
    }
    @Test
    public void userRegConfirmPass(){
        assertEquals(homePage.clickSignUp().signUp("firstName","lastName","dummy.email@gmail.com",
                "password123!","password123").submitFail().getSignUpCPassAlert(),
                "Please enter the same value again.");
    }
}
