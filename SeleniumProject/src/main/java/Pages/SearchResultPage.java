package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SearchResultPage extends BasePage {
    private WebDriver driver;
    private By alertMessage = By.xpath("//div[@role=\"alert\"]");
    private By itemSize = By.id("option-label-size-143-item-175");
    private By itemColor = By.id("option-label-color-93-item-49");
    private By addToCartButton = By.xpath("(//button[@class=\"action tocart primary\"])[1]");
    private By modelImage = By.xpath("(//img[@class=\"product-image-photo\"])[1]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public SearchResultPage addItem(){
        click(itemSize).click(itemColor).hoverOver(modelImage).click(addToCartButton);
        return this;
    }
    public ItemPage addItemOnly(){
        hoverOver(modelImage).click(addToCartButton);
        return new ItemPage(driver);
    }
    public String getAlertMessage(){
        return getText(alertMessage);
    }
}

