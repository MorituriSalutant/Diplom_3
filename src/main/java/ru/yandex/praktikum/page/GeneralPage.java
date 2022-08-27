package ru.yandex.praktikum.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    private SelenideElement logInButton;

    public LoginPage clickMainLoginButton() {
        logInButton.click();
        return page(LoginPage.class);
    }


}
