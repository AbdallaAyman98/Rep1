import Pages.HomePage;
import Pages.SearchResultsPage;
import Pages.UserSignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CartTests extends TestBase
{
    UserSignInPage userSignInPageObject;
    Actions action;
    HomePage homePageObject;
    SearchResultsPage searchResultsPageObject;



        @Test
        public void addItemToCart() {
            homePageObject = new HomePage(driver);
            searchResultsPageObject = new SearchResultsPage(driver);
            userSignInPageObject = new UserSignInPage(driver);
            action = new Actions(driver);
            homePageObject.openSignInPage();
            userSignInPageObject.userSignIn("abdalla.agamy@hotmail.com", "SZV5LBy7U57Tf9i");
            homePageObject.searchField().sendKeys("Cora Parachute Pant");
            searchResultsPageObject.submitSearch().click();
            searchResultsPageObject.size28Button().click();
            searchResultsPageObject.blackColorButton().click();
            searchResultsPageObject.addToCartBtn().click();
            hold();
            Assert.assertEquals(searchResultsPageObject.successMsg().getText(), "You added Cora Parachute Pant to your shopping cart.", "Message didn't appear!");
            System.out.println("Item added Successfully!");
        }

}
