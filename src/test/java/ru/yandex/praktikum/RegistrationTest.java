package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.helper.GenerateData;
import ru.yandex.praktikum.page.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private RegistrationPage registrationPage;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        GenerateData generateData = new GenerateData();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        name = generateData.rndName();
        email = generateData.rndEmail();
        password = generateData.rndPassword();
    }

    @Test
    public void successRegistration() {
        registrationPage
                .setRegName(name)
                .setRegEmail(email)
                .setRegPassword(password)
                .clickRegistrationButton();

        assertTrue(registrationPage.returnTrueIfRegistrationSuccess());
    }

    @Test
    public void returnErrorIfShortPassword() {
        registrationPage
                .setRegName(name)
                .setRegEmail(email)
                .setRegPassword("12345")
                .clickRegistrationButton();

        assertTrue(registrationPage.returnTrueIfShowShortPasswordError());

    }
}
