package homePageTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePageLocators;

public class CheckTransitionToIngridientsTest {
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
        homePageLocators.clickAndCheckTransitionToFillings();
        homePageLocators.clickAndCheckTransitionToBuns();
        homePageLocators.clickAndCheckTransitionToSauces();
    }


    @After
    public void quit() {
        driver.quit();
    }
}
