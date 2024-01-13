package homePageTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePageLocators;

public class CheckTransitionToSaucesTest {
    WebDriver driver;

    @Before
    public void beforeStart() {
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
    public void checkTransitionToSaucesTest() {
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.waitForOpenPage();
        homePageLocators.clickOnSauces();
        homePageLocators.checkTransitionToSauces();
    }


    @After
    public void quit() {
        driver.quit();
    }
}
