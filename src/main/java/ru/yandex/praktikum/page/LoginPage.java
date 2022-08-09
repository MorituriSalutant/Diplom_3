package ru.yandex.praktikum.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

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
