package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page.GeneralPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class OpenPersonalAccountTest {
    private GeneralPage generalPage;

    @Before
    public void setUp() {
        generalPage = open("https://stellarburgers.nomoreparties.site/", GeneralPage.class);
    }

    @Test
    public void openPersonalAccountTest() {
        generalPage.clickHeaderAccountButton();

        assertEquals(url(), "https://stellarburgers.nomoreparties.site/login");
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
