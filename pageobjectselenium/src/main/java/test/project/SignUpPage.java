package test.project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By pageName = By.className("auth-form__title_condensed-default");
    private By emailField = By.cssSelector("input[placeholder='Ваш e-mail']");
    private By passwordField = By.cssSelector("input[placeholder='Придумайте пароль']");
    private By passworRepeatdField = By.xpath("//*[@placeholder='Повторите пароль']");
    private By agreeCheckBox = By.className("i-checkbox__faux");
    private By registerButton = By.className("auth-button_primary");
    private By errorEmail = By.xpath("//*[normalize-space(text())='Некорректный e-mail']");
    private By errorEmptyEmail = By.xpath("//*[@id='container']/div/div/div/form/div[2]/div/div[5]/div/div/div[2]/div");
    private By errorPassword = By.xpath("//*[normalize-space(text())='Пароль должен быть от 8 до 64 символов']");
    private By errorEmptyCheckBox = By.className("growl-content");
    private By errorPasswordNotMatch = By.xpath("//*[normalize-space(text())='Пароли не совпадают']");



    public SignUpPage enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String passwrod){
        driver.findElement(passwordField).sendKeys(passwrod);
        return this;
    }

    public SignUpPage enterRepeatPassword(String passwrod){
        driver.findElement(passworRepeatdField).sendKeys(passwrod);
        return this;
    }

    public SignUpPage enterBadPassword(String badpassword){
        driver.findElement(passworRepeatdField).sendKeys(badpassword);
        return this;
    }

    public SignUpPage clickCheckBox(){
        driver.findElement(agreeCheckBox).click();
        return this;
    }

    public SignUpPage loginWithInvalidValue(String username, String password){
        this.enterEmail(username);
        this.enterPassword(password);
        this.enterRepeatPassword(password);
        this.clickCheckBox();
        driver.findElement(registerButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage loginWithoutCheckBox(String username, String password){
        this.enterEmail(username);
        this.enterPassword(password);
        this.enterRepeatPassword(password);
        driver.findElement(registerButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage loginWithBadPassword(String username, String password, String badpassword){
        this.enterEmail(username);
        this.enterPassword(password);
        this.enterBadPassword(badpassword);
        this.clickCheckBox();
        driver.findElement(registerButton).click();
        return new SignUpPage(driver);
    }

    public String getPageNameText(){
        return driver.findElement(pageName).getText();
    }

    public String getErrorEmailText(){
        return driver.findElement(errorEmail).getText();
    }

    public String getErrorEmptyEmailText(){
        return driver.findElement(errorEmptyEmail).getText();
    }
    
    public String getErrorPasswordText(){
        return driver.findElement(errorPassword).getText();
    }

    public String getErrorCheckBoxText(){
        return driver.findElement(errorEmptyCheckBox).getText();
    }

    public String getErrorPasswordNotMatchText(){
        return driver.findElement(errorPasswordNotMatch).getText();
    }
}
