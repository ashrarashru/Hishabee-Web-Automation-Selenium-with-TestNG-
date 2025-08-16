package Classes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;
import java.util.List;
import Utils.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StockBook {

    @FindBy(xpath = "//a[contains(.,'স্টকের হিসাব')]")
    WebElement stockBook;

    @FindBy(xpath = "//span[contains(.,'প্রোডাক্ট যুক্ত করুন')]")
    WebElement addProductBtn;

    @FindBy(tagName = "input")
    List<WebElement> productName; // get 2

    @FindBy(tagName = "input")
    List<WebElement> currentStock; // get 3

    @FindBy(tagName = "input")
    List<WebElement> purchasePrice; // get 4

    @FindBy(tagName = "input")
    List<WebElement> sellPrice; // get 5

    @FindBy(xpath = "//button[contains(.,'ইউনিট')]")
    WebElement units;

    @FindBy(css = "[name=details]")
    WebElement details;

    @FindBy(css = "[role=switch]")
    List<WebElement> warranty; // get 4

    @FindBy(css = "[name=warranty_duration]")
    WebElement dates;

    @FindBy(css = "[type=submit]")
    WebElement submitBtn;

    @FindBy(xpath = "//span[contains(.,'স্টক/মজুদ এডিট')]")
    WebElement updateStockBtn;

    @FindBy(tagName = "button")
    List<WebElement> increaseBtn; // get 9

    @FindBy(tagName = "button")
    List<WebElement> saveBtn; // get 7

    @FindBy(tagName = "button")
    List<WebElement> cancelBtn; // get 6

    @FindBy(css = "[id=search]")
    WebElement search;


    Actions actions;
    WebDriver driver;
    WebDriverWait wait;
    public StockBook(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }



    public void addProduct(String name, String curStock, String purPrice, String sePrice, String unit, String info, String date) throws InterruptedException {
        stockBook.click();
        By dashboard = By.xpath("//p[contains(.,'পণ্য স্টক ম্যানেজমেন্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        addProductBtn.click();
        Thread.sleep(1000);

        productName.get(2).sendKeys(name);
        currentStock.get(3).sendKeys(curStock);
        purchasePrice.get(4).sendKeys(purPrice);
        sellPrice.get(5).sendKeys(sePrice);

        Thread.sleep(1000);

        actions.sendKeys(units, unit).pause(500)
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        //Upload Image
        String path = new File("./src/test/resources/uiisiiC100.jpg").getAbsolutePath();
        driver.findElement(By.id("files")).sendKeys(path);

        Thread.sleep(1000);

        Utils.scroll(driver,600);

        details.sendKeys(info);

        warranty.get(4).click();
        dates.sendKeys(date);
        submitBtn.click();


    }

    public void inputMandatoryFields(String name, String sePrice) throws InterruptedException {
        stockBook.click();
        By dashboard = By.xpath("//p[contains(.,'পণ্য স্টক ম্যানেজমেন্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        addProductBtn.click();
        Thread.sleep(1000);

        productName.get(2).sendKeys(name);
        sellPrice.get(5).sendKeys(sePrice);

        submitBtn.click();


    }

    public void updateStock() throws InterruptedException {
        stockBook.click();
        By dashboard = By.xpath("//p[contains(.,'পণ্য স্টক ম্যানেজমেন্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        updateStockBtn.click();
        By dashboard2 = By.xpath("//p[contains(.,'Update stock quantity')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard2));

        increaseBtn.get(9).click();
        increaseBtn.get(9).click();
        Thread.sleep(500);
        saveBtn.get(7).click();
        cancelBtn.get(6).click();
    }

    public void searchProduct(String name) throws InterruptedException {
        stockBook.click();
        By dashboard = By.xpath("//p[contains(.,'পণ্য স্টক ম্যানেজমেন্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        updateStockBtn.click();
        Thread.sleep(1000);

        actions.sendKeys(search, name).pause(500)
                .sendKeys(Keys.ENTER).perform();

    }
}
