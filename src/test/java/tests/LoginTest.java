package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.parent.BaseTest;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void testSuccessfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
    }

    @Test(description = "Проверка авторизации с заблокированным пользователем")
    public void testLockedOutUserError() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Проверка ошибки при пустом имени пользователя")
    public void testLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String expectedError = "Epic sadface: Username is required";
        assertEquals(loginPage.checkErrorMsg(), expectedError, "Текст ошибки для пустого имени пользователя неверный.");
    }


    @Test(description = "Проверка ошибки при пустом пароле")
    public void testLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        String expectedError = "Epic sadface: Password is required";
        assertEquals(loginPage.checkErrorMsg(), expectedError, "Текст ошибки для пустого пароля неверный.");
    }
}
