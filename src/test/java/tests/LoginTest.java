package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.parent.BaseTest;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.loginSwagLabs("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products", "Название заголовка не соответствует ожидаемому.");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void checkIncorrectLogin(String user, String rassword, String errorMsg) {
        loginPage.open();
        loginPage.loginSwagLabs(user, rassword);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
