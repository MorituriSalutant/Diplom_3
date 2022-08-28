package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.driver.DriverInitialization;
import ru.yandex.praktikum.helper.GenerateData;
import ru.yandex.praktikum.helper.api.UserApiClient;
import ru.yandex.praktikum.helper.api.UserReqJson;
import ru.yandex.praktikum.page.GeneralPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LogOutTest {
    private UserReqJson userReqJson;
    private GeneralPage generalPage;
    private String email;
    private String password;

    @Before
    public void setUp() {
        new DriverInitialization().startBrowser();
        UserApiClient userApiClient = new UserApiClient();
        userReqJson = GenerateData.generateUserAccount();
        userApiClient.createUser(userReqJson);
        generalPage = open("https://stellarburgers.nomoreparties.site/", GeneralPage.class);
        email = userReqJson.getEmail();
        password = userReqJson.getPassword();
    }

    @Test
    public void successLoginFromMainPageButtonLogInTest() {
        boolean expect = generalPage.openLoginPage()
                .inputEmailPasswordAndLogIn(email, password)
                .clickHeaderAccountWithAuthButton()
                .clickLogOutButton().returnTrueIfOpenLogInPage();

        assertTrue(expect);
    }

    @After
    public void tearDown() {
        closeWebDriver();
        GenerateData.deleteUserAccount(userReqJson);
    }
}
