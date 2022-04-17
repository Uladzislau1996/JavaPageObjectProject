package test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By enterButton = By.className("auth-bar__item--text");

    public LoginPage clickEnter(){
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }


}
