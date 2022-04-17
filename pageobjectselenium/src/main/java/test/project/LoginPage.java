package test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@placeholder='Ник или e-mail']");
    private By passwordField = By.xpath("//*[@placeholder='Пароль']");
    private By loginButton = By.className("auth-button_middle");
    private By registerButton = By.linkText("Зарегистрироваться на Onlíner");
    private By namePage = By.className("auth-form__title_condensed-default");
    private By error = By.className( "auth-form__description_error");
    private By errorEmptyEmail = By.xpath("//*[normalize-space(text())='Укажите ник или e-mail']");
    private By errorEmptyPassword = By.xpath("//*[normalize-space(text())='Укажите пароль']");
    private By errorIncorrectCreds = By.xpath("//*[normalize-space(text())='Неверный логин или пароль']");


    public LoginPage enterLogin(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String passwrod){
        driver.findElement(passwordField).sendKeys(passwrod);
        return this;
    }

    public LoginPage login(String username, String password){
        this.enterLogin(username);
        this.enterPassword(password);
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    
    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(registerButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadinText(){
        return driver.findElement(namePage).getText();
    }

    public String getErrorEmptyEmailText(){
        return driver.findElement(errorEmptyEmail).getText();
    }

    public String getErrorEmptyPasswrodText(){
        return driver.findElement(errorEmptyPassword).getText();
    }

    public String getErrorInvalidCredsText(){
        return driver.findElement(errorIncorrectCreds).getText();
    }


    
}
