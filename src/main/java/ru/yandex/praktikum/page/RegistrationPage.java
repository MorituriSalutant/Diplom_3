package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends GeneralPage {

    //Поле Имя.
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/parent::div//input")
    private SelenideElement inputName;

    //Поле Email.
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/parent::div//input")
    private SelenideElement inputEmail;

    //Поле Пароль.
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/parent::div//input")
    private SelenideElement inputPassword;

    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegister;

    //Ошибка короткого пароля
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorPassword;

    //Страница Входа
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement textOnLoginPage;

    public RegistrationPage setRegName(String name) {
        inputName.setValue(name);
        return this;
    }

    public RegistrationPage setRegEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public RegistrationPage setRegPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        buttonRegister.click();
        return this;
    }

    public boolean returnTrueIfShowShortPasswordError() {
        return errorPassword.exists();
    }

    public RegistrationPage inputNameEmailPassword(String name, String email, String password) {
        setRegName(name).
                setRegEmail(email).
                setRegPassword(password);
        return this;
    }

    public boolean returnTrueIfRegistrationSuccess() {
        return textOnLoginPage.shouldBe(Condition.visible).exists();
    }

}
