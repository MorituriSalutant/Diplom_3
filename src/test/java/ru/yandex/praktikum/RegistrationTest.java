package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page.LoginPage;
import ru.yandex.praktikum.page.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/register",LoginPage.class);
    }

    @Test
    public void hello() {
        registrationPage
                .setRegName("Привет")
                .setRegEmail("test123312@test.com")
                .setRegPassword("Qwerty321456")
                .clickRegistrationButton();
        loginPage.setLoginEmail("test123312@test.com")
                .setLoginPassword("Qwerty321456")
                .clickLoginButton();
        sleep(5000);
    }
}
