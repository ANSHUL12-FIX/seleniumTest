import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class WebAutomationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Your test logic here
        driver.get("https://app.vwo.com");
        driver.findElement(By.id("login-username")).sendKeys("b2138830@trbvn.com");
        driver.findElement(By.id("login-password")).sendKeys("hacker123");
        driver.findElement(By.id("js-login-btn")).click();

        // Add assertions to validate the test
        System.out.println("Current URL: " + driver.getCurrentUrl());

//        assertTrue("Login successful", driver.getCurrentUrl().contains("/dashboard"));
    }

    @Test
    public void testInvalidLogin() {
        // Test invalid login
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("invalidusername@example.com");
        driver.findElement(By.id("login-password")).sendKeys("invalidpassword");
        driver.findElement(By.id("js-login-btn")).click();

        // Add assertions to validate the test

    }

    @Test
    public void testEmptyFieldsLogin() {
        // Test login with empty username and password fields
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("js-login-btn")).click();

        // Add assertions to validate the test

    }

    @Test
    public void testSuccessfulLogout() {
        // Test successful logout after logging in
        WebElement logoutButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa='logout-btn']")));
        logoutButton.click();

      //  driver.findElement(By.id("js-logout-btn")).click(); // Assuming there's a logout button with id "logout-btn"

    }

    @Test
    public void testRedirectToLogin() {
        // Test redirection to login page when accessing dashboard without logging in
        driver.get("https://app.vwo.com/#/dashboard");
        assertTrue("Redirected to login page", driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void testForgotPassword() {
        // Test the "forgot password" functionality
//        driver.get("https://app.vwo.com/#/login");
//        driver.findElement(By.linkText("Forgot password?")).click(); // Assuming there's a link with text "Forgot password?"
        driver.get("https://app.vwo.com/#/login");
        WebElement forgotPasswordButton = driver.findElement(By.xpath("//*[@id='js-login-form']/ul/li[3]/button"));
        forgotPasswordButton.click();
    }
//    @After
//    public void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
