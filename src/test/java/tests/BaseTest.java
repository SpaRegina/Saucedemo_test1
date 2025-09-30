package tests.parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    public String user;
    public String password;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional(("chrome")) String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new EdgeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        user = PropertyReader.getProperty("saucedemo_test1.user");
        password = PropertyReader.getProperty("saucedemo_test1.password");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

