package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By productNamesLocator = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем список названий товаров из корзины")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allproductsNames = driver.findElements(productNamesLocator);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allproductsNames) {
            names.add(product.getText());
        }

        return names;
    }
}
