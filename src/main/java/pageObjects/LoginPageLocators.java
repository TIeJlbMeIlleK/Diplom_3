package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageLocators {
    private WebDriver driver;

    private By goToHomePage = By.xpath("//a[@aria-current='page' and @class='active']");
    private By emailText = By.xpath(".//input[@type='text']");
    private By passwordText = By.xpath(".//input[@type='password']");
    private By doLogin = By.xpath(".//button[text()='Войти']");
    private By registerButton = By.xpath("//a[@href='/register']");
    private By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");
    private String email = "VEvgrafov-IITDGroup@yandex.ru";
    private String pass = "VEvgrafov";

    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Подождали открытия страницы для входа")
    public void waitForOpenPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(doLogin));
    }

    @Step("Заполнили Email")
    public void setTextOnFieldEmail(String text){
        driver.findElement(emailText).click();
        driver.findElement(emailText).clear();
        driver.findElement(emailText).sendKeys(text);
    }

    @Step("Заполнили password")
    public void setTextOnFieldPassword(String text){
        driver.findElement(passwordText).click();
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(text);
    }

    @Step("Авторизовались в системе")
    public void authorization(){
        setTextOnFieldEmail(email);
        setTextOnFieldPassword(pass);
        clickOnLoginButton();
    }

    @Step("Нажали на кнопку войти")
    public void clickOnLoginButton(){
        driver.findElement(doLogin).click();
    }

    @Step("Нажали на кнопку Зарегистрироваться")
    public void clickOnRegisterButton(){
        driver.findElement(registerButton).click();
    }

    @Step("Нажали на кнопку Восстановить пароль")
    public void clickOnForgotPasswordButton(){
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Вернулись на домашнюю страницу")
    public void goHomePage(){
        driver.findElement(goToHomePage).click();
    }


    @Step("Проверили переход на страницу авторизации")
    public boolean checkTransitionToAuthorizationPage(){
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(doLogin));
        return element.isDisplayed();
    }

}
