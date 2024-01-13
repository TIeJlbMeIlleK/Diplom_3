package pageObjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocators {
    private final WebDriver driver;

    private final By stellarBurger = By.xpath(".//a[@aria-current='page' and @class='active']");
    private final By goToPersonalArea = By.xpath("//p[text()='Личный Кабинет']");
    private final By doLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buns = By.xpath(".//span[text()='Булки']");
    private final By parentElementBuns = By.xpath(".//span[text()='Булки']/..");
    private final By sauces = By.xpath(".//span[text()='Соусы']");
    private final By parentElementSauces = By.xpath(".//span[text()='Соусы']/..");
    private final By fillings = By.xpath(".//span[text()='Начинки']");
    private final By parentElementFillings = By.xpath(".//span[text()='Начинки']/..");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");


    private String initialBunsClass;
    private String initialSaucesClass;
    private String initialFillingsClass;

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
        initialBunsClass = driver.findElement(parentElementBuns).getAttribute("class");
        driver.findElement(buns).click();
    }

    @Step("Проверили что у элемента вкладки Булки изменился класс")
    public void checkTransitionToBuns() {
        WebElement updatedElement = driver.findElement(parentElementBuns);
        Assert.assertNotEquals("Класс элемента не изменился", initialBunsClass, updatedElement.getAttribute("class"));
    }

    @Step("Нажали на вкладку Начинки")
    public void clickOnFillings() {
        initialFillingsClass = driver.findElement(parentElementFillings).getAttribute("class");
        driver.findElement(fillings).click();
    }

    @Step("Проверили что у элемента вкладки Начинки изменился класс")
    public void checkTransitionToFillings() {
        WebElement updatedElement = driver.findElement(parentElementFillings);
        Assert.assertNotEquals("Класс элемента не изменился", initialFillingsClass, updatedElement.getAttribute("class"));
    }

    @Step("Нажали на вкладку Соусы")
    public void clickOnSauces() {
        initialSaucesClass = driver.findElement(parentElementFillings).getAttribute("class");
        driver.findElement(sauces).click();
    }

    @Step("Проверили что у элемента вкладки Соусы изменился класс")
    public void checkTransitionToSauces() {
        WebElement updatedElement = driver.findElement(parentElementSauces);
        Assert.assertNotEquals("Класс элемента не изменился", initialSaucesClass, updatedElement.getAttribute("class"));
    }

    @Step("Проверили переход на домашнюю страницу")
    public void checkTransitionToHomeAfterAuthorizationPage() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(orderButton));
        Assert.assertTrue("Элемент не отображается на странице", element.isDisplayed());
    }
}

