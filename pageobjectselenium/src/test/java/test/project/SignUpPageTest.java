package test.project;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPageTest {
    
    private WebDriver driver;
    private SignUpPage signUpPage;
    
    @Before
    public void setUp(){
    //driver = new FirefoxDriver();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
    driver.manage().window().maximize();
    driver.get("https://profile.onliner.by/registration");
    signUpPage = new SignUpPage(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void CheckPage(){
        String heading = signUpPage.getPageNameText();
        Assert.assertEquals("Регистрация", heading);
    }

    @Test
    public void InCorrectRepeatPasswrod(){
        signUpPage.loginWithBadPassword("test123@gmai.com", "123", "111");
        String errorBadRepeatPassword = signUpPage.getErrorPasswordNotMatchText();
        Assert.assertEquals("Пароли не совпадают", errorBadRepeatPassword);
    }


    @Test
    public void IncorrectName(){
        signUpPage.loginWithInvalidValue("123", "1");
        String inCorrectName = signUpPage.getErrorEmailText();
        Assert.assertEquals("Некорректный e-mail", inCorrectName);
    }

    @Test
    public void SignUpWithOutCheckBox(){
        signUpPage.loginWithoutCheckBox("test@gmail.com", "123QWE123");
        String error = signUpPage.getErrorCheckBoxText();
        Assert.assertEquals("Для регистрации аккаунта необходимо ваше согласие с Политикой конфиденциальности и Пользовательским соглашением", error);
    }
    

}
