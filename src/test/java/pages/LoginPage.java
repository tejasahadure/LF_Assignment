package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LoginPage {


    public WebDriver driver;

    By var_UserName = By.id("user-name");
    By var_Password = By.id("password");
    By var_Logging_button = By.id("login-button");
    By var_checkout_button = By.id("checkout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement typeUserName() {
        return driver.findElement(var_UserName);
    }

    public WebElement typePassword() {
        return driver.findElement(var_Password);
    }

    public WebElement clickLoggingButton() {
        return driver.findElement(var_Logging_button);
    }

    public WebElement HomePage() {
        By ProductLable = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        return driver.findElement(ProductLable);
    }

    public WebElement CartBadgeContainer() {
        By ProductSortOpt = By.xpath("//*[@id=\"shopping_cart_container\"]");
        return driver.findElement(ProductSortOpt);
    }

    public List<WebElement> AddToCartButton() {
        return driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    }

    public List<WebElement> ItemNames() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public WebElement SortDropDown() {
        By SortOpt = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
        return driver.findElement(SortOpt);
    }

    public List<WebElement> ItempRrice() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public WebElement CheckoutButton() {
        return driver.findElement(var_checkout_button);
    }

    public WebElement TitleProduct() {
        By TitleProduct = By.xpath("/html/body/div/div/div/div[1]/div[2]/span");
        return driver.findElement(TitleProduct);
    }

    public WebElement LoginPage() {
        By SwagLabLable = By.xpath("//*[@id=\"root\"]/div/div[1]");
        return driver.findElement(SwagLabLable);
    }
}
