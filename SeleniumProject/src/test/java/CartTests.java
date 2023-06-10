import org.testng.Assert;
import org.testng.annotations.Test;
public class CartTests extends BaseTest {
    @Test
    public void addItemSuccessfully(){
        Assert.assertEquals(homePage.searchItem("pants").addItem().getAlertMessage(),
                "You added Caesar Warm-Up Pant to your shopping cart.");
    }
    @Test
    public void addItemOnly(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().getAlertMsg(),
                "You need to choose options for your item.");
    }

    @Test
    public void addItemBlankSize(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().clickColor().setQuantity("1")
                        .clickAddToCart().getSizeAlertMsg()
                ,"This is a required field.");
    }

    @Test
    public void addItemBlankColor(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().chooseSize("L").setQuantity("1")
                        .clickAddToCart().getColorAlertMsg()
                ,"This is a required field.");
    }

    @Test
    public void addItemBlankQuantity(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().chooseSize("L").clickColor().setQuantity("")
                        .clickAddToCart().getQuantityAlertMsg()
                ,"Please enter a valid number in this field.");
    }
    @Test
    public void addItemZeroQuantity(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().chooseSize("L").clickColor().setQuantity("0")
                        .clickAddToCart().getQuantityAlertMsg()
                ,"Please enter a quantity greater than 0.");

    }
    @Test
    public void addItemToCart(){
        Assert.assertEquals(homePage.goToJacketsMenSection().addItemOnly().chooseSize("L").clickColor().setQuantity("1")
                        .clickAddToCart().getSuccessMsg()
                ,"You added Proteus Fitness Jackshirt to your shopping cart.");
    }

}
