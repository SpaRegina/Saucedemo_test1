package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.User;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.loginSwagLabs(withAdminPermission());
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products", "Название заголовка не соответствует ожидаемому.");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {withLockUserPermission(), PropertyReader.getProperty("error.locked")},
                {withEmptyUsername(), PropertyReader.getProperty("error.empty_username")},
                {withEmptyPassword(), PropertyReader.getProperty("error.empty_password")}
        };
    }

    @Test(dataProvider = "loginData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.loginSwagLabs(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
