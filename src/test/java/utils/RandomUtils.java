package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female"};
        return faker.options().option(genders);
    }

    public String getRandomPhoneNumber(int len) {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return faker.options().option(month);
    }

    public static String getRandomDate() {
        String randomDate = String.valueOf(getRandomInt(1, 28));
        if (randomDate.length() == 1) {
            randomDate = "0" + randomDate;
        };
        return randomDate;
    }
}
