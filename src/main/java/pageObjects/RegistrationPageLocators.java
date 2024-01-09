package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageLocators {
    private WebDriver driver;

    private By nameText = By.xpath("//fieldset[1]/div/div/input[@type='text']");
    private By emailText = By.xpath("//fieldset[2]/div/div/input[@type='text']");
    private By passwordText = By.xpath(".//input[@type='password']");
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath("//a[@href='/login']");

    public RegistrationPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Подождали открытия страницы с регистрацией")
    public void waitForOpenPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }

    @Step("Заполнили name")
    public void setTextOnFieldName(String name) {
        driver.findElement(nameText).click();
        driver.findElement(nameText).clear();
        driver.findElement(nameText).sendKeys(name);
    }

    @Step("Заполнили Email")
    public void setTextOnFieldEmail(String text) {
        driver.findElement(emailText).click();
        driver.findElement(emailText).clear();
        driver.findElement(emailText).sendKeys(text);
    }

    @Step("Заполнили пароль")
    public void setTextOnFieldPassword(String text) {
        driver.findElement(passwordText).click();
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(text);
    }

    @Step("Нажали на кнопку Зарегистрироваться")
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажали на кнопку Войти")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Выполняем регистрацию клиента")
    public void doFullRegistration(String name, String email, String password) {
        setTextOnFieldName(name);
        setTextOnFieldEmail(email);
        setTextOnFieldPassword(password);
        clickOnRegisterButton();
    }
}
