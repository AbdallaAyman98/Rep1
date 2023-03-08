package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {

    private WebDriver driver;
    private By color = By.xpath("//div[@option-label=\"Black\"]");
    private By quantity = By.id("qty");
    private By sizeAlertMsg = By.id("super_attribute[143]-error");
    private By colorAlertMsg = By.id("super_attribute[93]-error");
    private By quantityAlertMsg = By.id("qty-error");
    private By addToCartButton = By.id("product-addtocart-button");
    private By alertMsg = By.xpath("//div[@data-ui-id=\"message-notice\"]");
    private By successMsg = By.xpath("//div[@data-ui-id=\"message-success\"]");

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    public ItemPage chooseSize(String size){
        int index = 0;
        if(size.toUpperCase().equals("XS")){
            index = 1;
        }
        else if (size.toUpperCase().equals("S")){
            index = 2;
        }
        else if (size.toUpperCase().equals("M")){
            index = 3;
        }
        else if (size.toUpperCase().equals("L")){
            index = 4;
        }
        else if (size.toUpperCase().equals("XL")){
            index = 5;
        }
        else{
            System.out.println("Size doesn't exist");
        }
        By by = By.xpath("(//div[@class='swatch-option text'])["+index+"]");
        waitForElementToAppear(addToCartButton, driver).click(by,driver);
        return this;
    }
    public ItemPage clickColor(){
        waitForElementToAppear(addToCartButton, driver).click(color, driver);
        return this;
    }
    public ItemPage setQuantity(String x){
        clearField(quantity, driver).sendKeys(x,quantity,driver);
        return this;
    }
    public ItemPage clickAddToCart(){
        click(addToCartButton,driver);
        return this;
    }
    public String getColorAlertMsg(){
        return getText(colorAlertMsg,driver);
    }
    public String getSizeAlertMsg(){
        return getText(sizeAlertMsg,driver);
    }
    public String getQuantityAlertMsg(){
        return getText(quantityAlertMsg,driver);
    }
    public String getAlertMsg(){
        return getText(alertMsg, driver);
    }
    public String getSuccessMsg(){
        return getText(successMsg, driver);
    }

}
