package test.project;

import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageTest {
    
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void SignInTest(){
        LoginPage loginPage = mainPage.clickEnter();
        String heading = loginPage.getHeadinText();
        Assert.assertEquals("Вход", heading);
    }

    @Test
    public void RegisetFeailTest(){
        LoginPage loginPage = mainPage.clickEnter();
        SignUpPage signUpPage = loginPage.createAccount();
        signUpPage.loginWithInvalidValue("test", "123");
        String errorEmail = signUpPage.getErrorEmailText();
        Assert.assertEquals("Некорректный e-mail", errorEmail);
        String errorPassword = signUpPage.getErrorPasswordText();
        Assert.assertEquals("Пароль должен быть от 8 до 64 символов", errorPassword);

    }

    @Test
    public void SignUpEmptyUserNameTest(){
        LoginPage loginPage = mainPage.clickEnter();
        SignUpPage signUpPage = loginPage.createAccount();
        signUpPage.loginWithInvalidValue("", "123");
        String errorEmail = signUpPage.getErrorEmptyEmailText();
        Assert.assertEquals("Укажите e-mail", errorEmail);
    }

    @Test
    public void SignUpEmptyCheckBoxTest(){
        LoginPage loginPage = mainPage.clickEnter();
        SignUpPage signUpPage = loginPage.createAccount();
        signUpPage.loginWithoutCheckBox("Test", "123qwe123");
        String errorEmail = signUpPage.getErrorCheckBoxText();
        Assert.assertEquals("Для регистрации аккаунта необходимо ваше согласие с Политикой конфиденциальности и Пользовательским соглашением", errorEmail);
    }

    @After
    public void teardown(){
        driver.quit();
    }



}
