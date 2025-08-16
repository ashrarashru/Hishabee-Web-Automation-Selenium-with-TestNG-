package Runner;

import Classes.LoginUser;
import Setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginUserRunner extends Setup {

    @Test(description = "Login with valid phone number", priority = 1)
    public void login1() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");

        By homePage = By.xpath("//p[contains(.,'ড্যাশবোর্ড')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));

        loginUser.doLogout();
        Thread.sleep(2000);
    }

    @Test(description = "Login with wrong password", priority = 2)
    public void login2() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin1("01571503554","1234");

        //String actText = driver.findElement(By.className("toaster")).getText();
        String actText = driver.findElement(By.cssSelector("[data-type=error]")).getText();
        System.out.println(actText);
        String expText = "You phone or pin is incorrect";

        Assert.assertTrue(actText.contains(expText));

    }

    @Test(description = "Login with blank password", priority = 3)
    public void login3(){
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin1("01571503554","");

        String actText = driver.findElements(By.className("undefined")).get(26).getText();
        System.out.println(actText);
        String expText = "Please Enter Your Pin";

        Assert.assertTrue(actText.contains(expText));

    }

    @Test(description = "Login with blank password", priority = 4)
    public void login4() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin2("01571.50355");

        WebElement actText = driver.findElement(By.xpath("//p[contains(text(),'Unable To Verify Your Phone Number')]")
        );

        String actualText = actText.getText();
        System.out.println(actualText);
        String expText = "Unable To Verify Your Phone Number";

        Assert.assertTrue(actualText.contains(expText));


    }

}
