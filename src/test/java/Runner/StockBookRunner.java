package Runner;

import Classes.LoginUser;
import Classes.StockBook;
import Setup.Setup;
import com.github.javafaker.Stock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class StockBookRunner extends Setup {

    @Test(description = "Input mandatory fields + others",priority = 1)
    public void addProduct() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");

        By stockBookText = By.xpath("//span[contains(.,'স্টকের হিসাব')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1500);
        StockBook stockBook = new StockBook(driver);

        String name = "Uiisii C100";
        String stock = "20";
        String purchase = "160";
        String sell = "200";
        String unit = "পিস";
        String date = "7";
        String info = "Black Colour";

        stockBook.addProduct(name,stock,purchase,sell,unit,info,date);
    }

    @Test(description = "Input mandatory fields",priority = 2)
    public void onlyMandatoryFields() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");

        By stockBookText = By.xpath("//span[contains(.,'স্টকের হিসাব')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1500);
        StockBook stockBook = new StockBook(driver);

        String name = "Uiisii U8";
        String sell = "250";

        stockBook.inputMandatoryFields(name,sell);
        Thread.sleep(1000);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);
        String expText = "Product added";

        Assert.assertTrue(actText.contains(expText));
    }


    @Test(description = "Update stock",priority = 3)
    public void updateStock() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");

        By stockBookText = By.xpath("//span[contains(.,'স্টকের হিসাব')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1500);
        StockBook stockBook = new StockBook(driver);

        stockBook.updateStock();

    }

    @Test(description = "Search Product",priority = 4)
    public void productSearch() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");

        By stockBookText = By.xpath("//span[contains(.,'স্টকের হিসাব')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1500);
        StockBook stockBook = new StockBook(driver);

        String name = "Uiisii C100";
        stockBook.searchProduct(name);
    }



}
