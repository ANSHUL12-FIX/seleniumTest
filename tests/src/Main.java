import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.findElement(By.id("login-username")).sendKeys("b2138830@trbvn.com");
        driver.findElement(By.id("login-password")).sendKeys("hacker123");
        driver.findElement(By.id("js-login-btn")).click();
        driver.wait(20000);



    }
}