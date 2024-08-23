package ru.yandex.praktikum.driver;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverInitialization {

    @Step("Создание драйвера")
    public void startBrowser() {
        // Устанавливаем яндекс браузер по умолчанию
        String pathToYandexDriver = "src/main/resources/yandexdriver.exe";
        String pathToOperaDriver99 = "src/main/resources/operadriver.exe";
        String pathToChromeDriver = "src/main/resources/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        System.setProperty("webdriver.opera.driver", pathToOperaDriver99);

        //Настройки браузера
//        ChromeOptions options = new ChromeOptions();
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\perebeyhuy\\AppData\\Local\\Programs\\Opera\\99.0.4788.9_1\\opera.exe");
        options.addArguments("--start-maximized");
        // options.addArguments("--headless");

        //Запуск кастомного драйвера
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new OperaDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}
