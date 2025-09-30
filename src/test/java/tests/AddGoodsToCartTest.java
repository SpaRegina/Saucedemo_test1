package tests;

import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Проверка товаров")
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.loginSwagLabs(UserFactory.withAdminPermission());
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);

        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
