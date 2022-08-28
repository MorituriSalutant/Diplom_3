package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    //Кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement textCreateBurger;

    //Текст Соберите бургер
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

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

    public LoginPage clickHeaderAccountWithoutAuthButton() {
        headerPersonalAccountButton.click();
        return page(LoginPage.class);
    }

    public UserAccountPage clickHeaderAccountWithAuthButton() {
        headerPersonalAccountButton.click();
        return page(UserAccountPage.class);
    }

    public void clickMainCreateOrderButton() {
        createOrderButton.click();
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


}
