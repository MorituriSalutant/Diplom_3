package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    //Кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    public LoginPage clickMainLogInButton() {
        mainLogInButton.click();
        return page(LoginPage.class);
    }

    public LoginPage clickHeaderAccountButton() {
        headerPersonalAccountButton.click();
        return page(LoginPage.class);
    }

    public void clickMainCreateOrderButton(){
        createOrderButton.click();
    }

    public RegistrationPage openRegisterPage(){
        open("https://stellarburgers.nomoreparties.site/register");
        return page(RegistrationPage.class);
    }

    public LoginPage openLoginPage(){
        open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        return page(LoginPage.class);
    }

    public RestorePasswordPage openRestorePasswrodPage(){
        open("https://stellarburgers.nomoreparties.site/forgot-password", RestorePasswordPage.class);
        return page(RestorePasswordPage.class);
    }

    public boolean returnTrueIfCreateOrderButtonExist(){
        return createOrderButton.shouldBe(Condition.visible).exists();
    }


}
