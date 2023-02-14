package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends PageBase{
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement addToCartBtn(){
     By addToCartBtnLoc = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div/div[1]/form/button");
     WebElement addToCartEle = driver.findElement(addToCartBtnLoc);
     return addToCartEle;
    }

    public WebElement size28Button(){
        By sizeButtonLoc = By.xpath("//*[@id=\"option-label-size-143-item-171\"]");
        WebElement sizeButtonEle = driver.findElement(sizeButtonLoc);
        return sizeButtonEle;
    }

    public WebElement blackColorButton(){
        By sizeButtonLoc = By.xpath("//*[@id=\"option-label-color-93-item-49\"]");
        WebElement sizeButtonEle = driver.findElement(sizeButtonLoc);
        return sizeButtonEle;
    }

    public WebElement cart(){
        By cartLoc = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
        WebElement cartEle = driver.findElement(cartLoc);
        return cartEle;
    }

    public WebElement successMsg(){
        By successMsgLoc = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
        WebElement successMsgEle = driver.findElement(successMsgLoc);
        return successMsgEle;
    }

    public WebElement submitSearch(){
        By submitSearchLoc = By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
        WebElement submiteSearchEle = driver.findElement(submitSearchLoc);
        return submiteSearchEle;
    }
    public WebElement productImg(){
        By productImgLoc = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div");
        WebElement productImgEle = driver.findElement(productImgLoc);
        return productImgEle;
    }

    public void goToCart(){
        cart().click();

    }




}
