package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {

    //Страница Входа
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement textOnLoginPage;

    //Поле Email.
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/parent::div//input")
    private SelenideElement inputEmail;

    //Поле Пароль.
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/parent::div//input")
    private SelenideElement inputPassword;

    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonLogin;

    public LoginPage setLoginEmail(String email) {
        inputEmail.shouldBe(visible);
        inputEmail.setValue(email);
        return this;
    }

    public LoginPage setLoginPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        buttonLogin.click();
        return this;
    }
}
