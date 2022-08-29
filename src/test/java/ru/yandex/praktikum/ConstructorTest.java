package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.driver.DriverInitialization;
import ru.yandex.praktikum.page.GeneralPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    GeneralPage generalPage;

    @Before
    public void setUp() {
        new DriverInitialization().startBrowser();
        generalPage = open("https://stellarburgers.nomoreparties.site/", GeneralPage.class);
    }

    @Test
    public void openSectionBunTest() {
        boolean expect = generalPage
                .clickConstructorBunButton()
                .returnTrueIfBunSectionIsDisplayed();

        assertTrue(expect);
    }

    @Test
    public void openSectionSaucesTest() {
        boolean expect = generalPage
                .clickConstructorSaucesButton()
                .returnTrueIfSaucesSectionIsDisplayed();

        assertTrue(expect);
    }

    @Test
    public void openSectionFillingTest() {
        boolean expect = generalPage
                .clickConstructorFillingButton()
                .returnTrueIfFillingSectionIsDisplayed();

        assertTrue(expect);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
