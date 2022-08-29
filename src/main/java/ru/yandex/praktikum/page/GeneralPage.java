package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

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

    @Step("Нажата кнопка Войти в аккаунт на главной странице")
    public LoginPage clickMainLogInButton() {
        mainLogInButton.click();
        return page(LoginPage.class);
    }

    @Step("Нажата кнопка Конструктор в хэдере")
    public GeneralPage clickHeaderConstructorButton() {
        headerConstructorButton.click();
        return this;
    }

    @Step("Нажат логотип в хэдере  Stellar Burgers")
    public GeneralPage clickHeaderLogo() {
        burgerLogo.click();
        return this;
    }

    @Step("Нажата кнопка Личный кабинет в хэдере")
    public LoginPage clickHeaderAccountButton() {
        headerPersonalAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("В конструкторе нажата кнопка Булки")
    public GeneralPage clickConstructorBunButton() {
        if (!returnTrueIfElementPressed(constructorBunButton)) {
            constructorBunButton.click();
        }
        return this;
    }

    @Step("В конструкторе нажата кнопка Соусы")
    public GeneralPage clickConstructorSaucesButton() {
        if (!returnTrueIfElementPressed(constructorSaucesButton)) {
            constructorSaucesButton.click();
        }
        return this;
    }

    @Step("В конструкторе нажата кнопка Начинки")
    public GeneralPage clickConstructorFillingButton() {
        if (!returnTrueIfElementPressed(constructorFillingButton)) {
            constructorFillingButton.click();
        }
        return this;
    }

    @Step("Отображается раздел с булками")
    public boolean returnTrueIfBunSectionIsDisplayed() {
        return constructorBunSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Отображается раздел с соусами")
    public boolean returnTrueIfSaucesSectionIsDisplayed() {
        return constructorSaucesSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Отображается раздел с начинкой")
    public boolean returnTrueIfFillingSectionIsDisplayed() {
        return constructorFillingSectionInList.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Открыта страница регистрации")
    public RegistrationPage openRegisterPage() {
        open("https://stellarburgers.nomoreparties.site/register");
        return page(RegistrationPage.class);
    }

    @Step("Открыта страница авторизации")
    public LoginPage openLoginPage() {
        open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        return page(LoginPage.class);
    }

    @Step("Открыта страница восстановления пароля")
    public RestorePasswordPage openRestorePasswrodPage() {
        open("https://stellarburgers.nomoreparties.site/forgot-password", RestorePasswordPage.class);
        return page(RestorePasswordPage.class);
    }

    @Step("Если авторизация прошла успешно, то отображается кнопка Заказа")
    public boolean returnTrueIfCreateOrderButtonExist() {
        return createOrderButton.shouldBe(Condition.visible).exists();
    }

    @Step("Открыта главная страница")
    public boolean returnTrueIfOpenConstructor() {
        return textCreateBurger.shouldBe(Condition.visible).exists();
    }

    @Step("Проверка что раздел в конструкторе открыт")
    private boolean returnTrueIfElementPressed(SelenideElement element) {
        return element.has(Condition.attributeMatching("class", ".*current.*"));
    }


}
