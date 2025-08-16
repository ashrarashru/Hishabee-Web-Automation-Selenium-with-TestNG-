package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginUser {

    @FindBy(css = "[type=number]")
    WebElement phoneNumber;

    @FindBy(css = "[type=submit]")
    WebElement submitBtn;

    @FindBy(css = "[type=password]")
    WebElement passwordPin;

//    @FindBy(className = "font-semibold")
//    List<WebElement> selectShop; // get 1

    @FindBy(css = "button:has(p[title='সিলেক্ট করুন'])")
    List<WebElement> selectShop; // get 0

    @FindBy(className = "rounded-full")
    List<WebElement> profileIcon; // get 1

    @FindBy(css = "[role=menuitem]")
    List<WebElement> logoutBtn; // get 1


    WebDriverWait wait;
    public LoginUser(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public void doLogin(String number, String password) throws InterruptedException {

        By phnNum = By.xpath("//label[contains(.,'ফোন নাম্বার')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phnNum));

        phoneNumber.sendKeys(number);
        Thread.sleep(1000);
        submitBtn.click();

        By pin = By.xpath("//p[contains(.,'পিন নাম্বার')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin));
        passwordPin.sendKeys(password);
        submitBtn.click();

        By shop = By.xpath("//p[contains(.,'দোকান সিলেক্ট করুন')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(shop));
        selectShop.get(0).click();
    }

    //Wrong Password
    public void doLogin1(String number, String password){
        By phnNum = By.xpath("//label[contains(.,'ফোন নাম্বার')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phnNum));

        phoneNumber.sendKeys(number);
        submitBtn.click();

        By pin = By.xpath("//p[contains(.,'পিন নাম্বার')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin));
        passwordPin.sendKeys(password);
        submitBtn.click();
    }

    //Login With Blank Password
    public void doLogin2(String number) throws InterruptedException {
        By phnNum = By.xpath("//label[contains(.,'ফোন নাম্বার')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phnNum));

        phoneNumber.sendKeys(number);
        submitBtn.click();
        Thread.sleep(1000);
    }

    public void doLogout(){
        profileIcon.get(1).click();
        logoutBtn.get(1).click();

        By home = By.xpath("//p[contains(.,'আপনার ব্যবসার অল ইন ওয়ান বিজনেস সল্যুশন')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(home));
    }
}
