package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    //Хэдер кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement headerConstructorButton;

    //Хэдер кнопка Лента заказов
    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement headerListOrdersButton;

    //Хэдер кнопка Личный Кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement headerPersonalAccountButton;

    //Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement mainLogInButton;

    //Текст Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement textCreateBurger;

    //Кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //Конструктор Кнопка - Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement constructorBunButton;

    //Конструктор Кнопка - Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement constructorSaucesButton;

    //Конструктор Кнопка - Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement constructorFillingButton;

    //Конструктор раздел в списке - Булки
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement constructorBunSectionInList;

    //Конструктор раздел в списке - Соусы
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement constructorSaucesSectionInList;

    //Конструктор раздел в списке - Начинки
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement constructorFillingSectionInList;

    //Логотип
    @FindBy(how = How.XPATH, using = ".//div/a[@href='/']")
    private SelenideElement burgerLogo;

    public LoginPage clickMainLogInButton() {
        mainLogInButton.click();
        return page(LoginPage.class);
    }

    public GeneralPage clickHeaderConstructorButton() {
        headerConstructorButton.click();
        return this;
    }

    public GeneralPage clickHeaderLogo() {
        burgerLogo.click();
        return this;
    }

    public LoginPage clickHeaderAccountButton() {
        headerPersonalAccountButton.click();
        return page(LoginPage.class);
    }

    public GeneralPage clickConstructorBunButton() {
        if (!returnTrueIfElementPressed(constructorBunButton)) {
            constructorBunButton.click();
        }
        return this;
    }

    public GeneralPage clickConstructorSaucesButton() {
        if (!returnTrueIfElementPressed(constructorSaucesButton)) {
            constructorSaucesButton.click();
        }
        return this;
    }

    public GeneralPage clickConstructorFillingButton() {
        if (!returnTrueIfElementPressed(constructorFillingButton)) {
            constructorFillingButton.click();
        }
        return this;
    }

    public boolean returnTrueIfBunSectionIsDisplayed() {
        return constructorBunSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean returnTrueIfSaucesSectionIsDisplayed() {
        return constructorSaucesSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean returnTrueIfFillingSectionIsDisplayed() {
        return constructorFillingSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    public RegistrationPage openRegisterPage() {
        open("https://stellarburgers.nomoreparties.site/register");
        return page(RegistrationPage.class);
    }

    public LoginPage openLoginPage() {
        open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        return page(LoginPage.class);
    }

    public RestorePasswordPage openRestorePasswrodPage() {
        open("https://stellarburgers.nomoreparties.site/forgot-password", RestorePasswordPage.class);
        return page(RestorePasswordPage.class);
    }

    public boolean returnTrueIfCreateOrderButtonExist() {
        return createOrderButton.shouldBe(Condition.visible).exists();
    }

    public boolean returnTrueIfOpenConstructor() {
        return textCreateBurger.shouldBe(Condition.visible).exists();
    }

    private boolean returnTrueIfElementPressed(SelenideElement element) {
        return element.has(Condition.attributeMatching("class", ".*current.*"));
    }


}
