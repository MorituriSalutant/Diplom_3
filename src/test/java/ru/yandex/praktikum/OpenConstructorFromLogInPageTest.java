package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.driver.DriverInitialization;
import ru.yandex.praktikum.page.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class OpenConstructorFromLogInPageTest {
    private LoginPage loginPage;

    @Before
    public void setUp() {
        new DriverInitialization().startBrowser();
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
    }

    @Test
    public void openConstructorViaHeaderFromAuthPageTest() {
        loginPage.clickHeaderConstructorButton();

        assertTrue(loginPage.returnTrueIfOpenConstructor());
    }

    @Test
    public void openConstructorViaLogoFromAuthPageTest() {
        loginPage.clickHeaderLogo();

        assertTrue(loginPage.returnTrueIfOpenConstructor());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
