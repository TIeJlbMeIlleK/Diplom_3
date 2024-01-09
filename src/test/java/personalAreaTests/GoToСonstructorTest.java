package personalAreaTests;

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
import pageObjects.PersonalAreaPageLocators;

public class GoToСonstructorTest {

    WebDriver driver;


    @Before
    public void beforeStart() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ClientApi clientApi = new ClientApi();
        clientApi.createClient();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        HomePageLocators homePageLocators = new HomePageLocators(driver);
        LoginPageLocators loginPageLocators = new LoginPageLocators(driver);
        homePageLocators.waitForOpenPage();
        homePageLocators.clickOnLoginButton();

        loginPageLocators.waitForOpenPage();
        loginPageLocators.authorization("VEvgrafov-IITDGroup@yandex.ru", "VEvgrafov");
    }

    @Test
    public void test() {
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.clickOnGoPersonalArea();

        PersonalAreaPageLocators personalAreaPageLocators = new PersonalAreaPageLocators(driver);
        personalAreaPageLocators.checkProfile();

        personalAreaPageLocators.clickOnConstructor();
        homePageLocators.checkTransitionToHomeAfterAuthorizationPage();
    }

    @After
    public void quit() {
        ClientApi.deleteClient(ClientApi.loginAndExtractAccessTokenOfClient());
        driver.quit();
    }

}
