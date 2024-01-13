package loginTests;

import api.ClientApi;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePageLocators;
import pageObjects.LoginPageLocators;
import pageObjects.RegistrationPageLocators;

import static org.junit.Assert.assertTrue;

public class LoginOnRegisterPageTest {
    WebDriver driver;

    @Before
    public void beforeStart() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ClientApi clientApi = new ClientApi();
        clientApi.createClient();

        ChromeOptions options = new ChromeOptions();
        /**
         * При необходимости проверить в Yandex браузере, нужно раскомментировать строчку с пометкой TODO и указать в нем ссылку на браузер
         * Так же необходимо убелиться что версия браузера Яндекса и драйвера совпадают!
         */
        //TODO options.setBinary("C:\\Users\\vevgrafov\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void loginOnRegisterPageTest() {
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.waitForOpenPage();
        homePageLocators.clickOnLoginButton();

        LoginPageLocators loginPageLocators = new LoginPageLocators(driver);
        loginPageLocators.waitForOpenPage();
        loginPageLocators.clickOnRegisterButton();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickOnLoginButton();

        loginPageLocators.waitForOpenPage();
        loginPageLocators.authorization();

        homePageLocators.checkTransitionToHomeAfterAuthorizationPage();
    }

    @After
    public void quit(){
        ClientApi.deleteClient(ClientApi.loginAndExtractAccessTokenOfClient());
        driver.quit();
    }
}
