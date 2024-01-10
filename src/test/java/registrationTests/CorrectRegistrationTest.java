package registrationTests;

import api.ClientApi;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePageLocators;
import pageObjects.LoginPageLocators;
import pageObjects.RegistrationPageLocators;

import static org.junit.Assert.assertTrue;

public class CorrectRegistrationTest {
    WebDriver driver;

    @Before
    public void beforeStart() {
        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\vevgrafov\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void test() {
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.waitForOpenPage();
        homePageLocators.clickOnGoPersonalArea();

        LoginPageLocators loginPageLocators = new LoginPageLocators(driver);
        loginPageLocators.waitForOpenPage();
        loginPageLocators.clickOnRegisterButton();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.waitForOpenPage();
        registrationPageLocators.doFullRegistration("VEvgrafov", "VEvgrafov-IITDGroup@yandex.ru","VEvgrafov");
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[text()='Войти']")));

        // Проверяем, что элемент присутствует с помощью assertTrue
        assertTrue(element.isDisplayed());
    }


    @After
    public void quit(){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ClientApi.deleteClient(ClientApi.loginAndExtractAccessTokenOfClient());
        driver.quit();
    }

}
