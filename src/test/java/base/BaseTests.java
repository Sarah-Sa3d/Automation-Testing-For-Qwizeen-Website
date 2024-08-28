package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests  {
    protected WebDriver driver;


    @BeforeMethod
    @Step("Open Browser & Open Website")
    public void setupDriver() {
        driver = new ChromeDriver(  );
        driver.get("https://dev.stagingserver.io/automation/");
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(7));
    }


    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}