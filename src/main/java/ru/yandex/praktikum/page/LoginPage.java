package ru.yandex.praktikum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends GeneralPage {

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
    private SelenideElement acceptLogInButton;

    //Гиперссылка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement hyperLinkRegister;

    //Гиперссылка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']']")
    private SelenideElement hyperLinkRestorePassword;

    //Кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    public LoginPage setLoginEmail(String email) {
        inputEmail.shouldBe(visible);
        inputEmail.setValue(email);
        return this;
    }

    public LoginPage setLoginPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    private LoginPage inputEmailPassword(String email, String password) {
        setLoginEmail(email);
        setLoginPassword(password);
        return this;
    }

    public LoginPage inputEmailPasswordAndLogIn(String email, String password) {
        inputEmailPassword(email, password)
                .clickAcceptLogInButton();
        return this;
    }


    public GeneralPage clickAcceptLogInButton() {
        acceptLogInButton.click();
        return page(GeneralPage.class);
    }

    public RegistrationPage clickHyperLinkRegister() {
        hyperLinkRegister.click();
        return page(RegistrationPage.class);
    }

    public RestorePasswordPage clickHyperRestorePassword() {
        hyperLinkRestorePassword.click();
        return page(RestorePasswordPage.class);
    }

    public LoginPage clickLogOutButton() {
        logOutButton.click();
        return this;
    }

    public boolean returnTrueIfOpenLogInPage() {
        return textOnLoginPage.shouldBe(Condition.visible).exists();
    }
}
