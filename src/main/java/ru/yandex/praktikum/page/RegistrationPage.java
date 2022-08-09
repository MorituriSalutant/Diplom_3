package ru.yandex.praktikum.page;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

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

    public boolean returnTrueIfRegistrationSuccess(){
        return textOnLoginPage.isDisplayed();
    }

}
