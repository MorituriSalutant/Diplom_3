package ru.yandex.praktikum.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class UserAccountPage extends GeneralPage {

    //Кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    public LoginPage clickLogOutButton() {
        logOutButton.click();
        return page(LoginPage.class);
    }
}
