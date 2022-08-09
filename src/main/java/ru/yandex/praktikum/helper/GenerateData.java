package ru.yandex.praktikum.helper;

import com.github.javafaker.Faker;

public class GenerateData {
    public String rndName() {
        Faker faker = new Faker();
        return faker.name().name();
    }

    public String rndEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String rndPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
