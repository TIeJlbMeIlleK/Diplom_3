package registrationTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePageLocators;
import pageObjects.LoginPageLocators;
import pageObjects.RegistrationPageLocators;

import static org.junit.Assert.assertTrue;

public class RegistrationWithBadPasswordTest {
    WebDriver driver;

    @Before
    public void beforeStart() {
        ChromeOptions options = new ChromeOptions();
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
        registrationPageLocators.doFullRegistration("VEvgrafov", "VEvgrafov-IITDGroup@yandex.ru", "VEvgr");
        WebElement element = driver.findElement((By.xpath("//fieldset[3]/div/p")));

        // Проверяем, что элемент присутствует с помощью assertTrue
        assertTrue(element.isDisplayed());
    }


    @After
    public void quit() {
        driver.quit();
    }

}
