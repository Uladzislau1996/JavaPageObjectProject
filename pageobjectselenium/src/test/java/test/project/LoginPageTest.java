package test.project;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginPageTest {
    
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    
    @Before
    public void setUp(){
    //driver = new FirefoxDriver();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
    driver.manage().window().maximize();
    driver.get("https://www.onliner.by/");
    mainPage = new MainPage(driver);
    mainPage.clickEnter();
    loginPage = new LoginPage(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void LoginWithEmptyCreds(){
        loginPage.login("", "");
        String errorEmail = loginPage.getErrorEmptyEmailText();
        Assert.assertEquals("Укажите ник или e-mail", errorEmail);
        String errorPassword = loginPage.getErrorEmptyPasswrodText();
        Assert.assertEquals("Укажите пароль", errorPassword);
    }

    @Test
    public void LoginIncorrectCreds(){
        loginPage.login("123", "rsdf");
        String errorCreds = loginPage.getErrorInvalidCredsText();
        Assert.assertEquals("Неверный логин или пароль", errorCreds);
    }

    @Test
    public void RegisteLink(){
        SignUpPage signUp = loginPage.createAccount();
        String pageName = signUp.getPageNameText();
        Assert.assertEquals("Регистрация", pageName);
    }

    @Test
    public void CheckPage(){
        String heading = loginPage.getHeadinText();
        Assert.assertEquals("Вход", heading);
        
    }
    

}
