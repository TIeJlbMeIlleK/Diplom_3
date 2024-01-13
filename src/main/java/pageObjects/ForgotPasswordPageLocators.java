package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPageLocators {
    private WebDriver driver;

    private By goToHomePage = By.xpath("//a[@aria-current='page' and @class='active']");
    private By emailText = By.xpath("//fieldset[1]/div/div/input[@type='text']");
    private By recoverButton = By.xpath(".//button[text()='Восстановить']");
    private By loginButton = By.xpath("//a[@href='/login']");

    public ForgotPasswordPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Подождали открытия вкладки с восстановлением пароля")
    public void waitForOpenPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(recoverButton));
    }


    @Step("Заполнили Email")
    public void setTextOnFieldEmail(String text){
        driver.findElement(emailText).click();
        driver.findElement(emailText).clear();
        driver.findElement(emailText).sendKeys(text);
    }

    @Step("Нажали на кнопку Восстановить")
    public void clickOnRecoverButton(){
        driver.findElement(recoverButton).click();
    }

    @Step("Нажали на кнопку Войти")
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Вернулись на домашнюю страницу")
    public void clickOnGoToHomePage(){
        driver.findElement(goToHomePage).click();
    }

    @Step("Попытались выполнить восстановление пароля")
    public void doFullRecoverPassword(String email){
        setTextOnFieldEmail(email);
        clickOnRecoverButton();
    }
}
