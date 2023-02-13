import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        String productText = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("PRODUCTS", productText);

        String inventoryItemName = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals("Sauce Labs Backpack", inventoryItemName);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("shopping_cart_link")).click();

        String cartItemName = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals("Sauce Labs Backpack", cartItemName);
        Thread.sleep(2000);
        driver.navigate().back();


        String inventory0TitleLink = driver.findElement(By.id("item_0_title_link")).getText();
        Assert.assertEquals("Sauce Labs Bike Light", inventory0TitleLink);
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("All Tests Pass!");

    }
}
