package test.project;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
    
    static WebDriver driver;
    
    public static void main(String args[]) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnter();

    }
}
