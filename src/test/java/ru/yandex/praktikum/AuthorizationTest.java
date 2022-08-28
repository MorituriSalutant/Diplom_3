package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.helper.GenerateData;
import ru.yandex.praktikum.helper.api.UserApiClient;
import ru.yandex.praktikum.helper.api.UserReqJson;
import ru.yandex.praktikum.page.GeneralPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest {
    private UserReqJson userReqJson;
    private GeneralPage generalPage;
    private String email;
    private String password;

    @Before
    public void setUp() {
        UserApiClient userApiClient = new UserApiClient();
        userReqJson = GenerateData.generateUserAccount();
        userApiClient.createUser(userReqJson);
        generalPage = open("https://stellarburgers.nomoreparties.site/", GeneralPage.class);
        email = userReqJson.getEmail();
        password = userReqJson.getPassword();
    }

    @Test
    public void successLoginFromMainPageButtonLogInTest() {
        generalPage.clickMainLogInButton()
                .inputEmailPasswordAndLogIn(email, password);

        assertTrue(generalPage.returnTrueIfCreateOrderButtonExist());
    }

    @Test
    public void successLoginFromMainPageHeaderButtonAccountTest() {
        generalPage.clickHeaderAccountButton()
                .inputEmailPasswordAndLogIn(email, password);

        assertTrue(generalPage.returnTrueIfCreateOrderButtonExist());
    }

    @Test
    public void successLoginFromRegistrationPageAccountTest() {
        generalPage.openRegisterPage()
                .clickHyperLinkLogIn()
                .inputEmailPasswordAndLogIn(email, password);

        assertTrue(generalPage.returnTrueIfCreateOrderButtonExist());
    }

    @Test
    public void successLoginFromRestorePasswordTest() {
        generalPage.openRestorePasswrodPage()
                .clickHyperLogIn()
                .inputEmailPasswordAndLogIn(email, password);

        assertTrue(generalPage.returnTrueIfCreateOrderButtonExist());
    }

    @After
    public void tearDown() {
        closeWebDriver();
        GenerateData.deleteUserAccount(userReqJson);
    }
}
