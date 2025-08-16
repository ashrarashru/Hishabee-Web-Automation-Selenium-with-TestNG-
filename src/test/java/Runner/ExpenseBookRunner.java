package Runner;

import Classes.ExpenseBook;
import Classes.LoginUser;
import Setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExpenseBookRunner extends Setup {

    @Test(description = "Create Expense Category", priority = 1)
    public void createCategory() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        String name= "Others";
        expenseBook.createCategory(name);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense category added";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses in Salary Category", priority = 2)
    public void addSalary() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        //String catName= "বেতন";
        String catName= "তন";
        String amount= "15000";
        String reason= "Month Salary";
        String note= "Kashem Siddique";
        expenseBook.addExpense(catName, amount, reason,note);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense Added Successfully";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses in Purchase Category", priority = 3)
    public void addPurchase() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        //String catName= "কেনা";
        String catName= "কে";
        String amount= "5000";
        String reason= "Accessories";
        String note= "Phone Cover";
        expenseBook.addExpense(catName, amount, reason,note);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense Added Successfully";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses in Bill Category", priority = 4)
    public void addBill() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        //String catName= "বিল";
        String catName= "বি";
        String amount= "3000";
        String reason= "Electricity Bill";
        String note= "Postpaid";
        expenseBook.addExpense(catName, amount, reason,note);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense Added Successfully";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses in Rent Category", priority = 5)
    public void addRent() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        //String catName= "ভাড়া";
        String catName= "ভা";
        String amount= "30000";
        String reason= "Shop Rent";
        String note= "August";
        expenseBook.addExpense(catName, amount, reason,note);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense Added Successfully";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses in Created Category", priority = 6)
    public void addOthers() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        String catName= "Others";
        String amount= "1800";
        String reason= "Service Charge";
        String note= "Security";
        expenseBook.addExpense(catName, amount, reason,note);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense Added Successfully";
        Assert.assertTrue(actText.contains(expText));
    }


    @Test(description = "Edit Expense Cost", priority = 7)
    public void editCost() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        String name = "Oth";
        String price = "3200";
        expenseBook.edit(name, price);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Edited Successfully";
        Assert.assertTrue(actText.contains(expText));
    }


    @Test(description = "Delete Expense", priority = 8)
    public void deleteExpense() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        expenseBook.deleteExpense();

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense deleted successfully";
        Assert.assertTrue(actText.contains(expText));
    }


    @Test(description = "Edit Created Expense Category Name", priority = 9)
    public void editCategory() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        String name = "Final Cost";
        expenseBook.editCategory(name);

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Expense category edited";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Delete Created Expense Category", priority = 10)
    public void deleteCategory() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        expenseBook.deleteCategory();

        String actText = driver.findElement(By.className("toaster")).getText();
        System.out.println(actText);

        String expText = "Category deleted successfully";
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(description = "Add Expenses Without Selecting an Expense Category", priority = 11)
    public void addExpensesWithoutCategory() throws InterruptedException {
        LoginUser loginUser = new LoginUser(driver);
        loginUser.doLogin("01571503554","12345");
        Thread.sleep(1000);

        By stockBookText = By.xpath("//span[contains(.,'খরচের খাতা')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockBookText));

        Thread.sleep(1000);

        ExpenseBook expenseBook = new ExpenseBook(driver);

        String amount= "15000";
        String reason= "Month Salary";
        String note= "Kashem Siddique";
        expenseBook.addExpensesWithoutCategory(amount, reason,note);

        WebElement extract = driver.findElements(By.cssSelector("p")).get(2);
        String actText = extract.getText();
        System.out.println(actText);

        String expText = "this field is required.";
        Assert.assertTrue(actText.contains(expText));
    }

}
