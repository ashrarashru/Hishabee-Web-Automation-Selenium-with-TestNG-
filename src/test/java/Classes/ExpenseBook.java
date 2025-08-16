package Classes;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExpenseBook {

    @FindBy(xpath = "//a[contains(.,'খরচের খাতা')]")
    WebElement expenseBook;

    @FindBy(tagName = "button")
    List<WebElement> create; // get 6

    @FindBy(tagName = "button")
    List<WebElement> newCreate; // get 8

    @FindBy(tagName = "input")
    WebElement catName;

    @FindBy(tagName = "button")
    List<WebElement> save; // get 10

    @FindBy(tagName = "button")
    List<WebElement> newExpense; // get 7

    @FindBy(xpath = "//button[contains(.,'ক্যাটাগরির নাম')]")
    WebElement category;

    @FindBy(tagName = "input")
    List<WebElement> amount; // get 0

    @FindBy(tagName = "input")
    List<WebElement> expenseReason; // get 1

    @FindBy(tagName = "input")
    List<WebElement> note; // get 2

    @FindBy(xpath = "//button[contains(.,'সেভ করুন')]")
    WebElement saveBtn;

    @FindBy(tagName = "button")
    List<WebElement> edit; // get 8

    @FindBy(css = "[role=menuitem]")
    List<WebElement> doEdit; // get 0

    @FindBy(tagName = "input")
    List<WebElement> editPrice; // get 0

    @FindBy(css = "[type=submit]")
    WebElement getSave;

    @FindBy(tagName = "button")
    List<WebElement> delete; // get 13

//    @FindBy(tagName = "button")
//    List<WebElement> list; // 6

    @FindBy(xpath = "//button[contains(.,'ব্যয়ের তালিকা')]")
    WebElement list;

//    @FindBy(css = "[aria-haspopup=menu]")
//    List<WebElement> editCat; // get 1

    @FindBy(css = "[data-state=closed]")
    List<WebElement> editCat; // get 6


    @FindBy(tagName = "input")
    WebElement editName;


    @FindBy(xpath = "//button[contains(.,'সেভ করুন')]")
    WebElement save2;

    @FindBy(css = "[role=menuitem]")
    List<WebElement> editt; // get 0

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(.,'নতুন ক্যাটাগরি')]")
    WebElement new1;

    @FindBy(xpath = "//button[contains(.,'save')]")
    WebElement newSave;

    Actions actions;
    WebDriverWait wait;
    public ExpenseBook(WebDriver driver){
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    //Create Expense Category
    public void createCategory(String name) throws InterruptedException {
        expenseBook.click();
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        create.get(6).click();
        Thread.sleep(1000);

        //newCreate.get(8).click();
        new1.click();
        Thread.sleep(500);
        catName.sendKeys(name);
        Thread.sleep(500);
        //save.get(10).click();
        newSave.click();
        Thread.sleep(1000);

    }

    public void addExpense(String catName, String amountt, String reason, String notee) throws InterruptedException {
        expenseBook.click();
        //Thread.sleep(500);
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        newExpense.get(7).click();
        Thread.sleep(2000);

        actions.sendKeys(category, catName).pause(500)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        amount.get(0).sendKeys(amountt);
        Thread.sleep(500);
        expenseReason.get(1).sendKeys(reason);
        note.get(2).sendKeys(notee);

        saveBtn.click();
        Thread.sleep(1000);
    }

    //Edit Price
    public void edit(String catName, String price) throws InterruptedException {
        expenseBook.click();
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        edit.get(8).click();
        doEdit.get(0).click();
        editPrice.get(0).click();
        Thread.sleep(1000);

        actions.sendKeys(category, catName).pause(500)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        editPrice.get(0).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        editPrice.get(0).sendKeys(price);
        Thread.sleep(1000);
        getSave.click();
        Thread.sleep(1000);
    }

    //Delete Expense
    public void deleteExpense() throws InterruptedException {
        expenseBook.click();
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        edit.get(8).click();
        doEdit.get(1).click();
        Thread.sleep(1000);

        By caution = By.xpath("//p[contains(.,'Delete Expense')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(caution));
        Thread.sleep(1000);
        delete.get(13).click();
        Thread.sleep(1000);
    }

    //Edit Category
    public void editCategory(String name) throws InterruptedException {
        expenseBook.click();
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        //list.get(6).click();
        list.click();
//        By caution = By.xpath("//p[contains(.,'All Expense Categories')]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(caution));
        Thread.sleep(2000);

        editCat.get(6).click();
        Thread.sleep(1000);
        editt.get(0).click();
        Thread.sleep(1000);

        editName.click();
        editName.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        editName.sendKeys(name);
        save2.click();
        Thread.sleep(1000);
    }

    //Delete Category
    public void deleteCategory() throws InterruptedException {
        expenseBook.click();
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        list.click();
//        By caution = By.xpath("//p[contains(.,'All Expense Categories')]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(caution));
        Thread.sleep(1000);

        editCat.get(6).click();
        Thread.sleep(1000);
        editt.get(1).click();
        Thread.sleep(1000);

        deleteBtn.click();
        Thread.sleep(1000);

    }

    //Skip Selecting an Expense Category
    public void addExpensesWithoutCategory(String amountt, String reason, String notee) throws InterruptedException {
        expenseBook.click();
        //Thread.sleep(500);
        By report = By.xpath("//p[contains(.,'খরচের রিপোর্ট')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(report));

        newExpense.get(7).click();
        Thread.sleep(2000);

        amount.get(0).sendKeys(amountt);
        Thread.sleep(500);
        expenseReason.get(1).sendKeys(reason);
        note.get(2).sendKeys(notee);

        saveBtn.click();
        Thread.sleep(1000);
    }
}
