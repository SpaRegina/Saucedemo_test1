package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By LOGIN_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    public void loginSwagLabs(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        clickSubmit();
    }

    public void fillLoginField(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    public void fillPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
