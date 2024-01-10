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

public class LoginOnPersonalAreaPageTest {
    WebDriver driver;

    @Before
    public void beforeStart() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ClientApi clientApi = new ClientApi();
        clientApi.createClient();

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
        loginPageLocators.authorization("VEvgrafov-IITDGroup@yandex.ru","VEvgrafov");

        homePageLocators.checkTransitionToHomeAfterAuthorizationPage();
    }


    @After
    public void quit(){
        ClientApi.deleteClient(ClientApi.loginAndExtractAccessTokenOfClient());
        driver.quit();
    }
}
