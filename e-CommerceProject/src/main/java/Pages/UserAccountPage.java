package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAccountPage extends PageBase {

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement listBtn() {
        By listBtnLoc = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        WebElement listBtnEle = driver.findElement(listBtnLoc);
        return listBtnEle;
    }
}
