package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAreaPageLocators {
    private WebDriver driver;
    private By profileInfo = By.xpath("//a[@href='/account/profile']");
    private By constructor = By.xpath(".//a[@href='/' and contains(@class, 'AppHeader_header')]");
    private By stellarBurger = By.xpath(".//div/header/nav/div[contains(@class, 'AppHeader_header')]");
    private By quitButton = By.xpath(".//button[text()='Выход']");


    public PersonalAreaPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверили отображения информации в личном кабинете")
    public boolean checkProfile(){
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(profileInfo));
        return element.isDisplayed();
    }

    @Step("Нажали на кнопку Конструктор")
    public void clickOnConstructor(){
        driver.findElement(constructor).click();
    }

    @Step("Нажали на кнопку Stellar Burger")
    public void clickStellarBurgerButton(){
        driver.findElement(stellarBurger).click();
    }

    @Step("Нажали на кнопку Выход")
    public void logoutFromAccount(){
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(quitButton));
        driver.findElement(quitButton).click();
    }

}
