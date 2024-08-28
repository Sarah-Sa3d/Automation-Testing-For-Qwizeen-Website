package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class LoginPage  {
    WebDriver driver;

    private final By firstName_obj = new By.ById("firstName");
    private final By firstName_status_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]");

    private final By lastName_obj = new By.ById("lastName");
    private final By lastName_status_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/span[1]");

    private final By email_obj = new By.ById("email");
    private final By email_status_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[2]/span[1]");


    private final By password_obj = new By.ById("password");
    private final By password_status_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[3]/span[1]");

    private final By confirm_password_obj = new By.ById("conformPassword");
    private final By confirm_password_status_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/span[1]");

    private final By submit_obj = new By.ByXPath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]");
    private final By submit_status_obj = new By.ByXPath("");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }




    /*   First Name Functions  */
    @Step("Enter First Name")
    public LoginPage entering_FirstName(String FirstName_Data) {
        driver.findElement(firstName_obj).clear();
        driver.findElement(firstName_obj).sendKeys( FirstName_Data);
        return this;
    }

    public String getFirstNameStatus() {
        return driver.findElement( firstName_status_obj ).getText();
    }

    public Boolean getFirstNameStatus_FoundOrNot() {
        try {
            driver.findElement(firstName_status_obj);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /*   Last Name Functions  */
    @Step("Enter Last Name")
    public void entering_LastName(String LastName_Data) {
        driver.findElement(lastName_obj).clear();
        driver.findElement(lastName_obj).sendKeys( LastName_Data);
    }

    public String getLastName_Status() {
        return driver.findElement( lastName_status_obj ).getText();
    }

    public Boolean getLastNameStatus_FoundOrNot() {
        try {
            driver.findElement(lastName_status_obj);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /*   Last Email Functions  */
    @Step("Enter Email")
    public void entering_Email(String Email_Data) {
        driver.findElement(email_obj).clear();
        driver.findElement(email_obj).sendKeys( Email_Data);
    }

    public String getEmail_Status() {
        return driver.findElement( email_status_obj ).getText();
    }

    public Boolean getEmailStatus_FoundOrNot() {
        try {
            driver.findElement(email_status_obj);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /*   Last Password Functions  */
    @Step("Enter Password")
    public void entering_Password(String Password_Data) {
        driver.findElement(password_obj).clear();
        driver.findElement(password_obj).sendKeys( Password_Data);
    }

    public String getPassword_Status() {
        return driver.findElement( password_status_obj ).getText();
    }




    /*   Last ConfirmPassword Functions  */
    @Step("Enter ConfirmPassword")
    public void entering_ConfirmPassword(String ConfirmPassword_Data) {
        driver.findElement(confirm_password_obj).clear();
        driver.findElement(confirm_password_obj).sendKeys( ConfirmPassword_Data);
    }

    public String getConfirmPassword_Status() {
        return driver.findElement( confirm_password_status_obj ).getText();
    }

    public Boolean getConfirmPasswordStatus_FoundOrNot() {
        try {
            driver.findElement(confirm_password_status_obj);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    /*   Last ConfirmPassword Functions  */
    @Step("Click Submit Button")
    public void clickSubmit() {
        driver.findElement( submit_obj ).click();
    }
    public String clickSubmit_Status() {
        return driver.findElement( submit_status_obj ).getText();
    }


}
