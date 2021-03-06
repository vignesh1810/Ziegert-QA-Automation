package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

/*
 * This test is to verify if the items can be cleared from the cart
 * And also to verify the price and quantity in Cart becomes Zero
 */
public final class TC04 extends BaseTest {

    @Test()
    public void clearItemsInCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.clickAddToCart("1")
                .waitForCartPageToLoad()
                .clickAddedItemRemoveButton()
                .waitForNoItemsInCartMessageToLoad();

        int cartTotalPriceText = cartPage.getCartTotalPriceText();
        int bagQuantityCountText = cartPage.getBagQuantityCountText();

        Assert.assertEquals(cartTotalPriceText,0,"Price does not match");
        Assert.assertEquals(bagQuantityCountText,0,"Quantity does not match");
    }
}