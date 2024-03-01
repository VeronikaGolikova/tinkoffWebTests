package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
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

    public String getRandomLetterForSubj() {
        String[] subj = {"e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "g", "h", "l", "c", "v", "b", "n", "m"};
        return faker.options().option(subj);
    }

    public String getRandomHobbie() {
        String[] hobbie = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbie);
    }

    public String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public String getRandomCity(String state) {
        String[] city = null;
        if(state.equals("NCR")) {
            city = new String[]{"Delhi", "Gurgaon", "Noida"};
        } else if (state.equals("Uttar Pradesh")) {
            city = new String[]{"Agra", "Lucknow", "Merrut"};
        } else if (state.equals("Haryana")) {
            city = new String[]{"Karnal", "Panipat"};
        } else if (state.equals("Rajasthan")) {
            city = new String[]{"Jaipur", "Jaiselmer"};
        }
        return faker.options().option(city);
    }
}
