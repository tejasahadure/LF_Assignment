package stepDefination;

import io.cucumber.java.en.*;
import org.leapfrog.driverfactory.TestBase;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;

import java.util.Arrays;
import java.util.Collections;

public class StepDefinitions extends TestBase {

    private String username;
    private String password;
    private String numOfitems;
    private String itemNames[];
    private Float itemPrices[];


    @Given("User should navigate to swag labs login page")
    public void user_should_navigate_to_swag_labs_login_page() {
        String url = "https://www.saucedemo.com/";
        driver = inheritance();
        driver.get(url);
    }

    @When("User enter the {string} and {string}")
    public void user_enter_the_and(String Username, String Password) {
        username = Username;
        password = Password;
        LoginPage H1 = new LoginPage(driver);
        H1.typeUserName().sendKeys(Username);
        H1.typePassword().sendKeys(Password);

    }

    @When("User click the login button")
    public void user_click_the_login_button() {
        LoginPage H1 = new LoginPage(driver);
        H1.clickLoggingButton().click();
    }

    @Then("User should navigate to Swag Labs home page")
    public void user_should_navigate_to_swag_labs_home_page() throws InterruptedException {
        LoginPage H1 = new LoginPage(driver);
        boolean var1 = H1.HomePage().isDisplayed();

        if (var1 == true) {
            System.out.println("user can log into the application with user “standard_user” Successfully");
            Thread.sleep(2000);
            driver.close();
        } else {
            System.out.println("Not navigated");
        }
    }


    @Given("User should login to swag labs using correct {string} and {string}")
    public void user_should_login_to_swag_labs_using_correct_and(String Username, String Password) {
        String url = "https://www.saucedemo.com/";
        driver = inheritance();
        driver.get(url);

        LoginPage H1 = new LoginPage(driver);
        H1.typeUserName().sendKeys(Username);
        H1.typePassword().sendKeys(Password);

        H1.clickLoggingButton().click();

    }

    @When("User click the add to cart button {int}")
    public void user_click_the_add_to_cart_button(Integer itemNumber) {
        LoginPage H1 = new LoginPage(driver);
        numOfitems = H1.CartBadgeContainer().getText();
        //System.out.println("Button text before is : "+H1.AddToCartButton().get(0).getText());
        H1.AddToCartButton().get(itemNumber).click();
        //Thread.sleep(3000);
        //System.out.println("Button text after is : "+H1.RemoveButton().get(0).getText());
        System.out.println("Button is " + itemNumber);

    }

    @Then("User should see the updated cart badge")
    public void user_should_see_the_updated_cart_badge() {
        LoginPage H1 = new LoginPage(driver);
        //numOfitems = H1.CartBadgeContainer().getText();
        if (numOfitems.equals("")) {
            numOfitems = "0";
        }

        String numOfitemsNew = H1.CartBadgeContainer().getText();

        System.out.println("Number of items in the cart is : " + numOfitems);
        System.out.println("Number of items in the cart new is : " + numOfitemsNew);

        if (Integer.parseInt(numOfitemsNew) == Integer.parseInt(numOfitems) + 1) {
            System.out.println("Cart badge is updated successfully");
        } else {
            System.out.println("Fail to upadted");
        }
        driver.quit();
    }


    @When("User click the sort AZ")
    public void user_click_the_sort_az() {
        itemNames = new String[6];
        LoginPage H1 = new LoginPage(driver);

        for (int i = 0; i <= 5; i++) {
            itemNames[i] = H1.ItemNames().get(i).getText();
            System.out.println("before sort Item name : " + itemNames[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("az");
    }

    @Then("User should see the AZ sorted products")
    public void user_should_see_the_az_sorted_products() {
        LoginPage H1 = new LoginPage(driver);
        String itemNamesAfterSort[] = new String[6];

        for (int i = 0; i <= 5; i++) {
            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
            System.out.println("After clicked sort Item name : " + itemNamesAfterSort[i]);
        }
        Arrays.sort(itemNames);
        if (Arrays.equals(itemNames, itemNamesAfterSort)) {

            System.out.println("Sorted correctly A-Z");
        } else {
            System.out.println("Incorrectly sorted A-Z");
        }
        driver.quit();
    }

    @When("User click the sort ZA")
    public void user_click_the_sort_za() {
        itemNames = new String[6];
        LoginPage H1 = new LoginPage(driver);

        for (int i = 0; i <= 5; i++) {
            itemNames[i] = H1.ItemNames().get(i).getText();
            System.out.println("before sort Item name : " + itemNames[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("za");
    }

    @Then("User should see the ZA sorted products")
    public void user_should_see_the_za_sorted_products() {
        LoginPage H1 = new LoginPage(driver);
        String itemNamesAfterSort[] = new String[6];

        for (int i = 0; i <= 5; i++) {
            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
            System.out.println("After clicked sort Item name : " + itemNamesAfterSort[i]);
        }
        //Arrays.sort(itemNames);
        Arrays.sort(itemNames, Collections.reverseOrder());

        if (Arrays.equals(itemNames, itemNamesAfterSort)) {

            System.out.println("Sorted correctly Z-A");
        } else {
            System.out.println("Incorrectly sorted Z-A");
        }
        driver.quit();
    }


    @When("User click the sort low to high")
    public void user_click_the_sort_low_to_high() {
        itemPrices = new Float[6];
        LoginPage H1 = new LoginPage(driver);

        for (int i = 0; i <= 5; i++) {
            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("before sort Item price : " + itemPrices[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("lohi");
    }

    @Then("User should see the low to high sorted products")
    public void user_should_see_the_low_to_high_sorted_products() {
        LoginPage H1 = new LoginPage(driver);
        Float itemPricesAfterSort[] = new Float[6];

        for (int i = 0; i <= 5; i++) {
            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("After clicked sort Item price : " + itemPricesAfterSort[i]);
        }

        Arrays.sort(itemPrices);

        if (Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Sorted correctly price low to high");
        } else {
            System.out.println("Incorrectly sorted price low to high");
        }
        for (int i = 0; i <= 5; i++) {

            System.out.println("Aftersort Item price : " + itemPrices[i]);
        }
        driver.quit();
    }

    @When("User click the sort high to low")
    public void user_click_the_sort_high_to_low() {
        itemPrices = new Float[6];
        LoginPage H1 = new LoginPage(driver);

        for (int i = 0; i <= 5; i++) {
            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("before sort Item price : " + itemPrices[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("hilo");
    }

    @Then("User should see the high to low sorted products")
    public void user_should_see_the_high_to_low_sorted_products() {
        LoginPage H1 = new LoginPage(driver);
        Float itemPricesAfterSort[] = new Float[6];

        for (int i = 0; i <= 5; i++) {
            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("After clicked sort Item price : " + itemPricesAfterSort[i]);
        }


        Arrays.sort(itemPrices, Collections.reverseOrder());
        if (Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Sorted correctly price high to low");
        } else {
            System.out.println("Incorrectly sorted price high to low");
        }
        for (int i = 0; i <= 5; i++) {

            System.out.println("Aftersort Item price : " + itemPrices[i]);
        }
        driver.quit();
    }


    @Given("User click the add to cart buttons")
    public void user_click_the_add_to_cart_buttons() {
        LoginPage H1 = new LoginPage(driver);

        for (int i = 0; i <= 5; i++) {
            H1.AddToCartButton().get(0).click();
        }
    }

    @Given("User click the cart icon")
    public void user_click_the_cart_icon() {
        LoginPage H1 = new LoginPage(driver);
        H1.CartBadgeContainer().click();
    }

    @When("User click the checkout button")
    public void user_click_the_checkout_button() {
        LoginPage H1 = new LoginPage(driver);
        H1.CheckoutButton().click();
    }

    @Then("User should see the checkout info page")
    public void user_should_see_the_checkout_info_page() {
        LoginPage H1 = new LoginPage(driver);
        boolean CheckoutInfo = H1.TitleProduct().isDisplayed();
        if (CheckoutInfo) {

            System.out.println("Checkout Page");

        } else {

            System.out.println("Not navigated");
        }
        driver.quit();
    }

    @Then("User should not navigate to Swag Labs home page")
    public void user_should_not_navigate_to_swag_labs_home_page() throws InterruptedException {
        LoginPage H1 = new LoginPage(driver);
        boolean var1 = H1.LoginPage().isDisplayed();

        if (var1 == true) {
            System.out.println("Not Navigated");
            Thread.sleep(2000);
            driver.close();
        } else {
            System.out.println("Navigated to Home page");

        }

    }
}
