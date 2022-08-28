package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.helper.GenerateData;
import ru.yandex.praktikum.helper.api.UserReqJson;
import ru.yandex.praktikum.page.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private UserReqJson userReqJson;
    private RegistrationPage registrationPage;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        userReqJson = GenerateData.generateUserAccount();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        name = userReqJson.getName();
        email = userReqJson.getEmail();
        password = userReqJson.getPassword();

    }

    @Test
    public void successRegistrationTest() {
        registrationPage
                .inputNameEmailPasswordAndRegister(name, email, password);

        assertTrue(registrationPage.returnTrueIfRegistrationSuccess());
    }

    @Test
    public void returnErrorIfShortPasswordTest() {
        registrationPage
                .inputNameEmailPasswordAndRegister(name, email, "12345");

        assertTrue(registrationPage.returnTrueIfShowShortPasswordError());

    }

    @After
    public void tearDown() {
        closeWebDriver();
        GenerateData.deleteUserAccount(userReqJson);
    }
}
