package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocators {
    private WebDriver driver;

    private By stellarBurger = By.xpath(".//a[@aria-current='page' and @class='active']");
    private By goToPersonalArea = By.xpath("//p[text()='Личный Кабинет']");
    private By doLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    private By buns = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private By sauces = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private By fillings = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    public HomePageLocators(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Подождали загрузки домашней страницы")
    public void waitForOpenPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stellarBurger));
    }

    @Step("Перешли в личный кабинет")
    public void clickOnGoPersonalArea() {
        driver.findElement(goToPersonalArea).click();
    }

    @Step("Нажали на кнопку Войти в аккаунт")
    public void clickOnLoginButton() {
        driver.findElement(doLogin).click();
    }

    @Step("Нажали на вкладку Булки")
    public void clickOnBuns() {
        driver.findElement(buns).click();
    }

    @Step("Нажали на вкладку Соусы")
    public void clickOnFillings() {
        driver.findElement(fillings).click();
    }

    @Step("Нажали на вкладку Начинки")
    public void clickOnSauces() {
        driver.findElement(sauces).click();
    }

    @Step("Проверили переход на домашнюю страницу")
    public boolean checkTransitionToHomeAfterAuthorizationPage() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(orderButton));
        return element.isDisplayed();
    }
}

