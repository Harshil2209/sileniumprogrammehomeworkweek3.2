package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome";
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        driver.get(baseUrl); // open the base URL in the selected browser
        driver.manage().window().maximize(); // maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // wait for certain amount, so the link can load fully
    }

    public void closeBrowser() {
        driver.quit(); // close the browser
    }
}
