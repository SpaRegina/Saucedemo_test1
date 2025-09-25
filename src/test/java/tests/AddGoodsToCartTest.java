package tests;

import org.testng.annotations.Test;
import tests.parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void testSuccessfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products", "Название заголовка не соответствует ожидаемому.");

//      productsPage.addToCart();
        productsPage.addToCart(0);
        productsPage.addToCart(1);
    }
}
