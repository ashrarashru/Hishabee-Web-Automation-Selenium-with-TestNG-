## Project Description
This project automates testing for the [**Hishabee**](https://web.hishabee.business) web application, ensuring that essential features such as Login, Stock Book, and Expense Book function correctly. It includes both positive and negative test cases to verify the application's stability and reliability.

## Prerequisites
Before running the tests, ensure you have the following set up:

**System Requirements:**
- Operating System: Windows/Mac/Linux
- JDK (Java Development Kit) installed (Version 8 or above)
- Browser drivers installed (e.g., ChromeDriver for Chrome, FirefoxDriver for Firefox)

**Tools and Frameworks:**
- Selenium WebDriver
- JUnit or TestNG for test management
- Maven/Gradle for dependency management

**Credentials:**
- A valid Gmail account to perform and verify email-based actions
- Admin credentials for the application, securely provided via the terminal at runtime.

**Dependencies:**
- Update the ```build.gradle``` file with required libraries such as Selenium, JUnit/TestNG, and any email API libraries.

## What I Have Done
The following steps were automated and tested successfully:

**Login:**
1. Login with valid credentials
2. Login with wrong pin number
3. Login with blank password
4. Login with invalid phone number

**Stock Book:**
1. Add new product with mandatory fields + other necessary fields
2. Add new product with only mandatory fields
3. Increase product stock quantity
4. Search product from stock management dashboard

**Expense Book:**
1. Create expense category
2. Add expenses in **"Salary"** category
3. Add expenses in **"Purchase"** category
4. Add expenses in **"Bill"** category
5. Add expenses in **"Rent"** category
6. Add expenses in **"Others"** category
7. Edit expense cost
8. Delete expense
9. Edit created expense category name
10. Delete created expense category
11. Add expenses without selecting expense category

## How to Run the Tests
Follow these steps to execute the automated tests:

- Clone the Repository
- Set Up the Environment
    - Install dependencies using Maven or Gradle
- Configure Credentials
    - Update the config.properties file with Gmail credentials and other necessary details.
    - Pass admin credentials securely when prompted by the terminal during execution.
- Run the Tests
- View Test Reports
    - After execution, access the test reports in the ```target/surefire-reports``` directory (for Maven) or ```build/reports/tests``` directory (for Gradle).


## Test Case Link
https://docs.google.com/spreadsheets/d/1cQP-8hAny-qjCW2-Zdbi0CxpZKDiX1lB/edit?usp=drive_link&ouid=107234482738036161269&rtpof=true&sd=true

## Reports

<img width="861" height="317" alt="Login Feature" src="https://github.com/user-attachments/assets/1bef5240-e2e6-4342-9b51-f50c5df72f78" />
<img width="858" height="314" alt="Stock Feature" src="https://github.com/user-attachments/assets/c284724d-2a25-419d-9a02-34326f05687b" />
<img width="860" height="539" alt="Expense Feature" src="https://github.com/user-attachments/assets/f7958609-0e94-4586-ab4d-f5018387fb80" />

## Sample Video of Automation Process

https://github.com/user-attachments/assets/9d1b1df0-4c72-475d-8ab2-798d38812f6e

https://github.com/user-attachments/assets/dfaae576-1fcc-4cac-aad0-ab6c74b63519

https://github.com/user-attachments/assets/0fe59212-2b0e-40bf-b727-80badd55ab0b


# ⚠️**Note**
Running the full Gradle suite test is not possible right now because it contains a **"Bangla"** selector, which causes errors. I know there is a solution for this, but I haven’t figured it out yet. For now, I run each feature individually instead.
